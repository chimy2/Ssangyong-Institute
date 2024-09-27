package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04data.do")
public class Ex04Data extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		m1(req, resp);
//		m2(req, resp);
		m3(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		m4(req, resp);
	}

	private void m4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		String txt4 = req.getParameter("txt4");

		txt4 = "@" + txt4 + "@";
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(txt4);
		writer.close();
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String txt3 = req.getParameter("txt3");
		int length = txt3.length();
		
		PrintWriter writer = resp.getWriter();
		writer.print(length);
		writer.close();
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) {
		String txt2 = req.getParameter("txt2");
		System.out.println("ajax가 보낸 데이터: " + txt2);
	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String name = "홍길동";
		
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			System.out.println("Ex04Data.m1");
//			e.printStackTrace();
//		}
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(name);
		writer.close();
	}
}
