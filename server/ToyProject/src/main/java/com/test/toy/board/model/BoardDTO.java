package com.test.toy.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
@Data	// Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
public class BoardDTO {

	private String seq;
	private String subject;
	private String content;
	private String regdate;
	private int readcount;
	private String id;
	
	private String regtime;	// 가공된 작성시각
	private String name;	// 작성자 이름
	private double isnew;	// 최신글
}
