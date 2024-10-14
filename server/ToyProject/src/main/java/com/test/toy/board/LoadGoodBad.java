package com.test.toy.board;

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

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.user.model.UserDTO;

@WebServlet("/board/loadgoodbad.do")
public class LoadGoodBad extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		UserDTO dto = (UserDTO) session.getAttribute("user");
		
		String bseq = req.getParameter("bseq");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String state = "-1";
		
//		현재 게시물에 내가 누른 좋아요/ 싫어요
		if(dto != null) {
			state = dao.getGoodbad(bseq, dto.getId());
		}
		
//		좋아요/싫어요 카운트 목록
		ArrayList<HashMap<String, String>> list = dao.loadGoodBad(bseq);

		resp.setContentType("application/json");

		JSONArray arr = new JSONArray();
		
		if(list != null && list.size() > 0) {
			for(HashMap<String, String> map: list) {
				JSONObject obj = new JSONObject();
				
				obj.put("state", map.get("state"));
				obj.put("cnt", map.get("cnt"));
				
				arr.add(obj);
			}
		}
		
		JSONObject root = new JSONObject();
		
		root.put("arr", arr);		// 전체 카운트
		root.put("state", state);	// 내 선택?
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(root);
		
		writer.close();
	}
}
