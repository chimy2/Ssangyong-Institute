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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;
import com.test.toy.user.model.UserDTO;
import com.test.toy.util.OutputUtil;

@WebServlet("/board/add.do")
public class Add extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		권한 확인
//		HttpSession session = req.getSession();
//		UserDTO dto = (UserDTO) (session.getAttribute("user"));
//		if(dto == null) {
//			resp.sendRedirect("/toy/index.do");
//		}
		String mode = req.getParameter("mode");
		String thread = req.getParameter("thread");
		String depth = req.getParameter("depth");
		
		req.setAttribute("mode", mode);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/add.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		AddOk.java 역할
//		1. 데이터 가져오기(subject, content)
//		2. DB 작업 > insert
//		3. 결과 처리
		
		HttpSession session = req.getSession();
		
//		1.
		/*
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String id = ((UserDTO)(session.getAttribute("user"))).getId();
		
		String mode = req.getParameter("mode");
		*/
		
		MultipartRequest multi= new MultipartRequest(
					req, 
					req.getRealPath("/asset/place"),
					1024 * 1024 * 30,
					"UTF-8",
					new DefaultFileRenamePolicy()
				);
		
		System.out.println(req.getRealPath("/asset/place"));
		
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String id = ((UserDTO)(session.getAttribute("user"))).getId();
		
		String mode = multi.getParameter("mode");
		String attach = multi.getFilesystemName("attach");
		
		String tag = multi.getParameter("tag");
		
//		2.
		BoardDAO dao = BoardDAO.getInstance();
		
//		새글 쓰기 vs 답변글 쓰기
		int thread = -1;
		int depth = -1;
		
		if (mode.equals("new")) { 
//			새글 쓰기
//				a. 현존하는 모든 게시물 중에서 가장 큰 thread 값을 찾아서 그 값에 + 1000한 값을 새글의 thread 값으로 넣는다
//				b. 새글의 depth 값은 0을 넣는다.

//			a.
			thread = dao.getMaxThread() + 1000;
//			b.
			depth = 0;
		} else if (mode.equals("reply")) {
//			답변하기
//				a. 현존하는 모든 게시물의 thread 값을 대상으로, 현재 작성 중인 답변글의 부모글 thread 값보다 작고,
//					이전 새글의 thread 값보다 큰 thread를 모두 찾아서 -1을 한다.
//				b. 답변글의 thread 값은 부모글의 thread - 1 을 넣는다.
//				c. 답변글의 depth 값을 부모글의 depth +1 을 넣는다.
			/*
			int parentThread = Integer.parseInt(req.getParameter("thread"));
			int parentDepth = Integer.parseInt(req.getParameter("depth"));
			*/
			int parentThread = Integer.parseInt(multi.getParameter("thread"));
			int parentDepth = Integer.parseInt(multi.getParameter("depth"));
			
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
//			a.
			dao.updateThread(map);
			
//			b.
			thread = parentThread - 1;
//			c.
			depth = parentDepth + 1;
		}
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(id);
		dto.setThread(thread);
		dto.setDepth(depth);
		dto.setAttach(attach);

//		HTML 태그 이스케이프
//		content = content.replace("<", "&lt;").replace(">", "&gt;");
//		dto.setContent(content);
//		사용자 의도와 상관없이 가공을 해버리면 나중에 문제가 생길 소지가 있어서
//		출력할 때 처리한다.
		
		int result = dao.add(dto);
		
//		관계테이블에서 게시물의 번호를 받아와야되기 때문에
//		밑에서 작업
		
		if(tag != null && !tag.equals("") && !tag.equals("[]")) {
			
			try {

//				[{"value":"자바"},{"value":"게시판"},{"value":"태그"}]

				JSONParser parser = new JSONParser();
				
//				파싱된 object가 object를 돌려줄 수도 있고 array를 돌려줄 수 있기 때문에 형변환
				JSONArray arr = (JSONArray)parser.parse(tag);
				
				for (Object obj: arr) {
//					태그 추출
					JSONObject tagObj = (JSONObject)obj;
					String tagName = tagObj.get("value").toString();
//					System.out.println(tagName);
					
//					태그를 DB에 추가
					if (dao.existHashtag(tagName)) {
						dao.addHashtag(tagName);
					}
					
//					관계 추가
//					1. 게시물 번호
//					2. 해시 태그 번호
					String bseq = dao.getBseq();
					String hseq = dao.getHseq(tagName);
//					동시에 글을 쓴다고 해도 잘못된 seq가 넘어올 확률이 너무 적기 때문에 보통 일련번호의 max값을 가져옴
//					네이버나 구글 같은 사이트는 동접자가 많기 때문에 처리를 해야하지만 그 외 99% 사이트들은 이렇게 처리해줘도 문제가 없다
//					중요한 포인트는 맞는데 일어날 확률이 적기 때문에 보통 이렇게 처리
					
					HashMap<String, String> map = new HashMap<String, String>();
					
					map.put("bseq", bseq);
					map.put("hseq", hseq);
					
					dao.addTagging(map);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		3.
		if(result == 1) {
			resp.sendRedirect("/toy/board/list.do");
		} else {
			OutputUtil.redirect(resp, "쓰기 실패;;");
		}
		
	}
}
