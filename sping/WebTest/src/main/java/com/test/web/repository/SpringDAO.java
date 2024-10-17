package com.test.web.repository;

import org.springframework.stereotype.Component;

//아무런 특징이 없지만 스프링이 관리해야하는 빈으로 만들 때 사용하는 어노테이션
//@Component
public class SpringDAO {

	public int getCount() {
		return 100;
	}
}
