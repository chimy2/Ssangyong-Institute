package com.test.api.food;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.test.api.MapDAO;

@WebServlet("/listfood.do")
public class ListFood extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String s = req.getParameter("s");
		
		MapDAO dao = new MapDAO();
		
		ArrayList<FoodDTO> list = dao.listfood();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		JSONArray arr = new JSONArray();
		
//		for(int i=0; i<list.size(); i++) {
		for(FoodDTO dto: list) {
		
			JSONObject obj = new JSONObject();
			
//			obj.put("fseq", list.get(i).getSeq());
//			obj.put("fname", list.get(i).getName());
//			obj.put("lat", list.get(i).getLat());
//			obj.put("lng", list.get(i).getLng());
//			obj.put("address", list.get(i).getAddress());
//			obj.put("star", list.get(i).getStar());
//			obj.put("menu", list.get(i).getMenu());
//			obj.put("cseq", list.get(i).getCategoryDTO().getSeq());
//			obj.put("cname", list.get(i).getCategoryDTO().getName());
//			obj.put("img", list.get(i).getCategoryDTO().getImg());
			
			obj.put("seq", dto.getSeq());
			obj.put("name",dto.getName());
			obj.put("lat", dto.getLat());
			obj.put("lng", dto.getLng());
			obj.put("address", dto.getAddress());
			obj.put("star", dto.getStar());
			obj.put("menu", dto.getMenu());
			
			JSONObject cobj = new JSONObject();
			
			cobj.put("seq", dto.getCategoryDTO().getSeq());
			cobj.put("name", dto.getCategoryDTO().getName());
			cobj.put("img", dto.getCategoryDTO().getImg());
			
			obj.put("category", cobj);
			
			arr.add(obj);
		}
		
		writer.print(arr.toString());
		
		writer.close();
	}
}
