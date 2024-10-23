package com.test.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.dao.AddressDAO;
import com.test.rest.dto.AddressDTO;

import lombok.RequiredArgsConstructor;

//@Controller
@RestController	// 모든 요청 메서드의 반환값을 JSON으로 처리된다.
@RequiredArgsConstructor
//@RequestMapping("/address")
public class AddressController {
	
	private final AddressDAO dao;
	
//	m1.do > 요청 후 JSON 반환(순수 데이터 반환)
//	예전스타일
	@GetMapping("m1.do")
//	public AddressDTO m1() {
	public @ResponseBody AddressDTO m1() {
		AddressDTO dto = dao.m1();
		
		return dto;
	}
	
	@GetMapping("m2.do")
	public AddressDTO m2() {
		AddressDTO dto = dao.m1();
		
		return dto;
	}
	
//	Address > CRUD > RESTful
	
//	추가하기
//	1. http://localhost:8090/rest/address
//	2. POST
//	3. return int
	@PostMapping("/address")
	public int add(@RequestBody AddressDTO dto) {
//		@RequestBody 클라이언트가 보낸 JSON을 dto로 변환
//		@ResponseBody 서버에서 보낼 데이터를 JSON으로 변환
		int result = dao.add(dto);
		
		return result;
	}	
	
//	목록보기
//	1. http://localhost:8090/rest/address
//	2. GET
//	3. return List<DTO>

	@GetMapping("/address")
	public List<AddressDTO> list() {
		
		return dao.list();
	}
	
//	수정하기
//	1. http://localhost:8090/rest/address/1
//	2. PUT
//	3. return int
//	@RequestMapping(value="/address/{seq}", method=RequestMethod.PUT)
	@PutMapping(value="/address/{seq}")	//경로 변수(PathVariable)
	public int edit(@RequestBody AddressDTO dto, @PathVariable("seq") String seq) {
		dto.setSeq(seq);
		
		return dao.edit(dto);
	}
	
//	삭제하기
//	1. http://localhost:8090/rest/address/1
//	2. DELETE
//	3. return int
	@DeleteMapping("/address/{seq}")
	public int delete(@PathVariable("seq") String seq) {
		return dao.del(seq);
	}
	
//	검색하기
//	1. http://localhost:8090/rest/address/검색어
//	2. GET
//	3. return List<AddressDTO>
	@GetMapping("/address/{word}")
	public List<AddressDTO> search(@PathVariable("word") String word) {
		return dao.search(word);
	}
}
