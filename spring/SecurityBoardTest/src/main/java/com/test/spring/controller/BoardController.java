package com.test.spring.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring.dao.BoardDAO;
import com.test.spring.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardDAO dao;

	@GetMapping("/list.do")
	public String list(Model model) {
		
		List<BoardDTO> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
//	@PreAuthorize(access)	// > security-context.xml
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/add.do")
	public String add() {
		return "board/add";
	}
	
	@PostMapping("/addok.do")
	public String addok(BoardDTO dto) {
		int result = dao.add(dto);
		
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/view.do")
	public String view(Model model, String seq) {
		
		BoardDTO dto = dao.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "board/view";
	} 
	
	@GetMapping("/edit.do")
	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	public String edit(Model model, String seq, String id) {
		
		BoardDTO dto = dao.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "board/edit";
	}
	
	@PostMapping("/editok.do")
	@PreAuthorize("isAuthenticated()")
	public String editok(BoardDTO dto) {
		
		int result = dao.edit(dto);
		
		return "redirect:/board/view.do?seq=" + dto.getSeq();
	}
	
	@GetMapping("/del.do")
	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	public String del(Model model, String seq, String id) {
		
		model.addAttribute("seq", seq);
		
		return "board/del";
	}
	
	@PostMapping("/delok.do")
	@PreAuthorize("isAuthenticated()")
	public String delok(BoardDTO dto) {
		
		int result = dao.del(dto);
		
		return "redirect:/board/list.do";
	}
}

