package com.app.walletbuddy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.walletbuddy.service.CategoryImageService;
import com.app.walletbuddy.service.CategoryService;
import com.app.walletbuddy.service.TransactionService;
import com.app.walletbuddy.service.UserService;

@Controller
public class AnalyticsController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryImageService categoryImageService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	

	
	
	
	@RequestMapping(value = "/analytics", method = RequestMethod.GET)
	public String analytics(HttpSession s, Model model) throws ParseException {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		
		
		int userId = (Integer) s.getAttribute("userId");
		 
		
		model.addAttribute("data",new ArrayList(Arrays.asList(new Integer[] {3,4,5,6,7,8})));
		model.addAttribute("dat","123,345,456,567,678,789,999");
		
		model.addAttribute("analyticsPageClass", "active");
		return "analytics";
	}

	
	
	
	@RequestMapping(value = "/piechart", method = RequestMethod.GET)
	public String pieIncome(HttpSession s, Model model) throws ParseException {    // INCOME PIE
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		try {
			int userId = (Integer) s.getAttribute("userId"); 

			List<Object[]> transExpence = this.transactionService.listTransactionsSumByExpenceCategories(userId);
			List<Object[]> transIncome = this.transactionService.listTransactionsSumByIncomeCategories(userId);

			StringBuilder incomeVals = new StringBuilder(),
					incomeCats = new StringBuilder(),
					expenceVals = new StringBuilder(),
					expenceCats = new StringBuilder();

			for(Object[] row: transIncome) {
				incomeVals.append( String.format("%.02f", row[0])+"," );
				incomeCats.append("'"+row[1].toString()+"'"+",");
			}
			for(Object[] row: transExpence) {
				expenceVals.append( String.format("%.02f", row[0])+"," );
				expenceCats.append("'"+row[1].toString()+"'"+",");
			}

			model.addAttribute("incomeVals", incomeVals.toString());
			model.addAttribute("incomeCats", incomeCats.toString());

			model.addAttribute("expenceVals", expenceVals.toString());
			model.addAttribute("expenceCats", expenceCats.toString());

			model.addAttribute("analyticsPageClass", "active");
			return "/charts/pie";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	@RequestMapping(value = "/piechart2", method = RequestMethod.GET)          //  EXPENCE PIE
	public String pieExpence(HttpSession s, Model model) throws ParseException {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		try {
			int userId = (Integer) s.getAttribute("userId"); 

			List<Object[]> transExpence = this.transactionService.listTransactionsSumByExpenceCategories(userId);

			StringBuilder expenceVals = new StringBuilder(),
					expenceCats = new StringBuilder();

			for(Object[] row: transExpence) {
				expenceVals.append( String.format("%.02f", Float.parseFloat(row[0].toString())*-1) + ",");
				expenceCats.append("'"+row[1].toString()+"'"+",");
			}

			model.addAttribute("expenceVals", expenceVals.toString());
			model.addAttribute("expenceCats", expenceCats.toString());

			model.addAttribute("analyticsPageClass", "active");
			return "/charts/pie2";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	
	
	
	@RequestMapping(value = "/accountbalance", method = RequestMethod.GET)
	public String accountbalance(HttpSession s, Model model) throws ParseException {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		try {
			int userId = (Integer) s.getAttribute("userId");

			List<Object[]> transRaw = this.transactionService.listTransactionsMyWalletBallance(userId);	

			StringBuilder money = new StringBuilder(), 
					dates = new StringBuilder();

			float tmp = 0.0f;
			for(Object[] o : transRaw) {

				tmp += Float.parseFloat( o[0].toString() );

				//			money.append( String.format("%.02f", o[0]) + ",");
				money.append(String.format("%.02f", tmp)+",");

				String[] arr = o[1].toString().split(" ");
				String[] arr2 = arr[0].split("-");

				dates.append("'"+arr2[2]+"-"+arr2[1]+"-"+arr2[0]+"'"+",");

			}



			model.addAttribute("money" ,money.toString());
			model.addAttribute("dates", dates.toString());

			model.addAttribute("analyticsPageClass", "active");
			return "/charts/accountbalance";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	
	
	
	@RequestMapping(value = "/lineareacharts", method = RequestMethod.GET)
	public String lineareacharts(HttpSession s, Model model) throws ParseException {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		
		try {
			int userId = (Integer) s.getAttribute("userId");

			List<Object[]> transAvgRows = this.transactionService.listTransactionsMyWalletBallance(userId);
			List<Object[]> transPosRows = this.transactionService.listTransactionsMyWalletPositiveBallance(userId);

			StringBuilder dates   = new StringBuilder(),
					avg     = new StringBuilder(),
					income  = new StringBuilder(),
					expence = new StringBuilder();

			int index = 0;
			for(Object[] row : transAvgRows) {

				String[] arr = row[1].toString().split(" ");
				String[] arr2 = arr[0].split("-");
				dates.append("'"+arr2[2]+"-"+arr2[1]+"-"+arr2[0]+"'" + "," );
				avg.append(String.format("%.02f",row[0])+",");

				if(transPosRows.size()>index && row[1].toString().equals(transPosRows.get(index)[1].toString())) {
					float avgtmp =  Float.parseFloat( row[0].toString() );
					float postmp =  Float.parseFloat( transPosRows.get(index)[0].toString()) ;
					expence.append( String.format("%.02f", (avgtmp - postmp)) + "," );
					income.append(String.format("%.02f", postmp) + ",");
					index++;
				}
				else {
					float avgtmp =  Float.parseFloat( row[0].toString() ); 
					expence.append( String.format("%.02f", (avgtmp)) + "," );
					income.append( "0 ,");
				}
			}

			model.addAttribute("avg" ,avg.toString());
			model.addAttribute("dates", dates.toString());
			model.addAttribute("income", income.toString());
			model.addAttribute("expence", expence.toString()); 


			model.addAttribute("analyticsPageClass", "active");
			return "/charts/lineareacharts";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	
	
	@RequestMapping(value = "/twolines", method = RequestMethod.GET)
	public String twolines(HttpSession s, Model model) throws ParseException {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		
		
		try {
			int userId = (Integer) s.getAttribute("userId");

			List<Object[]> transAvgRows = this.transactionService.listTransactionsMyWalletBallance(userId);
			List<Object[]> transPosRows = this.transactionService.listTransactionsMyWalletPositiveBallance(userId);

			StringBuilder dates   = new StringBuilder(),
					avg     = new StringBuilder(),
					income  = new StringBuilder(),
					expence = new StringBuilder();

			int index = 0;
			for(Object[] row : transAvgRows) {

				String[] arr = row[1].toString().split(" ");
				String[] arr2 = arr[0].split("-");
				dates.append("'"+arr2[2]+"-"+arr2[1]+"-"+arr2[0]+"'" + "," );
				avg.append(String.format("%.02f",row[0])+",");

				if(transPosRows.size()>index && row[1].toString().equals(transPosRows.get(index)[1].toString())) {
					float avgtmp =  Float.parseFloat( row[0].toString() );
					float postmp =  Float.parseFloat( transPosRows.get(index)[0].toString()) ;
					expence.append( String.format("%.02f", ((avgtmp - postmp)*-1)) + "," );
					income.append(String.format("%.02f", postmp) + ",");
					index++;
				}
				else {
					float avgtmp =  Float.parseFloat( row[0].toString() ); 
					expence.append( String.format("%.02f", (avgtmp*-1)) + "," );
					income.append( "0 ,");
				}
			}

			model.addAttribute("avg" ,avg.toString());
			model.addAttribute("dates", dates.toString());
			model.addAttribute("income", income.toString());
			model.addAttribute("expence", expence.toString());



			model.addAttribute("analyticsPageClass", "active");
			return "/charts/twolines";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	
	
	
}
