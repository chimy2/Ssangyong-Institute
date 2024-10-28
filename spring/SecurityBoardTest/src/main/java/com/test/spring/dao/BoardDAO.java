package com.test.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring.dto.BoardDTO;
import com.test.spring.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Repository
//@RequiredArgsConstructor
public class BoardDAO {

	@Autowired
//	private final BoardMapper mapper;
	private BoardMapper mapper;
	
//	글쓰기
	public int add(BoardDTO dto) {
		return mapper.add(dto);
	}

//	목록보기
	public List<BoardDTO> list() {
		return mapper.list();
	}

//	글보기
	public BoardDTO get(String seq) {
		return mapper.get(seq);
	}

//	수정하기
	public int edit(BoardDTO dto) {
		return mapper.edit(dto);
	}

//	삭제하기
	public int del(BoardDTO dto) {
		return mapper.del(dto);
	}
	
}
