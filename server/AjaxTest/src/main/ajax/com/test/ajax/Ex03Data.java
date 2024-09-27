package com.test.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03data.do")
public class Ex03Data extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* Scanner scan = new Scanner(System.in); */
		/* Scanner scan = new Scanner(File); */
		
//		webapp > data.txt
		
		
//		File file = new File("data.txt");
//		C:\class\dev\eclipse\data.txt
//		System.out.println(file.getAbsolutePath());
		
//		File file = new File("\\data.txt");
//		C:\data.txt
//		System.out.println(file.getAbsolutePath());
		
		String path = req.getRealPath("data.txt");
//		C:\class\code\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\AjaxTest\data.txt
//		System.out.println(path);
		
		File file = new File(path);
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.exists());
		
		Scanner scan = new Scanner(file);
		
		String data = scan.nextLine();	// 입력 했을 때와 똑같이 개행되기 전까지의 내용을 가져온다.
//		System.out.println(data);
		
//		resp.sendRedirect("/ajax/ex03.do?data=" + URLEncoder.encode(data, "UTF-8"));
		
		
		int a = 0;
		
		a = 10 / a;
		
		AjaxDAO dao = new AjaxDAO();
		String question = dao.getQuestion();
		
//		resp.sendRedirect("/ajax/ex03.do?data=" + URLEncoder.encode(question, "UTF-8"));
		
		req.setAttribute("question", question);
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex03ok.jsp");
//		dispatcher.forward(req, resp);
		
//		PrintWriter > 클라이언트가 돌려받을 임시 HTML 페이지를 돌려주는 역할
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
//		단, 인코딩이 깨지므로 설정해줘야 함
		PrintWriter writer = resp.getWriter();
		writer.print(question);
		writer.close();
		
//		Ajax용 servlet/browser용 servlet
//		browser용 servlet: 기존에 만들었던 서블릿
//		ajax용 servlet: html 페이지 생성 필요X > html 코드를 해석하지 못하기 때문에 데이터만 반환해줌
	}
}

