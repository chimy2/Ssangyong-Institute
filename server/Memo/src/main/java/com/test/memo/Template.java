package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/template.do") // > web.xml에서 해줬던 servlet 설정을 간단하게 가상주소만 해당 servlet 위에 얹어서 연결해줌
//web.xml에서 모든 주소를 관리하는 것도 나쁜 방법은 아님
public class Template extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/template.jsp");
		dispatcher.forward(req, resp);
		
	}
}
