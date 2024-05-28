package com.ibcompany.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.ibcompany.dto.Free;
import com.ibcompany.service.FreeService;

@Controller
@RequestMapping("/free/")
public class FreeController {
	
	private FreeService freeService;

	@Autowired
	public FreeController(FreeService freeService) {
		this.freeService = freeService;
	}
	
	@GetMapping("freeList.do")
	public String freeList(Model model) {
		List<Free> freeList = freeService.getFreeList();
		model.addAttribute("freeList", freeList);
		return "free/freeList";
	}
	
	@GetMapping("getFree.do")
	public String getFree(@RequestParam("no") int no, Model model) {
		Free free = freeService.getFree(no);
		model.addAttribute(free);
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
		Free free = freeService.getFree(no);
		model.addAttribute(free);
		return "free/editFree";
	}
	
	@PostMapping("editFreePro.do")
	public String editFreePro(HttpServletRequest request, Model model) {
		Free free = new Free();
		free.setTitle(request.getParameter("title"));
		free.setContent(request.getParameter("content"));
		free.setNo(Integer.parseInt(request.getParameter("no")));
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












