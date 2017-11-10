package com.app.walletbuddy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.Transaction;
import com.app.walletbuddy.service.CategoryService;
import com.app.walletbuddy.service.TransactionService;
import com.app.walletbuddy.utils.Helper;
import com.app.walletbuddy.utils.TransactionView;

@Controller
@RequestMapping("/a/")
public class ajaxFormController {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/ajaxfile", method = RequestMethod.POST)
	@ResponseBody
	public String asd(  @RequestParam("type") String type, 
			            @RequestParam("text") String catName, 
			            @RequestParam("select") String image, HttpSession s) throws IOException {
		String rootPath = "shit happened..";
		if(s.getAttribute("userName")!=null)
		{
			
			Category c = new Category();
			c.setImage(image);
			String catCleanName =  Helper.cleanInputStringFromSpecialChars(catName).length()>16 ? Helper.cleanInputStringFromSpecialChars(catName).substring(0, 16) : Helper.cleanInputStringFromSpecialChars(catName);
			c.setName( catCleanName );    
			c.setType(type);
			int userId = (Integer) s.getAttribute("userId"); 
			c.setUserId(userId);
			String color = type.indexOf("Income")>-1 ? "green" : "red";
			c.setColor(color);

			this.categoryService.addCategory(c);
			List<Category> catList = this.categoryService.listCategory(userId);
			Category lastCat = catList.get(0);

			rootPath = " <div class=\"row tr\" catid='"+lastCat.getId()+"' cat-name='"+lastCat.getName()+"' cat-type='"+lastCat.getType()+"'>" + 
					"      <div class=\"col-sm-6\"><span class=\"svgImg\"><img src=\"./category/image/"+image+"\"  class=\"img-circle\" style='width:50px;margin-left:7px;'><p class=\"par\">"+lastCat.getName()+"</p></span></div>" + 
					"      <div class=\"col-sm-2\"><p class=\"par2\" style='color:"+c.getColor()+"'>"+type+"</p></div>" + 
					"      <div class=\"col-sm-2\"><a class=\"btn\" style=\"margin-left:45px;margin-top: 7px;\" ww=\"1\"> <span " + 
					"							class=\"glyphicon glyphicon-edit\"></span> Edit" + 
					"						</a></div>" + 
					"      <div class=\"col-sm-2\"><a style=\"margin-top: 7px;\" class=\"btn\" www=\"1\"> <span class=\"glyphicon glyphicon-trash\"></span> Delete </a></div>" + 
					"  </div> ";



		}
		return rootPath;
	}
	
	
	
	@RequestMapping(value = "/addtransaction", method = RequestMethod.POST)
	@ResponseBody
	public String asd(  @RequestParam("selectpicker") int catId, 
						@RequestParam("datepicker") String date, 
						@RequestParam("price") String price, 
						@RequestParam("note") String note, HttpSession s) throws IOException, ParseException {
		String rootPath = "shit happened..";
		if(s.getAttribute("userName")!=null)
		{ 
			int userId = (Integer) s.getAttribute("userId");
			
			Category c = this.categoryService.getCategoryById(catId);
			Transaction t = new Transaction();
			t.setCategoryId(catId);
			t.setDate(date);
			t.setNote(  Helper.cleanInputStringFromSpecialChars(note) );
			t.setColor(c.getColor());
			t.setPrice( Float.parseFloat( Helper.checkNumber(price) ) );
			this.transactionService.addTransaction(t, userId); 
			s.setAttribute("wallet", Helper.getWalletCurrentBallance(userId, transactionService));
 
			
			rootPath = " <tr catid='"+c.getId()+"' cat-name='"+c.getName()+"' cat-type='"+c.getType()+"'>" + 
					"      <td class=\"col-sm-6\"><span class=\"svgImg\"><img src=\"./category/image/"+c.getImage()+"\"  class=\"img-circle\" style='width:50px;margin-left:7px;'><p class=\"par\">"+c.getName()+"</p></span></td>" + 
					"      <td class=\"col-sm-2\"><p class=\"par2\" style='color:"+c.getColor()+"'>"+c.getType()+"</p></td>" + 
					"      <td class=\"col-sm-2\"><a class=\"btn\" style=\"margin-left:45px;margin-top: 7px;\" ww=\"1\"> <span " + 
					"							class=\"glyphicon glyphicon-edit\"></span> Edit" + 
					"						</a></td>" + 
					"      <td class=\"col-sm-2\"><a style=\"margin-top: 7px;\" class=\"btn\" www=\"1\"> <span class=\"glyphicon glyphicon-trash\"></span> Delete </a></td>" + 
					"  </tr> ";
			
			
			return "";
		}
		return rootPath;
	}

	
	
	@RequestMapping(value = "/edittransaction/{transId}", method = RequestMethod.POST)
	@ResponseBody
	public String edittrans(  @RequestParam("selectpicker") int catId, 
							  @RequestParam("datepicker") String date, 
							  @RequestParam("price") String price, 
							  @RequestParam("note") String note,
							  @PathVariable(value = "transId") int transId, HttpSession s) throws IOException, ParseException {
		String rootPath = "shit happened..";
		if(s.getAttribute("userName")!=null)
		{ 
			int userId = (Integer) s.getAttribute("userId");
			
			Category c = this.categoryService.getCategoryById(catId);
			Transaction t = new Transaction();
			t.setId(transId);
			t.setCategoryId(catId);
			t.setDate(date);
			t.setNote(  Helper.cleanInputStringFromSpecialChars(note) );
			t.setColor(c.getColor());
			t.setPrice( Float.parseFloat( Helper.checkNumber(price) ) );
			this.transactionService.updateTransaction(t, userId); 
			s.setAttribute("wallet", Helper.getWalletCurrentBallance(userId, transactionService));

			
			
			rootPath = " <tr catid='"+c.getId()+"' cat-name='"+c.getName()+"' cat-type='"+c.getType()+"'>" + 
					"      <td class=\"col-sm-6\"><span class=\"svgImg\"><img src=\"./category/image/"+c.getImage()+"\"  class=\"img-circle\" style='width:50px;margin-left:7px;'><p class=\"par\">"+c.getName()+"</p></span></td>" + 
					"      <td class=\"col-sm-2\"><p class=\"par2\" style='color:"+c.getColor()+"'>"+c.getType()+"</p></td>" + 
					"      <td class=\"col-sm-2\"><a class=\"btn\" style=\"margin-left:45px;margin-top: 7px;\" ww=\"1\"> <span " + 
					"							class=\"glyphicon glyphicon-edit\"></span> Edit" + 
					"						</a></td>" + 
					"      <td class=\"col-sm-2\"><a style=\"margin-top: 7px;\" class=\"btn\" www=\"1\"> <span class=\"glyphicon glyphicon-trash\"></span> Delete </a></td>" + 
					"  </tr> ";
			
			
			return "";
		}
		return rootPath;
	}

	
	@RequestMapping(value = "/deltransaction/{transId}", method = RequestMethod.GET)
	@ResponseBody
	public String deltrans( @PathVariable(value = "transId") int transId, HttpSession s) throws IOException, ParseException {
		String rootPath = "shit happened..";
		if(s.getAttribute("userName")!=null)
		{ 
			int userId = (Integer) s.getAttribute("userId");
			this.transactionService.removeTransaction(transId); 
			s.setAttribute("wallet", Helper.getWalletCurrentBallance(userId, transactionService)); 
			
			return "";
		}
		return rootPath;
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public String filter( @RequestParam("search") String text, HttpSession s) throws IOException, ParseException {
		
		
		if(s.getAttribute("userName")!=null)
		{ 
			StringBuilder sb = new StringBuilder();
			sb.append("<table width='100%'>");
			
			int userId = (Integer) s.getAttribute("userId");
			
			List<TransactionView> tv = new ArrayList<TransactionView>();
			
			
			if(text.length()>0) 
			{
				List<Object[]> transRaw = this.transactionService.listTransactionsViewLike(text, userId); 
			 for(Object[] row : transRaw ) {
				TransactionView _tv = new TransactionView();
				String color = (String) row[3];
				_tv.setColor(color);
				_tv.setCategoryName( (String) row[8] );
				_tv.setImage((String) row[5]);
				_tv.setPrice( (color.indexOf("red")>-1? "-":"") + row[4].toString()  );
				_tv.setNote( (String) row[2] );
				_tv.setTransactionId(Integer.valueOf( row[0].toString())); 
				
				String tmpArr[] = row[1].toString().split(" ");
				tmpArr = tmpArr[0].toString().split("-");
				_tv.setDate( tmpArr[2] + "-" + tmpArr[1] + "-" + tmpArr[0] );
				
				_tv.setCategoryId( Integer.valueOf( row[7].toString()) );
				
				sb.append("<tr class=\"row tr\"><td style=\"padding-left: 8px;width:200px;\">" + 
						"					  <img src=\"./category/image/"+_tv.getImage()+"\" style=\"width:40px;float:left;border-radius:10px;\" />" + 
						"					    <p style=\"width:180px;font-size:16px;margin-top:10px;font-weight: bold;\"> "+_tv.getCategoryName()+"</p></td>");
				sb.append("<td >" + 
						"						<p class=\"par2\" style='margin-left:12px; '>"+_tv.getDate()+"</p>" + 
						"					</td>");
				sb.append("<td style=\"text-align: center;\"> " + 
						"						<p class=\"par2\" style='font-style: italic; font-size: 19px; '>"+_tv.getNote()+"</p> </td>");
				sb.append("<td style=\"text-align: right;\">" + 
						"						<p class=\"par2\" style='margin-right:10px;color:"+_tv.getColor()+"'>"+_tv.getPrice()+"</p> </td ></tr>");
				
			 }
			 sb.append("</table>");
			}
			
			
			return sb.toString();
		}
		return "";
	}

	
	
	
	@RequestMapping(value = "/filterprice", method = RequestMethod.GET)
	@ResponseBody
	public String filterprice( @RequestParam("search") String tprice , HttpSession s) throws IOException, ParseException {
		
		
		if(s.getAttribute("userName")!=null)
		{ 
			StringBuilder sb = new StringBuilder();
			sb.append("<table width='100%'>");
			
			int userId = (Integer) s.getAttribute("userId");
			
			List<TransactionView> tv = new ArrayList<TransactionView>();
			
			
			if(tprice.length()>0) 
			{
				float price = Float.valueOf(tprice);
				List<Object[]> transRaw = this.transactionService.listTransactionsViewPriceBelow(price, userId); 
				for(Object[] row : transRaw ) {
					TransactionView _tv = new TransactionView();
					String color = (String) row[3];
					_tv.setColor(color);
					_tv.setCategoryName( (String) row[8] );
					_tv.setImage((String) row[5]);
					_tv.setPrice( (color.indexOf("red")>-1? "-":"") + row[4].toString()  );
					_tv.setNote( (String) row[2] );
					_tv.setTransactionId(Integer.valueOf( row[0].toString())); 
					
					String tmpArr[] = row[1].toString().split(" ");
					tmpArr = tmpArr[0].toString().split("-");
					_tv.setDate( tmpArr[2] + "-" + tmpArr[1] + "-" + tmpArr[0] );
					
					_tv.setCategoryId( Integer.valueOf( row[7].toString()) );
					
					sb.append("<tr class=\"row tr\"><td style=\"padding-left: 8px;width:200px;\">" + 
							"					  <img src=\"./category/image/"+_tv.getImage()+"\" style=\"width:40px;float:left;border-radius:10px;\" />" + 
							"					    <p style=\"width:180px;font-size:16px;margin-top:10px;font-weight: bold;\"> "+_tv.getCategoryName()+"</p></td>");
					sb.append("<td >" + 
							"						<p class=\"par2\" style='margin-left:12px; '>"+_tv.getDate()+"</p>" + 
							"					</td>");
					sb.append("<td style=\"text-align: center;\"> " + 
							"						<p class=\"par2\" style='font-style: italic; font-size: 19px; '>"+_tv.getNote()+"</p> </td>");
					sb.append("<td style=\"text-align: right;\">" + 
							"						<p class=\"par2\" style='margin-right:10px;color:"+_tv.getColor()+"'>"+_tv.getPrice()+"</p> </td ></tr>");
					
				}
				sb.append("</table>");
			}
			
			
			return sb.toString();
		}
		return "";
	}
	
	
	
	
	@RequestMapping(value = "/filtercategory", method = RequestMethod.GET)
	@ResponseBody
	public String filtercategory( @RequestParam("search") String pattern , HttpSession s) throws IOException, ParseException {
		
		
		if(s.getAttribute("userName")!=null)
		{ 
			StringBuilder sb = new StringBuilder();
			sb.append("<table width='100%'>");
			
			int userId = (Integer) s.getAttribute("userId");
			
			List<TransactionView> tv = new ArrayList<TransactionView>();
			
			
			if(pattern.length()>0) 
			{
				List<Object[]> transRaw = this.transactionService.listTransactionsViewCategories(pattern, userId); 
				for(Object[] row : transRaw ) {
					TransactionView _tv = new TransactionView();
					String color = (String) row[3];
					_tv.setColor(color);
					_tv.setCategoryName( (String) row[8] );
					_tv.setImage((String) row[5]);
					_tv.setPrice( (color.indexOf("red")>-1? "-":"") + row[4].toString()  );
					_tv.setNote( (String) row[2] );
					_tv.setTransactionId(Integer.valueOf( row[0].toString())); 
					
					String tmpArr[] = row[1].toString().split(" ");
					tmpArr = tmpArr[0].toString().split("-");
					_tv.setDate( tmpArr[2] + "-" + tmpArr[1] + "-" + tmpArr[0] );
					
					_tv.setCategoryId( Integer.valueOf( row[7].toString()) );
					
					sb.append("<tr class=\"row tr\"><td style=\"padding-left: 8px;width:200px;\">" + 
							"					  <img src=\"./category/image/"+_tv.getImage()+"\" style=\"width:40px;float:left;border-radius:10px;\" />" + 
							"					    <p style=\"width:180px;font-size:16px;margin-top:10px;font-weight: bold;\"> "+_tv.getCategoryName()+"</p></td>");
					sb.append("<td >" + 
							"						<p class=\"par2\" style='margin-left:12px; '>"+_tv.getDate()+"</p>" + 
							"					</td>");
					sb.append("<td style=\"text-align: center;\"> " + 
							"						<p class=\"par2\" style='font-style: italic; font-size: 19px; '>"+_tv.getNote()+"</p> </td>");
					sb.append("<td style=\"text-align: right;\">" + 
							"						<p class=\"par2\" style='margin-right:10px;color:"+_tv.getColor()+"'>"+_tv.getPrice()+"</p> </td ></tr>");
					
				}
				sb.append("</table>");
			}
			
			
			return sb.toString();
		}
		return "";
	}
	

}
