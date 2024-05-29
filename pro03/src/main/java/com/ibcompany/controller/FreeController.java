package com.ibcompany.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.maven.shared.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.ibcompany.dto.Free;
import com.ibcompany.service.FreeService;
import com.ibcompany.service.MemberService;

@Controller
@RequestMapping("/free/")
public class FreeController {

	private static final Logger log = LoggerFactory.getLogger(FreeController.class);
	
	private FreeService freeService;
	private MemberService memberService;
	private HttpSession session;
	
	@Autowired
	public FreeController(FreeService freeService, MemberService memberService, HttpSession session) {
		this.freeService = freeService;
		this.memberService = memberService;
		this.session = session;
	}

	@GetMapping("freeList.do")
	public String freeList(Model model) {
		List<Free> freeList = freeService.getFreeList();
		model.addAttribute("freeList", freeList);
		return "free/freeList";
	}
	
	@GetMapping("getFree.do")
	public String getFree(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response ,Model model) {
		
		String id = (String) session.getAttribute("sid");
		
		Cookie viewCookie = null;
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("|" + id + "free" + no + "|")) {
					log.info("쿠키 이름 : " + cookies[i].getName());
					viewCookie = cookies[i];
				}
			}
		} else {
			log.info("아직 방문한 적 없습니다.");
		}
		
		if(viewCookie == null) {
			try {
				//쿠키 생성
				Cookie newCookie = new Cookie("|" + id + "free" + no + "|" , "readCount");
				response.addCookie(newCookie);
				
				//쿠키가 없으니 증가 로직 진행
				model.addAttribute("free", freeService.getFree(no));
			} catch(Exception e) {
				log.info("쿠키 확인 불가 : " + e.getMessage());
				e.getStackTrace();
			}
		//만들어진 쿠키가 있으면 증가로직 진행하지 않음
		} else {
			model.addAttribute("free", freeService.getNoCountFree(no));
			log.info("viewCookie 확인 로직 : 쿠기 있음");
			String value = viewCookie.getValue();
			log.info("viewCookie 확인 로직 : 쿠키 value : " + value);
		}
		
		return "free/getFree";
	}
	
	@GetMapping("insFree.do")
	public String insFree(Model model) {
		return "free/insFree";
	}
	
	@PostMapping("insFreePro.do")
	public String insFreePro(Free free, HttpSession session, Model model) {
		String id = (String) session.getAttribute("sid");
		String name = (String) session.getAttribute("sname");
		free.setId(id);
		free.setName(name);
		freeService.insFree(free);
		return "redirect:freeList.do";
	}
	
	@GetMapping("editFree.do")
	public String editFree(@RequestParam("no") int no, Model model) {
		Free free = freeService.getNoCountFree(no);
		model.addAttribute(free);
		return "free/editFree";
	}
	
	@PostMapping("editFreePro.do")
	public String editFreePro(@RequestAttribute("free") Free free, Model model) {
		freeService.upFree(free);
		return "redirect:freeList.do";
	}
	
	@GetMapping("delFree.do")
	public String delFree(@RequestParam("no") int no, Model model) {
		freeService.delFree(no);
		return "redirect:freeList.do";
	}
	
	@PostMapping("fileupload.do")
	@ResponseBody
	public String fileupload(HttpServletRequest request, HttpServletResponse response,
		MultipartHttpServletRequest multiFile) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		if(file != null) {
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("images/")) {
					try {
						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						String uploadPath = request.getServletContext().getRealPath("/img");
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						fileName = UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);
						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + "/images/" + fileName;
						
						// json 데이터로 등록
						// {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/images/test.jpg"}
						// 이런 형태로 리턴이 나가야함.
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						
						printWriter.println(json);
					} catch(IOException e) {
						e.printStackTrace();
					} finally {
						if(out != null) {
							out.close();
						}
						if(printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
		return null;
	}
}












