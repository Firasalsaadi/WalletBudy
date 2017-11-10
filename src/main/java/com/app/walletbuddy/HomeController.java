package com.app.walletbuddy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.CategoryImage;
import com.app.walletbuddy.model.Transaction;
import com.app.walletbuddy.model.User;
import com.app.walletbuddy.service.CategoryImageService;
import com.app.walletbuddy.service.CategoryService;
import com.app.walletbuddy.service.TransactionService;
import com.app.walletbuddy.service.UserService;
import com.app.walletbuddy.utils.TransactionView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpSession s) {
		
		if(s.getAttribute("userName")!=null) {
		  model.addAttribute("signupMsg", " Manage Wallet" );
		  model.addAttribute("loginMsg", s.getAttribute("userName") );
		}
		else {
			model.addAttribute("signupMsg", "Sign Up for free" );
			model.addAttribute("loginMsg", "Login" );
		}
		return "index";
	}

	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutus(Model model, HttpSession s) {
		
		if(s.getAttribute("userName")!=null) {
			model.addAttribute("signupMsg", " Manage Wallet" );
			model.addAttribute("loginMsg", s.getAttribute("userName") );
		}
		else {
			model.addAttribute("signupMsg", "Sign Up for free" );
			model.addAttribute("loginMsg", "Login" );
		}

		return "aboutus";
	}
	
	
	
	
	
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String transactions(HttpSession s, Model model) throws ParseException {     
		 
		try {

			if(s.getAttribute("userName")==null)
				return "redirect:/"; 
			model.addAttribute("homePageClass", "active");

			int userId = (Integer) s.getAttribute("userId"); 

			List<Category> catListIncome  = new ArrayList<Category>(), 
					catListExpence = new ArrayList<Category>();
			List<Category> catList = this.categoryService.listCategory(userId);


			for(Category c : catList) {
				if(c.getType().indexOf("Income")>-1)
					catListIncome.add(c);
				else
					catListExpence.add(c);
			}

			List<TransactionView> tv = new ArrayList<TransactionView>(); 

			List<Object[]> transRaw = this.transactionService.listTransactionsView(userId);
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
				tv.add(_tv);
			}
			model.addAttribute("transactionsView",tv);
			model.addAttribute("catIncome", catListIncome);
			model.addAttribute("catExpence", catListExpence);

			return "transactions";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	 
	
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String settings(HttpSession s, Model model) {
		
		try { 
			if(s.getAttribute("userName")==null)
				return "redirect:/";
			List<CategoryImage> catImages = this.categoryImageService.getCategoryImages();
			model.addAttribute("catImages", catImages); 

			int userId = (Integer) s.getAttribute("userId"); 
			List<Category> catList = this.categoryService.listCategory(userId);
			model.addAttribute("categories", catList);

			model.addAttribute("user", new User());
			model.addAttribute("settingsPageClass", "active");
			return "categories";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(HttpSession s, Model model) {
		if(s.getAttribute("userName")==null || !s.getAttribute("userRole").toString().equals("admin"))
			return "redirect:/";
		
		try {
			int userId = (Integer) s.getAttribute("userId"); 
			List<User> userList = new ArrayList<User>(),
					userListAll = this.userService.listUsers();

			for(User u : userListAll) {
				if(u.getId() != userId) 
					userList.add(u);
			} 

			model.addAttribute("userList",(List) userList);

			model.addAttribute("user", new User());
			model.addAttribute("usersPageClass", "active");
			return "users";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	
	
	@RequestMapping(value = "category/image/{imageName}.{extension}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName,
    					   @PathVariable(value = "extension") String extension) throws IOException {

		String rootPath = servletContext.getRealPath("/resources/");
		String imgLocation = rootPath + File.separator + "categoryImages\\";  
		System.out.println(imgLocation);
        File serverFile = new File(imgLocation+imageName+"."+extension);
        if(serverFile.exists())
          return Files.readAllBytes(serverFile.toPath());
        else return new byte[] {};
    }
}
