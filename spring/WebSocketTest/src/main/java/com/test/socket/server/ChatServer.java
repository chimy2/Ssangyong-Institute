package com.test.socket.server;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.socket.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
//	현재 채팅에 참여한 모든 사람들
	private static List<Session> sessionList;
	
	static {
		sessionList = new ArrayList<Session>();
	}

//	HttpSession과는 다름
	@OnOpen
	public void handleOpen(Session session) {	// 사용자의 연결을 관리하기 위한 객체
		System.out.println("[LOG] 클라이언트가 접속했습니다.");
		
		sessionList.add(session);
		
		System.out.println(sessionList.size());
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {
//		System.out.println(msg);
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		System.out.println(message);
//		Message(code=1, sender=병아리, receiver=null, content=null, regdate=2024-10-24 12:39:33)
		
		if(message.getCode().equals("1")) {
			for(Session s: sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if(message.getCode().equals("2")) {
//			기존 유저가 나갔습니다
			sessionList.remove(session);	// 확실하게 나가기 위해 한번 더 추가
			
			for(Session s: sessionList) {
				try {
					s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if(message.getCode().equals("3") || message.getCode().equals("4")) {
//			for(Session s: sessionList) {

			for(Session s: sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@OnClose
	public void handleClose(Session session) {
		System.out.println("[LOG] 클라이언트가 접속 종료했습니다.");
		
//		System.out.println(session);
		sessionList.remove(session);
		
	}

	@OnError
	public void handleError(Throwable e) {
		System.out.println("[LOG] 에러가 발생했습니다." + e.getMessage());
	}
}
