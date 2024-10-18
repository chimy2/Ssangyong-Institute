package com.test.web.service;

import org.springframework.stereotype.Service;

//@Component
// 가독성 차이 때문에 Component보단 Service라고 어노테이션을 붙임
@Service
public class TestService {
	
	public void work() {
		System.out.println("주 업무를 진행합니다.");
	}
	
	public String get() {
//		DB or 조작
		return "스프링";
	}
}
