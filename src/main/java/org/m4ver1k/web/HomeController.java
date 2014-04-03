package org.m4ver1k.web;

import java.util.Map;

import org.m4ver1k.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
	@Autowired
	private MailService mailService; 
	@RequestMapping(value="/")
	public String homePage()
	{
		return "index"; 
	}
	
	@RequestMapping(value="/forgotPassword")
	public String forgotPassword()
	{
		return "forgotPassword"; 
	}
	
	@RequestMapping(value="/resetPassword" , method=RequestMethod.POST)
	public String resetRequest(@RequestParam(value="email") String email)
	{
		//check if the email id is valid and registered with us.
		mailService.sendMail(email);
		return "checkMail";
	}
	
	@RequestMapping(value="/newPassword/{email}" )
	public String resetPassword(@PathVariable String email,Map<String,String> model)
	{
		//check if the email id is valid and registered with us.
		model.put("emailid", email);
		return "newPassword";
	}

}
