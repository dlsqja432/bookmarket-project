package com.ibcompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibcompany.dto.Member;
import com.ibcompany.service.MemberService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	private MemberService memberService;

	@Autowired
	public AdminController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("memberList.do")
	public String memberList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		model.addAttribute("memberList",memberList);
		return "admin/memberList";
	}
}
