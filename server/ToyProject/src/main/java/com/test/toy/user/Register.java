package com.test.toy.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;
import com.test.toy.util.OutputUtil;

@WebServlet("/user/register.do")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RegisterOk.java
//		1. 데이터 가져오기
//		2. DB 작업 > insert
//		3. 결과 처리
		
//		계속 반복되는 작업 > 필터 처리
//		req.setCharacterEncoding("UTF-8");
		
//		System.out.println(req.getParameter("name"));
		
//		req > MultipartRequest
		System.out.println(req.getRealPath("/asset/pic"));
		
		try {
			MultipartRequest multi = new MultipartRequest(
						req,
						req.getRealPath("/asset/pic"),	// 파일이 저장될 위치
						1024 * 1024 * 10,				// 최대 파일 크기	
						"UTF-8",						// 파일 인코딩
						new DefaultFileRenamePolicy()	// 이름 중복 시 이름을 변경해주는 정책
					);
//			1.
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String pic = multi.getFilesystemName("pic");
			String intro = multi.getParameter("intro");
			
			System.out.println(pic == null);
			System.out.println(pic == "");
			
			if (pic == null) {
				pic = "pic.png";
			}
			
//			2.
			UserDTO dto = new UserDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPic(pic);
			dto.setIntro(intro);
			
//			3.
//			DAO의 역할 > DB 작업 수행
//			*** 객체의 역할 > 객체를 1개만 필요로 하는 경우 > 싱글톤(Singleton) 패턴
			UserDAO dao = UserDAO.getInstance();
			
			int result = dao.register(dto);
			
			if(result == 1) {
//				회원 가입 성공
				resp.sendRedirect("/toy/index.do");
			} else {
//				회원 가입 실패
				OutputUtil.redirect(resp, "실패했습니다.");
			}
		} catch (Exception e) {
			System.out.println("Register.doPost");
			e.printStackTrace();
		}
	}
}
