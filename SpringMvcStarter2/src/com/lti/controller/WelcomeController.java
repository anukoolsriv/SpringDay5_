package com.lti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage() {

		return "index";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("admin") && password.equals("admin")) {
			return "success";
		} else {
			return "error";
		}
	}
}
