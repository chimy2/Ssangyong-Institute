package com.test.api.food;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.test.api.MapDAO;

@WebServlet("/addfood.do")
public class AddFood extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		String address = req.getParameter("address");
		String star = req.getParameter("star");
		String menu = req.getParameter("menu");
		
		MapDAO dao = new MapDAO();
		
		FoodDTO dto = new FoodDTO();
		
		dto.setName(name);
		dto.setCategory(category);
		dto.setLat(lat);
		dto.setLng(lng);
		dto.setAddress(address);
		dto.setStar(star);
		dto.setMenu(menu);
		
		int result = dao.addFood(dto);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
//		writer.printf("{ result: %s }", result);
		JSONObject obj = new JSONObject();
	
		obj.put("result", result);
		
		writer.print(obj.toString());
		
		writer.close();
	}
}
