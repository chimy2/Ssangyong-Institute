package com.test.toy.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/logout.do")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		세션 초기화 == 로그아웃
		HttpSession session = req.getSession();
		
//		기존 세션을 파기하고 새로운 세션을 발급해주는 것
		session.invalidate();
		
		resp.sendRedirect("/toy/index.do");
	}
}
