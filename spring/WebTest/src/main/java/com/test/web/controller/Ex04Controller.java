package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/ex04_1.do")
@RequestMapping("/member")
public class Ex04Controller {
	

//	위에 경로를 선언하고 두 메서드에 전부 RequestMapping을 붙이면 어느 메서드를 불러야 할 지 모르기 때문에 에러
//	Ambiguous mapping. Cannot map 'ex04Controller' method 
//	@RequestMapping
//	value는 하나만 있을때는 생략 가능하지만 여러속성을 명시한다면 생략 불가능
//	@RequestMapping("/ex04_1.do")
	@RequestMapping(value="/ex04_1.do")
	public String ex04_1() {
		return "ex04_1";
	}
	
//	@RequestMapping
	@RequestMapping(value="/ex04_2.do")
	public String ex04_2() {
		return "ex04_2";
	}
}
