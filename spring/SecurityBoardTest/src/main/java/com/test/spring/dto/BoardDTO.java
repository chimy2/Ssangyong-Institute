package com.test.spring.dto;

import lombok.Data;

@Data
public class BoardDTO {

	private String seq;
	private String subject;
	private String content;
	private String regdate;
	private String memberid;
}
