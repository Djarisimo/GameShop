package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.User;
import com.simeon.GameShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;    

	@PostMapping(value="users/addNew")
	public RedirectView addNew(@Valid User user, BindingResult result, RedirectAttributes redir) {
		userService.addUser(user);
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message", "You successfully registered! You can now login");
	    return redirectView;				
	}
}
