package com.test.begin.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

// 보조 업무 객체
public class Logger {
	
//	보조 업무
	public void log(String message) {
		Calendar now = Calendar.getInstance();
		
		System.out.printf("[LOG]%tF %tT > %s\n",
					now, now, message);
	
	}
	
//	보조 업무 > After Advice
	public void m1() { 
		System.out.println("🌟🌟보조 업무를 실행합니다.");
	}
	
//	Before Advice
	public void m2() {
		System.out.println("익명 사용자를 내보냅니다.");
	}
	
//	Around Advice
	public void m3(ProceedingJoinPoint jp) {
//		보조업무 > 주업무 > 보조업무
//		주업무 소요 시간
//		1. 기록 시작
//		2. 주업무 실행
//		3. 기록 멈춤
		
		long begin = System.nanoTime();
		System.out.println("[LOG]기록을 시작합니다.");
		
//		주업무 실행
//		jp: 주업무 객체(=memo), Proxy 객체
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		System.out.println("[LOG]기록을 종료합니다.");
		
		System.out.printf("[LOG]소요 시간: %,dns\n", end - begin);
	}
	
//	After Returning
	public void m4(String memo) {
//		주 업무의 리턴값을 받아서 보조 업무가 사용
		System.out.println("[LOG]" + memo);
	}
	
//	After Throwing
	public void m5(Exception e) {
		System.out.println("[LOG] 예외 발생" + e.getMessage());
//		로그 남기기 or 관리자 이메일 발송 등..
		
	}
}
