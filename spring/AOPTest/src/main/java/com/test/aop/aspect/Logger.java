package com.test.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component	// <bean> 마땅히 정해진 컴포넌트가 없어서 기본적인 컴포넌트 어노테이션 사용
@Aspect		// <aop:aspect ref="logger"> 역할 부여	> BeginTest 참고
public class Logger {
	
	@Pointcut("execution(public * com.test.aop.dao.AOPDAO.add(..))")	// > 어노테이션을 사용하기 위해서는 변수, 함수가 필요하기 때문에 만든 메서드
	public void pc1() {
//		구현부(X)
		
	}
	
	@After("pc1()")
	public void m1() {
		System.out.println("[LOG] 로그를 작성합니다.");
	}
}
