package com.simeon.GameShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.models.User;
import com.simeon.GameShop.services.UserService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

	@Autowired
	private UserService userService;    
        		
        
	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(@Valid User user, BindingResult result, RedirectAttributes redir) { 
		userService.save(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message", "You successfully registered! You can now login");
	    return redirectView;				
	}
}
