package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
	public static void main(String[] args) {
		try {
			String url = "https://serieson.naver.com/v3/movie/ranking/monthly";
			
			Document document = Jsoup.connect(url).get();
			
//			Elements list = document.select(".Title_title__s9o0D");
//			System.out.println(list.size());
//			
//			list.forEach(span -> System.out.println(span.text()));
			
			Elements list = document.select(".RankingList_ranking_list__N4QsH > li");
			
			System.out.println(list.size());
			
			for (Element movie: list) {
				String title = movie.select(".Title_title__s9o0D").text();
				
//				String no = movie.select("a > div:nth-child(2) > em > span > span").text();
//				System.out.println(title +", " + no.replaceAll(" ", ""));
				
				Elements nlist = movie.select("a > div > em > span > span");
				String no = "";
				
				for(Element nitem: nlist) {
					no += nitem.text();
				}
				
				System.out.println(title + ", " + no);
				
				System.out.println("https://serieson.naver.com" + movie.firstElementChild().attr("href"));
//				동적으로 붙인 속성은 jsoup으로 가져오기 힘듦
				System.out.println(movie.selectFirst("img"));
				String src = movie.selectFirst("img").attr("src");
			}
		} catch (Exception e) {
			System.out.println("Ex02.main");
			e.printStackTrace();
		}
	}
}
