package com.test.toy.board.repository;

import lombok.Data;

@Data
public class CommentDTO {
	
	private String seq;
	private String content;
	private String regdate;
	private String id;
	private String bseq;
	
//	tblUser(name)
	private String name;
}
