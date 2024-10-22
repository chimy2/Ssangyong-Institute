package com.test.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mybatis.dao.MyBatisDAO;
import com.test.mybatis.dto.AddressDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyBatisController {

//	Controller > (의존) > DAO
	@Autowired
	private final MyBatisDAO dao;

	@GetMapping(value = "/test.do")
	public String test() {
		System.out.println(dao == null);

		return "list";
	}

//	반환값(X), 매개변수(X)
	@GetMapping(value = "m1.do")
	public String m1() {

		dao.m1();

		return "list";
	}

//	반환값(X), 매개변수(O)
	@GetMapping(value = "m2.do")
	public String m2(Model model, @RequestParam(name = "seq") String seq) {

//		삭제
//		- delete from tblAddress wher seq = 12
		int result = dao.m2(seq);

		model.addAttribute("result", result);

		return "list";
	}

//	반환값(X), 매개변수(O)
	@GetMapping(value = "m3.do")
	public String m3() {

//		수정
//		- update tblAddress set age = #{age}, address = #{address}, gender = #{gender} where id = 10

		AddressDTO dto = new AddressDTO();

		dto.setSeq("10");
		dto.setAge(5);
		dto.setAddress("서울시 강남구 대치동");
		dto.setGender("f");

		int result = dao.m3(dto);

		System.out.println(result);

		return "list";
	}

//	반환값(O) > 단일값(1행 1열)
	@GetMapping(value = "/m4.do")
	public String m4(Model model) {

//		select count(*) from tblAddress

		int count = dao.m4();

		model.addAttribute("count", count);

		return "list";
	}

//	반환값(O) > 단일값(1행 N열)
	@GetMapping(value = "/m5.do")
	public String m5(Model model, @RequestParam(name = "seq", defaultValue = "1") Integer seq) {
//		select * from tblAddress where seq = ?

		AddressDTO dto = dao.m5(seq);

		model.addAttribute("dto", dto);

		return "list";
	}
	
//	반환값(O) > 단일값(N행 1열)
	@GetMapping(value = "/m6.do")
	public String m6(Model model) {
//		select name from tblAddress
		
		List<String> names = dao.m6();
		
		model.addAttribute("names", names);
		
		return "list";
	}
	
//	반환값(O) > 단일값(N행 N열)
	@GetMapping(value = "/m7.do")
	public String m7(Model model) {
//		select * from tblAddress
		
		List<AddressDTO> list = dao.m7();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m8.do")
	public String m8(Model model, String table) {
//		m8.do?table=tblAddress
//		- select count(*) from tblAddress
		
//		m8.do?table=tblUser
//		- select count(*) from tblUser
		
		int count = dao.m8(table);
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	@GetMapping(value = "/m9.do")
	public String m9(Model model, int age) {
		
//		m9.do?age=25
//		- select * from tblAddress where age < 25
		
		List<AddressDTO> list = dao.m9(age);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m10.do")
	public String m10(Model model, String word) {
//		m10.do?word=검색어
//		- select * from tblAddress where address like '%검색어%'
		
		List<AddressDTO> list = dao.m10(word);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m11.do")
	public String m11(Model model, String gender) {
		
//		m11.do?gender=m
//		m11.do?gender=f
//		m11.do
		
//		동적 쿼리(Dynamic Query)
//		- select * from tblAddress where gender = 'm'
//		- select * from tblAddress where gender = 'f'
//		- select * from tblAddress
		
		List<AddressDTO> list = dao.m11(gender);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m12.do")
	public String m12(Model model, String gender) {
		
		List<AddressDTO> list = dao.m12(gender);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m13.do")
	public String m13(Model model, String gender, String word) {
		
//		m13.do
//		m13.do?gender=f
//		m13.do?word=역삼
//		m13.do?gender=m&word=역삼
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("gender", gender);
		map.put("word", word);
		
		List<AddressDTO> list = dao.m13(map);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m14.do")
	public String m14(Model model) {
		
		AddressDTO dto = new AddressDTO();
		
		dto.setName("사막여우");
		dto.setAge(3);
		dto.setAddress("이집트");
		dto.setGender("f");
		
//		방금 insert한 레코드의 seq?
//		1. insert
//		2. select max(seq)
		int result = dao.m14(dto);
		
		model.addAttribute("result", result);
		model.addAttribute("dto", dto);
		
		return "list";
	}
	
	@GetMapping(value = "/m15.do")
	public String m15(Model model) {
		
//		이름검색: 강아지 or 사자
//		- where name in ('강아지', '사자')
		List<String> search = new ArrayList<String>();
		
		search.add("강아지");
		search.add("사자");
		
		List<AddressDTO> list = dao.m15(search);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m16.do")
	public String m16(Model model) {
		
		
		
		return "list";
	}
	
	@GetMapping(value = "/m17.do")
	public String m17(Model model) {
		
		
		
		return "list";
	}
}
