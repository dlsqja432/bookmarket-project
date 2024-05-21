package com.ibcompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibcompany.dto.Sample;
import com.ibcompany.service.SampleService;

@Controller
@RequestMapping("/sample/")
public class SampleController {
	
	private SampleService sampleService;

	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	@GetMapping("list.do")
	public String getSampleList(Model model) {
		List<Sample> sampleList = sampleService.getSampleList();
		model.addAttribute("sampleList", sampleList);
		return "sample/sampleList";
	}
}
