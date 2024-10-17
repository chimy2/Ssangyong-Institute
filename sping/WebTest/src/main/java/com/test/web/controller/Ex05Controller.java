package com.test.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.web.model.AddressDTO;

@Controller
public class Ex05Controller {
	
	@RequestMapping(value="/ex05.do")
	public String ex05() {
		return "ex05";
	}
	
//	메소드는 용도를 명확히 하기 위해 반드시 적어주는 게 좋다
//	유지보수성/가독성 높이기 ***********
//	@RequestMapping(value="/ex05ok.do", method=RequestMethod.GET)
	@RequestMapping(value="/ex05ok.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public String ex05ok(HttpServletRequest req) {
//	public String ex05ok(@RequestParam("data") String data, Model model) {
//	public String ex05ok(@RequestParam("num") String data, Model model) {
//	public String ex05ok(@RequestParam(name = "data", defaultValue = "기본값") String data, Model model) {
	public String ex05ok(String data, Model model) {	// @RequestParam을 생략 하면 자동으로 @RequestParam(name = "data")
//		@RequestParam("data") String data	> 파라미터 자동 수집
//		=
//		String data = req.getParameter("data");
		
		System.out.println(data);
		
//		req.setAttribute("data", data);
		model.addAttribute("data", data);
		
		return "ex05ok";
	}
	
	@RequestMapping(value="/ex05ok.do1", method=RequestMethod.POST)
	public String ex05ok1 (
				Model model,
//				@RequestParam("name") String name,
//				@RequestParam("age") String age,
//				@RequestParam("address") String address
				
//				HttpServletRequest req
				
//				String name,
//				String age,
//				String address
				
				AddressDTO dto,
//				String seq
				int seq
			) throws UnsupportedEncodingException {
//		객체를 받는것보다 인코딩이 선행되어야 하므로 적용되지않음
//		req.setCharacterEncoding("UTF-8");
//		> EncodingFilter 사용
		
//		AddressDTO dto = new AddressDTO();
		
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
		
//		model.addAttribute("dto", dto);
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
//		model.addAttribute("address", address);
		
		model.addAttribute("dto", dto);
		
//		자동 형변환도 해줌
		seq += 10;
		model.addAttribute("seq", seq);
		return "ex05ok";
	}
	
	@RequestMapping(value="/ex05ok2.do", method=RequestMethod.POST)
	public String ex05ok2 (Model model,
//			@RequestParam("cb") String cb
//			String[] cb
//			@RequestParam("cb") ArrayList<String> list
			ArrayList<String> cb	// > ArrayList의 경우 @RequestParam을 생략하면 돌아가지 않는다
			) {
//		System.out.println(cb);
//		System.out.println(Arrays.toString(cb));
//		System.out.println(list);
		System.out.println(cb);
		return "ex05ok";
	}
	
	@RequestMapping(value="ex05ok3.do", method=RequestMethod.POST)
//	public String ex05ok3 (@RequestParam("data") String data, Model model) {
//	public String ex05ok3 (@ModelAttribute("data") String data) {
	public String ex05ok3 (@ModelAttribute("dto") AddressDTO dto) {
//		RequestParam을 사용하거나 생략 하는 것 대신 ModelAttribute를 사용하면 model을 통해 넘길 필요 없이 다이렉트로 넘길 수 있다.
//		아무것도 처리하지 않고 jsp에 넘기는 값이 많지 않기 때문에 ModelAttribute를 잘 사용하지는 않음
		
//		model.addAttribute("data", data);
		
		return "ex05ok";
	}
}
