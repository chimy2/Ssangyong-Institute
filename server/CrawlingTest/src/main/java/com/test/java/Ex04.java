package com.test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex04 {
	public static void main(String[] args) {
//		셀레니움(자동화 테스트 도구 + 크롤링)
//		m1();
		m2();
	}

	private static void m2() {
//		http://lms1.sist.co.kr/
		String url ="http://lms1.sist.co.kr/worknet/Slogin.asp";
		
		String webDriverId = "webdriver.chrome.driver";
		String path = "C:\\class\\dev\\chromedriver.exe";
		System.setProperty(webDriverId, path);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
//		1. 로그인 하기
		
//		strLoginID
		WebElement strLoginID = driver.findElement(By.id("strLoginID"));
		strLoginID.sendKeys("박소혜");	//타이핑(텍스트 입력)

//		strLoginPwd
		WebElement strLoginPwd = driver.findElement(By.id("strLoginPwd"));
		strLoginPwd.sendKeys("4010");
		
		WebElement btn = driver.findElement(By.cssSelector(".login-btn > input"));
//		System.out.println(btn.getAttribute("value"));	// 로그인
		btn.click();
		
//		2. 게시판들어가기
		
//		#content > div > div > div > div.panel-body > div.popbtmbtn_section > div > a:nth-child(10)
		WebElement a = driver.findElement(By.cssSelector("#content > div > div > div > div.panel-body > div.popbtmbtn_section > div > a:nth-child(10)"));
		a.click();
		
//		동적으로 열리는 팝업인데 바로 불러와서 데이터가 안불러와짐 > 기다리는 시간이 필요
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Ex04.m2");
			e.printStackTrace();
		}
		
//		#modalContent > div > div.panel-body > div.row > table > tbody > tr:nth-child(2) > td:nth-child(2)
		List<WebElement> list = driver.findElements(By.cssSelector("#modalContent > div > div.panel-body > div.row > table > tbody > tr > td:nth-child(2)"));
		
//		System.out.println(list.size());
		
		for(WebElement td: list) {
			System.out.println(td.getText());
		}
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
