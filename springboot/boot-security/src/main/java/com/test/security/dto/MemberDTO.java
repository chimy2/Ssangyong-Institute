package com.test.security.dto;

import lombok.Data;

@Data
public class MemberDTO {

	private Long seq;
	private String username;
	private String password;
	private String role;
}
