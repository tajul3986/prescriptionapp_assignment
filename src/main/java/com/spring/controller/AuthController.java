package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.model.User;
import com.spring.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class AuthController {
	
	@Autowired
    private UserService userService;

	//login
	 @GetMapping("/login")
	    public String loginPage() {
	        return "login";
	    }
	 
	// ✅ Logout
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	 
	    //registration
		@GetMapping("/register")
		public String registerPage() {
			return "register";
		}
		

	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute User user) {
	    	userService.save(user);
	        return "redirect:/login";
	    }
}
