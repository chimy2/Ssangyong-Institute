package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {
	public static void main(String[] args) {
		try {
			String url = "http://localhost:8090/crawling/list.jsp";
			
			Document document = Jsoup.connect(url).get();
			
			Elements list = document.select("#list .item");
			
			for(Element item : list) {
//				System.out.println(item);
//				item.firstElementChild();
				System.out.println(item.firstElementChild().text());
			}
//			동적으로 만든 데이터는 Jsoup으로 크롤링하지 못함
//			"소스를 탐색만 함"
//			소스와 DOM은 다르다
//			개발자도구를 열면 보이는 것이 DOM이다
			System.out.println("end");
			
		} catch (Exception e) {
			System.out.println("Ex03.main");
			e.printStackTrace();
		}
	}
}
