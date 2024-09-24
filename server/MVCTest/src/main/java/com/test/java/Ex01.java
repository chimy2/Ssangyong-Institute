package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = 100;
		String txt = "문자열";
		
		req.setAttribute("num", num);
		req.setAttribute("txt", txt);
		
//		'/' == webapp
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/ex01.jsp");	// 객채 생성
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex01.jsp");	// 객채 생성
//		외부에서 WEB-INF 폴더를 접근하지 못하기 때문에 ex01.jsp에 직접 접근할 수 없도록 내부에 넣어서 관리한다.
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex0.jsp");	// 객채 생성
//		파일 [/WEB-INF/views/ex0.jsp]을(를) 찾을 수 없습니다. > servlet에서 주소가 잘못 설정된 것
//		요청된 리소스 [/mvc/ex0.do]은(는) 가용하지 않습니다. > web.xml에서 설정이 잘못된 것
		dispatcher.forward(req, resp);	// 페이지 이동
		
	}
}
