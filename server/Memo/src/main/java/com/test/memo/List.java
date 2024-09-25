package com.test.memo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/list.do") // > web.xml에서 해줬던 servlet 설정을 간단하게 가상주소만 해당 servlet 위에 얹어서 연결해줌
//web.xml에서 모든 주소를 관리하는 것도 나쁜 방법은 아님
public class List extends HttpServlet {	//컨트롤러(Controller)

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. DB 작업 > select
//		2. 결과 > JSP 전달 + 호출하기
		
//		1.
		MemoDAO dao = new MemoDAO();	// 모델(Model)
		
//		MemoDTO > 레코드 1줄 역할
//		ArrayList > 테이블 역할
		ArrayList<MemoDTO> list = dao.list();
		
//		2.
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");	// 뷰(View)
		dispatcher.forward(req, resp);
		
//		JSP Model 2 > MVC 디자인 패턴을 차용해 구현
//		- Controller: 서블릿
//		- Model: DAO or DTO
//		- View: JSP
	}
}
