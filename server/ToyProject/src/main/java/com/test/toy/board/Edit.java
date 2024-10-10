package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;
import com.test.toy.user.model.UserDTO;

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 데이터 가져오기(seq)
//		2. DB 작업 > select
//		3. DTO 반환 > JSP 호출하기
		
		String seq = req.getParameter("seq");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.get(seq);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		수정하기
//		EditOk.java 역할
//		1. 데이터 가져오기(subject, content)
//		2. DB 작업 > update
//		3. 결과 처리
		
		HttpSession session = req.getSession();
		
//		1.
		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String id = ((UserDTO)(session.getAttribute("user"))).getId();
		
//		2.
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(id);
		
		int result = dao.edit(dto);
		
//		3.
		if (result == 1) {
			resp.sendRedirect("/toy/board/view.do?seq="+seq);
		} else {
			
		}
		
	}
}
