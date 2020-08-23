package com.vr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vr.model.Login;

@Controller
public class LoginController {

	@GetMapping("/")
	public String employeeForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";

	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(@Validated Login login, Model model) {

		if (login.getUserID().equals("admin123") && login.getPassword().equals("admin123")) {
			model.addAttribute("userID", login.getUserID());
			model.addAttribute("password", login.getPassword());
			return "admin/searchRequest";
		} else if (login.getUserID().equals("customer") && login.getPassword().equals("customer123")) {
			model.addAttribute("userID", login.getUserID());
			model.addAttribute("password", login.getPassword());
			return "customer/customer";
		} else {
			model.addAttribute("ErrMsg", "Invalid Input");
			return "login";
		}
	}
}
