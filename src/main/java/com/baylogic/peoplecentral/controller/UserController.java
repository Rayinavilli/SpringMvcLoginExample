package com.baylogic.peoplecentral.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;*/

import java.sql.SQLException;

import com.baylogic.peoplecentral.pojo.User;
import com.baylogic.peoplecentral.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/createUser", method=RequestMethod.GET)
	public ModelAndView showAllUsers(HttpServletRequest req,HttpServletResponse res) {
		return new ModelAndView("createUser","user",new User());
	}

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String submit(HttpServletRequest req,HttpServletResponse res, @ModelAttribute("user")User user) throws SQLException {
		String status="duplicate";
		try{
			boolean createUser = userService.createUser(user.getFirstname(),user.getLastname(),
					user.getId(),user.getEmail());
			if(createUser)
			{
				System.out.println("User created successfully");
				status=	"Success";				
			}
			else 
			{
				System.out.println("User creation Failed");
				status= "error";
			}
	      } catch(SQLException se){
	    	  se.printStackTrace();
	    	  if(se.getErrorCode() == 1024){
	    		  status= "duplicate";
	    	  }
	        }
			return 	status;
		}
}