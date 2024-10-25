package com.test.security.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

// DB 연동을 확인하기 위해 임시로 사용하는 PasswordEncoder이다.(실제 사용X)
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
