package com.ibcompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibcompany.dto.Product;
import com.ibcompany.dto.Review;
import com.ibcompany.service.ProductService;
import com.ibcompany.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	
	private ReviewService reviewService;
	private ProductService productService;
	
	@Autowired
	public ReviewController(ReviewService reviewService, ProductService productService) {
		this.reviewService = reviewService;
		this.productService = productService;
	}
	
	@GetMapping("reviewList.do")
	public String reviewList(Model model) {
		List<Review> reviewList = reviewService.getReviewList();
		model.addAttribute(reviewList);
		return "review/reviewList";
	}
	
	@GetMapping("insReview.do")
	public String insReview(Model model) {
		return "review/insReview";
	}
	
	@PostMapping("insReviewPro.do")
	public String insReviewPro(HttpServletRequest request, Model model) {
		Review review = new Review();
		review.setPno(Integer.parseInt(request.getParameter("pno")));
		review.setId(request.getParameter("id"));
		review.setContent(request.getParameter("content"));
		review.setImg(request.getParameter("img"));
		review.setStar(Float.parseFloat(request.getParameter("star")));
		
		reviewService.insReview(review);
		
		return "redirect:reviewList.do";
	}
	
	@GetMapping("getReview.do")
	public String getReview(@RequestParam("rno") int rno, Model model) {
		Review review = reviewService.getReview(rno);
		Product product = productService.getProduct(review.getPno());
		model.addAttribute("review", review);
		model.addAttribute("product", product);
		return "review/getReview";
	}
}
























