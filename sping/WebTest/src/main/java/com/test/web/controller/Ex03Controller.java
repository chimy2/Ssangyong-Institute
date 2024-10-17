package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 스프링 컨트롤러 구현
// 1. Controller 인터페이스 구현
// 2. @Controller 어노테이션 사용

// 스프링이 관리하는 객체 > 빈
// 컨트롤러 어노테이션을 붙이면 Package Explorer에 S아이콘이 붙는것을 볼 수 있는데
// 이는 스프링이 관리하는 빈이 됨을 알려주는 것이다
@Controller
@RequestMapping(value="/ex03.do")	// 2세대 annotation 버전
//@WebServlet("/ex03.do")
public class Ex03Controller {
	
//	요청 메서드?? > 정해진 형식이 없음 > 맘대로~
	public void add() {}
	
	public void bbb() {	/* 페이지 작업 > JSP 호출 */ }
	
	public void ccc() {}
	
	@RequestMapping
//	public String test() {
//	public String test(HttpServletRequest req) {
	public String test(Model model) {
//		업무 코드
		
//		1. req? > 어디서 받아오고
//		2. mv? >  어디로 보내는가
//		req.setAttribute("num", 100);	// 애써서 ModelAndView로 바꿔놨는데 예전으로 돌아가는 느낌
		
		model.addAttribute("num", 100);
		
//		뷰 호출 > ModelAndView
		return "ex03";
	}
}
