package com.test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex04 {
	public static void main(String[] args) {
//		셀레니움(자동화 테스트 도구 + 크롤링)
		m1();
	}

	private static void m1() {
//		1. 브라우저 드라이버
//		어떤 브라우저의 내용을 크롤링 할지 정해야함
//		> 크롬 드라이버 > 다운로드 > 압축 해제 > chromedriver.exe
//		https://googlechromelabs.github.io/chrome-for-testing/#stable
//		본인이 사용하는 브라우저의 메이저 버전의 드라이버를 받아야함
		
//		2. 셀레니움 라이브러리
		String webDriverID = "webdriver.chrome.driver";
		String path = "c:\\class\\dev\\chromedriver.exe";
		System.setProperty(webDriverID, path);	// 셀레니움이 드라이버를 찾을 때 도움이 되는 환경변수 설정 같은 느낌
		
		WebDriver driver = new ChromeDriver();	// 원래는 Chrome 드라이버밖에 없었는데 최근에 다른 브라우저도 생김
//		WebDriver driver = new EdgeDriver();	//Edge 라면
		
		String url = "http://localhost:8090/crawling/list.jsp";
		driver.get(url);	// 진짜 서핑을 하기 때문에 동적으로 뿌려지는 데이터도 가져올 수 있음
		
		WebElement h1 = driver.findElement(By.tagName("h1"));	// tagname, class, name, id, css selector,...
		System.out.println(h1.getText());
		
		List<WebElement> list = driver.findElements(By.cssSelector(".item div:nth-child(1)"));
		
//		크롤링을 전문적으로 하는 것은 아니라 느림
//			why? > 브라우저를 띄우는 작업을 하기 때문에
		list.forEach(item -> {
			System.out.println(item.getText());
		});
	}
}
