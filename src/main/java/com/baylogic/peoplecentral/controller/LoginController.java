package com.baylogic.peoplecentral.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baylogic.peoplecentral.delegate.LoginDelegate;
import com.baylogic.peoplecentral.pojo.LoginBean;

@Controller
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;
	
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest req,HttpServletResponse res){
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	/*@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest req,HttpServletResponse res){
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}*/
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest req,HttpServletResponse res, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		ModelAndView model = null;
	try{
		boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(),
				loginBean.getPassword());
		if(isValidUser)
		{
			System.out.println("User Login Successful");
			req.setAttribute("loggedInUser", loginBean.getUsername());
			model = new ModelAndView("welcome");
		}
		else 
		{
			System.out.println("User Login Failed");
			//model.addObject("loginBean",loginBean);
			model = new ModelAndView("login");
		    req.setAttribute("message", "Invalid User Credentials!");
		    
	    }
      } catch(Exception e){
    	  e.printStackTrace();
      }
	return model;
	}
}
