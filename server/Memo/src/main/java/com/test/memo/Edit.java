package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/edit.do") // > web.xml에서 해줬던 servlet 설정을 간단하게 가상주소만 해당 servlet 위에 얹어서 연결해줌
//web.xml에서 모든 주소를 관리하는 것도 나쁜 방법은 아님
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		수정을 위한 화면
//		- edit.do?seq=10
//		1. 데이터 가져오기(seq)
//		2. DB 작업 > select where seq = 8
//		3. 결과 반환 > JSP 전달 + 호출하기
		
//		1.
		String seq = req.getParameter("seq");
		
//		2.
		MemoDAO dao = new MemoDAO();
		
		MemoDTO dto = dao.get(seq);
		
//		3.
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/edit.jsp");
		dispatcher.forward(req, resp);
		
	}
}