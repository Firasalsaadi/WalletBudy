package com.app.walletbuddy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.User;
import com.app.walletbuddy.service.CategoryService;
import com.app.walletbuddy.service.TransactionService;
import com.app.walletbuddy.service.UserService;
import com.app.walletbuddy.utils.Helper;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TransactionService transactionService;

	
	@RequestMapping(value = "/delcat/{catId}", method = RequestMethod.GET)
	@ResponseBody
	public String delcat(@PathVariable(value = "catId") int id, HttpSession s) {
		if(s.getAttribute("userName")!=null)
		{
			int userId = (Integer) s.getAttribute("userId");
			this.categoryService.removeCategory(id);
			s.setAttribute("wallet", Helper.getWalletCurrentBallance(userId, transactionService)); 
			return "121323123123";
			
		} 
		return "error";
	}

	@RequestMapping(value = "/deluser/{catId}", method = RequestMethod.GET)
	@ResponseBody
	public String deluser(@PathVariable(value = "catId") int id, HttpSession s) {
		if(s.getAttribute("userName")!=null)
		{
			this.userService.removeUser(id);
			return "121323123123";
			
		} 
		return "error";
	}
	
	
	
	@RequestMapping(value = "/editcat/{catId}", method = RequestMethod.POST)
	@ResponseBody
	public String editcat(@PathVariable(value = "catId") int catId,
						  @RequestParam("type") String type, 
						  @RequestParam("text") String catName, 
						  @RequestParam("select") String image, HttpSession s) {
		if(s.getAttribute("userName")!=null)
		{
//			this.categoryService.removeCategory(id);
//			System.out.println(id);
			Category c = new Category();
			int userId = (Integer) s.getAttribute("userId");
			c.setId(catId);
			c.setUserId(userId);
			c.setImage(image);
			String catCleanName =  Helper.cleanInputStringFromSpecialChars(catName).length()>16 ? Helper.cleanInputStringFromSpecialChars(catName).substring(0, 16) : Helper.cleanInputStringFromSpecialChars(catName);
			c.setName(catCleanName );
			c.setType(type); 
			String color = type.indexOf("Income")>-1 ? "green" : "red";
			c.setColor(color);
			
			categoryService.updateCategory(c);
			s.setAttribute("wallet", Helper.getWalletCurrentBallance(userId, transactionService));
			
			return " <div class=\"row tr\" catid='"+catId+"' cat-name='"+catCleanName+"' cat-type='"+type+"'>" + 
					"      <div class=\"col-sm-6\"><span class=\"svgImg\"><img src=\"./category/image/"+image+"\" class=\"img-circle\" style='width:50px;margin-left:7px;'><p class=\"par\" >"+catCleanName+"</p></span></div>" + 
					"      <div class=\"col-sm-2\"><p class=\"par2\" style='color:"+c.getColor()+"'>"+type+"</p></div>" + 
					"      <div class=\"col-sm-2\"><a class=\"btn\" style=\"margin-left:45px;margin-top: 7px;\" ww=\"1\"> <span " + 
					"							class=\"glyphicon glyphicon-edit\"></span> Edit" + 
					"						</a></div>" + 
					"      <div class=\"col-sm-2\"><a style=\"margin-top: 7px;\" class=\"btn\" www=\"1\"> <span class=\"glyphicon glyphicon-trash\"></span> Delete </a></div>" + 
					"  </div> ";
			
		}
		
		return "error";
	}

	
	@RequestMapping(value = "/edituser/{catId}", method = RequestMethod.POST)
	@ResponseBody
	public String edituser(@PathVariable(value = "catId") int userEditId,
			@RequestParam("role") String role,  HttpSession s) {
		if(s.getAttribute("userName")!=null)
		{
 
			int userId = (Integer) s.getAttribute("userId");
			User activeUser = this.userService.getUserById(userEditId);
			activeUser.setRole(role);
			
			this.userService.updateUser(activeUser); 
			
			return "<div class=\"row tr\"  catId='"+userEditId+"' cat-type='"+role+"' alt=\"asdsa\">" + 
			"					<div class=\"col-sm-7\">" + 
			"						<span class=\"svgImg\"><img src=\"./user/image/"+activeUser.getPhoto()+"\" class=\"img-circle\" style=\"width:50px;margin-left:7px;\">" + 
			"						   <p class=\"par\">"+activeUser.getFirstName()+" "+activeUser.getLastName()+"</p></span>" + 
			"					</div>" + 
			"					<div class=\"col-sm-1\"><p class=\"par2\" style='color:blue'>"+role+" </p></div>" + 
			"					<div class=\"col-sm-2\">" + 
			"					    <a class=\"btn\" style=\"margin-left:45px;margin-top:7px;\" ww=\"1\" onclick=\"editRow(this)\"><span class=\"glyphicon glyphicon-edit\"></span> Edit</a>" + 
			"					</div>" + 
			"					<div class=\"col-sm-2\">" + 
			"						<a class=\"btn\" style=\"margin-top: 7px;\" www=\"1\" onclick=\"deleteRow(this)\"> <span class=\"glyphicon glyphicon-trash\"></span> Delete </a>" + 
			"					</div>" + 
			"				</div>";
			
			
			
			
		}
		
		return "error";
	}
	
	
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String signup(Model model, HttpSession s) {
		
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		try {
			User u = this.userService.getUserById((Integer)s.getAttribute("userId"));
			u.clearPassword();


			model.addAttribute("user", u);
			model.addAttribute("profilePageClass", "active");
			if(u.getPhoto()!=null) {
				s.setAttribute("userImage", u.getPhoto());	
				model.addAttribute("userImage", u.getPhoto());
			}

			return "usersettings";
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/image/{imageName}.{extension}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName,
    					   @PathVariable(value = "extension") String extension) throws IOException {

		String rootPath = servletContext.getRealPath("/resources/");
		String imgLocation = rootPath + File.separator + "tmpFiles\\";
		
        File serverFile = new File(imgLocation+imageName+"."+extension);
        if(serverFile.exists())
          return Files.readAllBytes(serverFile.toPath());
        else return new byte[] {};
    }
	
	
	
	
	
	@RequestMapping(value = "/settings/save", method = RequestMethod.POST)
	public String uploadFileHandler(@ModelAttribute("user") User u, @RequestParam("input-file-preview") MultipartFile file, RedirectAttributes redir, Model model, HttpSession s) {
		if(s.getAttribute("userName")==null)
			return "redirect:/";
		try {
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = servletContext.getRealPath("/resources/");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + file.getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					int userId = (Integer) s.getAttribute("userId");
					User activeUser = this.userService.getUserById(userId);

					u.setFirstName(  Helper.cleanInputString( u.getFirstName() ));
					u.setLastName(  Helper.cleanInputString( u.getLastName() ));
					u.setPhoto(file.getOriginalFilename());
					u.setId( userId );
					u.setWallet(activeUser.getWallet());
					u.setRole(activeUser.getRole());
					
					if(!Helper.validateEmail(u.getEmail()))
						return "redirect:/user/settings";
					
					this.userService.updateUser(u);

					redir.addFlashAttribute("userUpdateStatus", "You have successfully updated your profile");
					return "redirect:/user/settings";  
				} catch (Exception e) {
					redir.addFlashAttribute("userUpdateStatus", e.getMessage());
					return "redirect:/user/settings";
				}
			} else {
				redir.addFlashAttribute("userUpdateStatus", "You failed to upload  because the file was empty");
				return "redirect:/user/settings"; 
			}
		}
		catch(Exception e) { 
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
}
