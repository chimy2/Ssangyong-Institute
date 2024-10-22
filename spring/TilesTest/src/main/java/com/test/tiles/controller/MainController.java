package com.test.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value="index.do")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="test.do")
	public String test() {
		
		System.out.println("test");
		
		return "test";	// 직접 jsp를 찾는게 아니라 tiles.xml에 적어놓은 definition name을 찾음
	}
}
