package com.test.toy.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/view.do")
public class View extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 데이터 가져오기(seq)
//		2. DB 작업 > select
//		3. 결과(DTO) > JSP 호출하기
		HttpSession session = req.getSession();
		HashMap<String, String> map = new HashMap<String, String>();
		
//		1.
		String seq = req.getParameter("seq");
		String word = req.getParameter("word");
		String column = req.getParameter("column");
		String page = req.getParameter("page");
		
//		2.
		BoardDAO dao = BoardDAO.getInstance();
		
//		2.3 조회수 증가
		if(session.getAttribute("read") == null || session.getAttribute("read").toString().equals("n")) {
			dao.updateReadcount(seq);
			session.setAttribute("read", "y");
		}
		
		BoardDTO dto = dao.get(seq);
		
//		2.5 DTO 조작
		
//		개행문자 처리
		String content = dto.getContent();
		content = content.replace("\r\n", "<br>");
		
//		검색어 강조
		if(column != null && column.equals("content")) {
//			"‘다산의 삶’ 등을 펴낸 소설가 한승원(85)"
//				> "‘다산의 삶’ 등을 펴낸 소설가 
//					<span style='color:tomato;background-color:gold;'>한승원<span>(85)"
//			content = content.replace("한승원", "<span style='color:tomato;background-color:gold;'>한승원</span>");
			content = content.replace(word, "<span style='color:tomato;background-color:gold;'>" + word + "</span>");
		}
		dto.setContent(content);
		
		map.put("column", column);
		map.put("word", word);
		
//		3.
		req.setAttribute("dto", dto);
		req.setAttribute("map", map);
		req.setAttribute("page", page);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
		dispatcher.forward(req, resp);
	}
}
