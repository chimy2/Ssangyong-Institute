package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.service.TestService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
//롬복에서 제공하는 생성자
//	- @NoArgsConstructor			> 매개변수가 없는 기본 생성자
//	- @AllArgsConstructor			> 모든 멤버변수를 매개변수로 가지는 생성자
//	- @RequiredArgsConstructor		> final 멤버변수만 매개변수로 가지는 생성자
@RequiredArgsConstructor
public class Ex08Controller {

	/*
	 * 
	 * *** 스프링을 통해서 관리되는 객체는 
	 * 		1. 반드시 @Component로 선언되어 있어야 한다.(or XML - 옛날 방식) 
	 * 		2. <component-scan>에 패키지가 포함되어야 한다.
	 * 
	 * 의존 주입
	 * - XML 사용 방식
	 * - 어노테이션 방식
	 * 
	 * 1. 필드 주입, Field Injection	> 스프링만의 독특한 방식
	 * 	- 초창기 방식
	 * 	- @Autowired 사용
	 * 	- 코드가 간결해진다.
	 * 
	 * 2. Setter 주입
	 * 	- Spring 3.X
	 * 	- @Autowired 사용
	 * 
	 * 3. 생성자 주입	> 보통 많이 쓰이는 방식
	 * 	- 생성자가 1개 일 때 @Autowired 생략 가능
	 * 	- 의존 객체에 fianl 적용이 가능하다.(*****)
	 * 
	 */
	
	@RequestMapping(value="/ex08_1.do", method=RequestMethod.GET)
	public String ex08_1(Model model) {
//		Controller > (의존 객체) > TestService
		TestService service = new TestService();
		
		service.work();
		
		String result = service.get();
		
		model.addAttribute("result", result);
		
		return "ex08";
	}
	
//	Autowired 어노테이션을 보면 이 클래스를 찾아가서 인스턴스를 생성함
	/*
	@Autowired
	private TestService service;
	*/
//	No qualifying bean of type 'com.test.web.service.TestService' available: 
//		expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
//		> TestService가 스프링 빈이 아니라면 에러가 남
	
	@RequestMapping(value="/ex08_2.do", method=RequestMethod.GET)
	public String ex08_2(Model model) {
//		Controller > (의존 객체) > TestService
//		TestService service = new TestService();
		/*
		servlet-context.xml에서 선언해줬던 bean을 xml로 가지 않고필드에서 처리
		<beans:bean class="com.test.web.controller.Ex02Controller" name="/ex02.do">
			<beans:constructor-arg ref="dao"></beans:constructor-arg>
		</beans:bean>
		*/
		
		service.work();
		
		String result = service.get();
		
		model.addAttribute("result", result);

		return "ex08";
	}
	
	/*
	private TestService service;
	
	@Autowired
	public void setService(TestService service) {
		this.service = service;
	}
	*/
	
	@RequestMapping(value="/ex08_3.do", method=RequestMethod.GET)
	public String ex08_3(Model model) {
		service.work();
		
		String result = service.get();
		
		model.addAttribute("result", result);
		
		return "ex08";
	}
	
//	의존 객체를 final로 두는 경우가 많음
//		> Why? 변경될 여지가 없는 객체이기 때문에
//		단, final로 바꾸면 의존 주입을 Setter로 하지 못함	
//			>  Setter나 필드 주입같은 경우는 불가능
	/*
	private final TestService service;
	
//	생성자에 한해서는 autowired를 생략 가능, 단 생성자가 1개만 존재할 때
//	@Autowired
	public Ex08Controller(TestService service) {
		this.service = service;
	}
	*/
	
//	public Ex08Controller() {}
	
	@RequestMapping(value="/ex08_4.do", method=RequestMethod.GET)
	public String ex08_4(Model model) {
		service.work();
		
		String result = service.get();
		
		model.addAttribute("result", result);
		
		return "ex08";
	}
	
//	생성자로 의존 주입을 하기 위해 lombok으로 생성자를 자동생성해서 사용
	private final TestService service;
	
	@RequestMapping(value="/ex08_5.do", method=RequestMethod.GET)
	public String ex08_5(Model model) {
		service.work();
		
		String result = service.get();
		
		model.addAttribute("result", result);
		
		return "ex08";
	}
}
