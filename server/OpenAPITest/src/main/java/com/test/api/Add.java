package com.test.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class Add extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		
		MapDAO dao = new MapDAO();
		
		MapDTO dto = new MapDTO();
		dto.setLat(lat);
		dto.setLng(lng);
		
		dao.add(dto);
		
//		ajax로 보냈으면 java에서 아무것도 안해줘도 되지만
//		form으로 전송했기 때문에 원래 페이지로 이동해줘야 페이지가 보임
		resp.sendRedirect("/api/map.do?n=ex05");
		
	}
}
