package com.vr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@Validated Login login, Model model, HttpServletRequest request) {
		String userName = request.getParameter("userID");
		String password = request.getParameter("password");
		if (userName.equals("admin123") && password.equals("admin123")) {
			// model.addAttribute("userID", login.getUserID());
			// model.addAttribute("password", login.getPassword());
			// return "admin/searchRequest";
			return new ModelAndView("redirect:/adminHome");
		} else if (userName.equals("customer") && password.equals("customer123")) {
			// model.addAttribute("userID", login.getUserID());
			// model.addAttribute("password", login.getPassword());
			return new ModelAndView("redirect:/newRegistration");
		} else {
			model.addAttribute("ErrMsg", "Invalid Input");
			// request.setAttribute("ErrMsg", "Invalid Input");
			return new ModelAndView("redirect:/login");
		}
	}
}
