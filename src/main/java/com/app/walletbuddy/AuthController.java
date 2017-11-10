 
package com.app.walletbuddy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.User;
import com.app.walletbuddy.service.CategoryService;
import com.app.walletbuddy.service.TransactionService;
import com.app.walletbuddy.service.UserService;
import com.app.walletbuddy.utils.Helper;
 
@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model, HttpSession s) {
		
		if(s.getAttribute("userName")!=null)
			return "redirect:/transactions";
		
		model.addAttribute("user", new User());
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup/save", method = RequestMethod.POST)
	public String signupSave(@ModelAttribute("user") User u, Model model, HttpSession s) {
		try {
			
			if(!Helper.validateEmail(u.getEmail()))
				return "redirect:/signup";
			

			u.setPhoto("emptyImage.png");
			u.setWallet(0.0f);
			u.setRole("user");
			u.setFirstName(  Helper.cleanInputString( u.getFirstName() ));
			u.setLastName(  Helper.cleanInputString( u.getLastName() ));

			s.setAttribute("userName", u.getFirstName()+" "+u.getLastName());
			s.setAttribute("userRole", "user");
			s.setAttribute("wallet", "<span style='margin-left:-190px; margin-top:10px;font-size:24px; font-weight:bold;position:absolute;color:green;' >"+String.format("%.02f", 0.0f)+"</span>");

			this.userService.addUser(u);

			List<User> users = this.userService.listUsers();
			int lastUser = users.get( users.size()-1 ).getId();

			Category c = new Category();
			c.setUserId(lastUser);
			c.setColor("green");
			c.setImage("Brief-case-icon.png");
			c.setName("Sallary");
			c.setType("Income");
			Category c1 = new Category();
			c1.setUserId(lastUser);
			c1.setColor("red");
			c1.setImage("75780.jpg");
			c1.setName("Bills");
			c1.setType("Expence");

			this.categoryService.addCategory(c);
			this.categoryService.addCategory(c1);

			s.setAttribute("userId", this.userService.getUserByCredentials(u.getEmail(), u.getPassword()).getId()  );
			s.setAttribute("userImage","emptyImage.png");

			return "redirect:/transactions";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession s) {
		
		if(s.getAttribute("userName")!=null)
			return "redirect:/user/settings";
		
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User u, Model model, HttpSession s, RedirectAttributes redir ) {
		
		if(s.getAttribute("userName")!=null)
			return "redirect:/transactions";
		
		try {
			User authUser = this.userService.getUserByCredentials(u.getEmail(), u.getPassword());

			if(authUser!=null) {
				String userName = authUser.getFirstName()+" "+authUser.getLastName();

				s.setAttribute("userName", userName);
				s.setAttribute("userRole", authUser.getRole());
				s.setAttribute("userId", authUser.getId());
				s.setAttribute("wallet", Helper.getWalletCurrentBallance(authUser.getId(), transactionService));
				if(authUser.getPhoto()!=null) 
					s.setAttribute("userImage", authUser.getPhoto());

				return "redirect:/transactions";
			}
			else {  
				redir.addFlashAttribute("userCheckResult", "Sorry - There is No User With Such Credentials! Try again"); 
				return "redirect:/login";
			}
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout( HttpSession s) {
		
		s.invalidate();
		
		return "redirect:/";
	}
}
