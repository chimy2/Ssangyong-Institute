package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.board.repository.CommentDTO;
import com.test.toy.user.model.UserDTO;

@WebServlet("/board/addcomment.do")
public class AddComment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		
		String content = req.getParameter("content");
		String bseq = req.getParameter("bseq");
		System.out.println(content+", "+bseq);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		CommentDTO dto = new CommentDTO();
		
		dto.setContent(content);
		dto.setBseq(bseq);
		dto.setId(user.getId());

		int result = dao.addComment(dto);
		
		resp.setContentType("applicaiton/json");
		
		JSONObject obj = new JSONObject();
		
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(obj.toString());
		
		writer.close();
	}
}
