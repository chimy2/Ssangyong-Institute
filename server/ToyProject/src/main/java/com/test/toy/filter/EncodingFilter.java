package com.test.toy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("필터가 동작합니다.");
		
//		web.xml에 filter 설정
//		하지만 정상적인 주소로 이동해도 콘솔만 찍힘
//		Why? 요청 받은 해당 주소의 도착하기 전에 필터가 받아서 처리하기 때문에 
//			넘겨 주지 않으면 여기서 멈춘다
		
//		인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

//		그다음 요청으로 넘어가기(다음 필터 or 서블릿 호출)
		chain.doFilter(request, response);
	}
}
