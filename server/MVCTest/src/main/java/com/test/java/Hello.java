package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		DB > select
		String name = "홍길동";
		
		
//		JSP 호출하기
//		- 주소가 변경된다.(서블릿 주소X)
//		- 서블릿에서 JSP로 데이터 전달이 불편하다.
//		resp.sendRedirect("hello.jsp");

//		pageContext.forward();
		req.setAttribute("name", name);
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("JSP 경로");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/");	> webapp folder
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(req, resp);	// = pageContext.forward();
	}
}
