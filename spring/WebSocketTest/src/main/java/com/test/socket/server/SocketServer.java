package com.test.socket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server.do")
public class SocketServer {

//	클라이언트가 연결 요청을 했을때 자동으로 실행 
//	어떻게 알아서 자동으로 실행하는가? 어노테이션을 붙였기 때문에 스프링이 알아서 실행
	@OnOpen
	public void handleOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}
	
//	클라이언트와의 연결이 종료되었을때 실행
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 연결이 종료되었습니다.");
	}
	
//	클라이언트가 메시지를 전송 + 서버가 수신할 때
	@OnMessage
//	public void handleMessage(String msg) {
//		System.out.println("클라이언트가 메시지를 보냈습니다. >>> " + msg);
//	}
	public String handleMessage(String msg) {
		return msg;	// 응답메시지(서버 > 클라이언트)
	}
	
//	에러발생
	@OnError
	public void handleError(Throwable e) {
		System.out.println("에러 발생: " + e.getMessage());
	}
}
