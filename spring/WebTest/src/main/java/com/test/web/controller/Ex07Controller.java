package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 스프링이 어노테이션을 보고(읽고) 스프링 빈으로 관리

// 스프링 빈이 되기 위한 자격
// - @Component		> 자격만 줌
// - @Controller	> 컨트롤러 역할
// - @Service		> 서비스 객체 역할
// - @Repository	> DAO(데이터 관리) 역할
@Controller
public class Ex07Controller {
	
	@GetMapping("/ex07.do")
	public String ex07() {
		return "ex07";
	}
}
