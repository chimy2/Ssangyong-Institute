package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
//	필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
//	메소드: 서버 연결
	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");
	}
	
//	메소드: JSON 받기
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (Exception e) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}
	
//	메소드: JSON 보내기
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}
	
//	메소드: 연결 종료
	public void  unconnect() throws IOException {
		socket.close();
	}
	
//	메소드: 메인
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("대화명 입력: ");
			chatClient.chatName = scanner.nextLine();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);
			
			chatClient.receive();
			
			System.out.println("---------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
			System.out.println("---------------------------------------------------");
			while(true) {
				String message = scanner.nextLine();
				if(message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			scanner.close();
			chatClient.unconnect();
		} catch (IOException e) {
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
		/*
		[클라이언트] 서버에 연결됨
		대화명 입력: winter
		---------------------------------------------------
		보낼 메시지를 입력하고 Enter
		채팅을 종료하려면 q를 입력하고 Enter
		---------------------------------------------------
		<spring@127.0.0.1> 들어오셨습니다.
		오늘은 영하 10도입니다.
		<spring@127.0.0.1> 엄청 춥네요. 이제 곧 봄이 올겁니다.
		따뜻한 곳에서 자바를 열심히 해야겠어요.
		<spring@127.0.0.1> 맞아요. 봄되면 멋진 개발자가 될 겁니다.
		다들 화이팅합니다.
		q
		[클라이언트] 서버 연결 끊김
		*/
		/*
		[클라이언트] 서버에 연결됨
		대화명 입력: spring
		---------------------------------------------------
		보낼 메시지를 입력하고 Enter
		채팅을 종료하려면 q를 입력하고 Enter
		---------------------------------------------------
		<winter@127.0.0.1> 오늘은 영하 10도입니다.
		엄청 춥네요. 이제 곧 봄이 올겁니다.
		<winter@127.0.0.1> 따뜻한 곳에서 자바를 열심히 해야겠어요.
		맞아요. 봄되면 멋진 개발자가 될 겁니다.
		<winter@127.0.0.1> 다들 화이팅합니다.
		<winter@127.0.0.1> 나가셨습니다.
		q
		[클라이언트] 서버 연결 끊김
		*/
	}
}
