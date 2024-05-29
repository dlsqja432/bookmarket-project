package com.ibcompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibcompany.dto.Member;
import com.ibcompany.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	private MemberService memberService;

	private BCryptPasswordEncoder pwdEncoder;
	
	private HttpSession session;

	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder pwdEncoder, HttpSession session) {
		this.memberService = memberService;
		this.pwdEncoder = pwdEncoder;
		this.session = session;
	}
	
	@GetMapping("agree.do")
	public String agree(Model model, RedirectAttributes rttr) {
		rttr.addAttribute("msg", "회원 약관에 동의하시기 바랍니다.");
		return "member/agree";
	}

	@GetMapping("join.do")
	public String join(Model model) {
		return "member/join";
	}
	
	@PostMapping("idCheck.do")
	public void idCheck(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		String id = request.getParameter("id");
		Member mem = memberService.getMember(id);
		boolean result;
		if(mem != null) {
			result = false;
		} else {
			result = true;
		}
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
	
	@PostMapping("joinPro.do")
	public String joinPro(HttpServletRequest request, Model model) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(pwdEncoder.encode(request.getParameter("pw")));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setAddr1(request.getParameter("addr1"));
		member.setAddr2(request.getParameter("addr2"));
		member.setPostcode(request.getParameter("postcode"));
		memberService.insMember(member);
		model.addAttribute("msg", "회원가입을 축하합니다.");
		return "redirect:/";
	}
	
	@GetMapping("login.do")
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("loginPro.do")
	public String loginPro(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		session.invalidate();
		Member mem = memberService.getMember(id);
		boolean loginSuccess = pwdEncoder.matches(pw, mem.getPw());
		if(loginSuccess) {
			session.setAttribute("memb", mem);
			session.setAttribute("sid", id);
			session.setAttribute("spw", pw);
			model.addAttribute("msg", "로그인 성공");
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인 실패");
			return "redirect:login.do";
		}
	}
	
	@GetMapping("logout.do")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 하셨습니다.");
		return "redirect:/";
	}
	
	@GetMapping("myInfo.do")
	public String myInfo(Model model) {
		return "member/myInfo";
	}
	
	@GetMapping("myUpdate.do")
	public String myUpdate(Model model) {
		return "member/myUpdate";
	}
	
	@PostMapping("myUpdatePro.do")
	public String myUpdatePro(HttpServletRequest request, Model model) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(pwdEncoder.encode(request.getParameter("pw")));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setAddr1(request.getParameter("addr1"));
		member.setAddr2(request.getParameter("addr2"));
		member.setPostcode(request.getParameter("postcode"));
		memberService.upInfo(member);
		model.addAttribute("msg", "회원가입을 축하합니다.");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("memberDelete.do")
	public String memberDelete(@RequestParam("id") String id, Model model) {
		memberService.delMember(id);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("admin.do")
	public String admin(Model model) {
		return "admin/home";
	}
	
	@GetMapping("memberList.do")
	public String memberList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		model.addAttribute("memberList",memberList);
		return "admin/memberList";
	}
}
























