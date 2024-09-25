package com.test.memo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/addok.do") // > web.xml에서 해줬던 servlet 설정을 간단하게 가상주소만 해당 servlet 위에 얹어서 연결해줌
//web.xml에서 모든 주소를 관리하는 것도 나쁜 방법은 아님
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		add.do > 데이터 줄테니 > DB에 insert
		
//		1. 데이터 가져오기(memo, name, pw)
//		2. DB insert
//		3. 결과 통보
		
//		1.
		req.setCharacterEncoding("UTF-8");
		
		String memo = req.getParameter("memo");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		
		System.out.println(memo);
		System.out.println(name);
		System.out.println(pw);
		
//		2. DB 작업 > 분리 > DAO(Data Access Object) 
		MemoDTO dto = new MemoDTO();
		dto.setMemo(memo);
		dto.setName(name);
		dto.setPw(pw);
		
		MemoDAO dao = new MemoDAO();	// DB 접속
		int result = dao.add(dto);		// 1(성공), 0(실패)
		
//		addok.jsp로 페이지를 넘기기엔 하는 일에 비해 비용이 많이 들기 때문에
//		간단하게 서버단에서 처리해줌
		if (result == 1) {
			resp.sendRedirect("/memo/list.do");
		} else {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			writer.println("<script>");
			writer.println("alert('글쓰기에 실패했습니다.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
		}
		
//		req.setAttribute("result", result);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addok.jsp");
//		dispatcher.forward(req, resp);
		
	}
}
