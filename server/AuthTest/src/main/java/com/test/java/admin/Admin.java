package com.test.java.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.java.db.UserDTO;

@WebServlet("/admin/admin.do")
public class Admin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		/*
		 * short circuit 
		 * - 자바는 short circuit임
		 * - 논리 연산 시 발생하는 정책
		 * 
		 * int a = 10;
		 * 
		 * if(a % 2 == 0 && a > 0) {} > a = 9일때는 처음 조건이 false이므로 그 후에 나오는 조건은 실행조차안하고 넘어간다.
		 * if(a % 2 == 0 || a > 0) {} > a가 이미 짝수 이므로 처음 조건에 만족한다 따라서 그 후에 나오는 조건은 실행조차안하고 넘어간다.
		 */		
		if(session.getAttribute("auth") == null
				|| ((UserDTO)session.getAttribute("auth")).getLv() != 2) {

			PrintWriter writer = resp.getWriter();
			writer.println("<html><body><script>");// alert이 안뜬다는거야? 이거해봤어 강력 새로고침?
			writer.println("alert('invalid access');");
			writer.println("location.href='/auth/index.do';");
			writer.println("</script></body></html>");
			writer.close();
			return;
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
		dispatcher.forward(req, resp);
	}
}
