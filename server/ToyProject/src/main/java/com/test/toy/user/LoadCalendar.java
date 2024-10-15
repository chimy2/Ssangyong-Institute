package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/loadcalendar.do")
public class LoadCalendar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		String id = ((UserDTO)session.getAttribute("user")).getId();
		
		UserDAO dao = UserDAO.getInstance();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("year", year);
		map.put("month", month);
		map.put("id", id);
		
		ArrayList<HashMap<String, String>> list = dao.loadCalendar(map);
		
		JSONArray arr = new JSONArray();
		
		for (HashMap<String, String> temp: list) {
			JSONObject obj = new JSONObject();
			
			obj.put("regdate", temp.get("regdate"));
			obj.put("cnt", temp.get("cnt"));
			obj.put("bcnt", temp.get("bcnt"));
			obj.put("ccnt", temp.get("ccnt"));

			arr.add(obj);
		}
		
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(arr);
		
		writer.close();
	}
}
