package com.test.begin.di3;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
//		목적] hong한테 일을 시키자!
//		Hong 객체를 누가 만드느냐 > 의존 주입 구현 O
//		1. 개발자가 직접 생성(di2)
//		Hong hong = new Hong();	// 의존 객체
		
//		2. 스프링을 통해서 객체 생성 > 스프링 빈 생성
//		- di3.xml 읽어오기
//		ApplicationContext context = new ClassPathXmlApplicationContext("경로");
		
//		절대 경로
//		ApplicationContext context = new ClassPathXmlApplicationContext("/src/main/java/com/test/begin/di3/di3.xml");
		
//		상대 경로
//		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/begin/di3/di3.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/di3/di3.xml");
		
//		경로가 맞는지 확인하고 싶을 때 파일 객체 생성
		File file = new File("com/test/begin/di3/di3.xml");	// 단 ClassPathXmlApplicationContext("") 경로에서는 사용하지 못함
		System.out.println(file.exists());
		
//		context.getBean("id값")
//		1. <bean id="hong" class="com.test.begin.di3.Hong"></bean>
//		2. new Hong()
//		3. 객체 반환
		
//		Hong hong = new Hong();
		Hong hong = (Hong)context.getBean("hong");
		System.out.println(hong);
		
		
//		Service service = new Service(hong);
//		service.work();
//		왜이렇게 번거롭게 작업할까? 바로 객체를 생성하는 것보다 xml에도 코드를 작성해야하고 context.getBean("")같이 이상하게 받아와야하는데..
//		> xml에서 의존성 주입을 바로 할 수 있기 때문
		
//		Service service = new Service(hong); 	> X
//		Service service = new Service();		> O
//		Service service2 = (Service)context.getBean("service");	> xml에 잘못된 bean을 만들면 에러가 남
//		Error creating bean with name 'service' defined in class path resource 
//		Failed to instantiate [com.test.begin.di3.Service]: No default constructor found;
		
//		Service service = new Service(new Hong());
//		Service service3 = (Service)context.getBean("service2");
//		service3.work();
		
		Service service4 = (Service)context.getBean("service3");
		service4.work();
		
		Hong h1 = (Hong)context.getBean("h1");	// id="h1"
		h1.coding();
		
		Hong h2 = (Hong)context.getBean("h2");	// name="h2"
		h2.coding();
	}
}
