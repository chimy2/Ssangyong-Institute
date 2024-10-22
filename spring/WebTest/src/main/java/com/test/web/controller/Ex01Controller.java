package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// JSP Model 2 > (발전) > Spring MVC

// 서블릿 역할
public class Ex01Controller implements Controller {

//	요청 메서드
//	doGet/doPost == handleRequest
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		업무 처리
		
//		JSP 호출
//		RequestDispatcher > forward(req, resp)
		
		int count = 100;
		String id = "hong";
		
//		기존 방식
		request.setAttribute("count", count);
//		스프링만의 데이터 넘기는 방식을 씀
		
//		ModelAndView
//		Model > 계층간 데이터 전송
//		View > 페이지(JSP)
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", id);
		
//		mv.setViewName("JSP 경로");
//		mv.setViewName("/WEB-INF/views/ex01.jsp");
//		파일 [/WEB-INF/views/WEB-INF/views/ex01.jsp.jsp]을(를) 찾을 수 없습니다.
//		Spring > View Resolver 동작(servlet-context.xml)
//		servlet-context.xml에서 경로를 미리 설정해줬기 때문에 적지 않아도 됨
		
		mv.setViewName("ex01");
		
		return mv;
	}
	
}
