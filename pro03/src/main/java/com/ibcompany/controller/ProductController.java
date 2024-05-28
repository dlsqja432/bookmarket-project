package com.ibcompany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ibcompany.dto.Product;
import com.ibcompany.service.ProductService;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private ProductService productService;
	private ServletContext servletContext;

	@Autowired
	public ProductController(ProductService productService, ServletContext servletContext) {
		this.servletContext = servletContext;
		this.productService = productService;
	}
	
	@GetMapping("productList.do")
	public String productList(Model model) {
		List<Product> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		return "product/productList";
	}
	
	@GetMapping("categoryList.do")
	public String categoryList(@RequestParam("category") String category, Model model) {
		List<Product> categoryList = productService.getCategoryList(category);
		model.addAttribute("categoryList",categoryList);
		return "product/" + category + "List";
	}
	
	@GetMapping("getProduct.do")
	public String getProduct(@RequestParam("pno") int pno, Model model) {
		Product product = productService.getProduct(pno);
		model.addAttribute("product",product);
		return "product/getProduct";
	}
	
	@GetMapping("insProduct.do")
	public String insProduct(Model model) {
		return "product/insProduct";
	}
	
	@PostMapping("insProductPro.do")
	public String insProductPro(MultipartHttpServletRequest files, Product product, Model model) {
		String uploadFolder = servletContext.getRealPath("/resources/upload");
		List<MultipartFile> list = files.getFiles("files");
		
		List<UploadData> datas = new ArrayList<>();
		return "redirect:productList.do";
	}
}
