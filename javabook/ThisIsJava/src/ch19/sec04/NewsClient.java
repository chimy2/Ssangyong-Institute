package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {
	public static void main(String[] args) {
		try {
//			DatagramSocket 생성
			DatagramSocket datagramSocket = new DatagramSocket();
			
//			구독하고 싶은 뉴스 주제 보내기
			String data = "정치";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localHost", 50001));
			datagramSocket.send(sendPacket);
			
			while(true) {
//				뉴스 받기
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);
				
//				문자열로 변환
				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
				System.out.println(news);
				
//				10번째 뉴스를 받으면 while문 종료
				if(news.contains("뉴스10")) {
					break;
				}
			}
			
//			DatagramSocket 닫기
			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		정치: 뉴스1
		정치: 뉴스2
		정치: 뉴스3
		정치: 뉴스4
		정치: 뉴스5
		정치: 뉴스6
		정치: 뉴스7
		정치: 뉴스8
		정치: 뉴스9
		정치: 뉴스10
		*/
	}
}
