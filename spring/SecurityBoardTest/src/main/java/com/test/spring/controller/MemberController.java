package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/logout.do")
	public String logout() {
		return "member/logout";
	}
}
