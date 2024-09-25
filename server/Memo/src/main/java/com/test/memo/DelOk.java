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

@WebServlet("/delok.do") // > web.xml에서 해줬던 servlet 설정을 간단하게 가상주소만 해당 servlet 위에 얹어서 연결해줌
//web.xml에서 모든 주소를 관리하는 것도 나쁜 방법은 아님
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		del.do > 데이터 줄테니 > DB에 delete

//		1. 데이터 가져오기(seq, pw)
//		1.5 권한 확인(암호 확인)
//		2. DB delete
//		3. 결과 통보 + list.do 이동하기

//		1.
		req.setCharacterEncoding("UTF-8");

		String seq = req.getParameter("seq");
		String pw = req.getParameter("pw");

//		1.5 
		MemoDAO dao = new MemoDAO();

		MemoDTO dto = new MemoDTO();

		dto.setSeq(seq);
		dto.setPw(pw);

		int result = 0;

		if (dao.check(dto) == 1) {
//			2.
			if (dao.delete(dto) == 1) {
				result = 1;
			}
		} else {
			result = 2;
		}

		if (result == 1) {	// 삭제에 성공했을 때
			resp.sendRedirect("/memo/list.do");
		} else if(result == 2) {	// 암호가 틀렸을 때
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			writer.println("<script>");
			writer.println("alert('암호가 틀렸습니다.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
		} else {// 삭제에 실패했을 때
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			writer.println("<script>");
			writer.println("alert('글 수정에 실패했습니다.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
		}

//		req.setAttribute("result", result);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/editok.jsp");
//		dispatcher.forward(req, resp);

	}
}
