package ch19.sec02;

import java.net.InetAddress;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		내 컴퓨터 IP 주소: 192.168.10.34
		www.naver.com IP 주소: 223.130.192.248
		www.naver.com IP 주소: 223.130.200.236
		www.naver.com IP 주소: 223.130.192.247
		www.naver.com IP 주소: 223.130.200.219
		*/
	}
}
