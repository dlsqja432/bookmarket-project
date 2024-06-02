package com.ibcompany.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ibcompany.dto.Product;
import com.ibcompany.service.ProductService;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	private ProductService productService;
	private ServletContext servletContext;
	private String uploadLoc = "/resources/upload";

	@Autowired
	public ProductController(ProductService productService, ServletContext servletContext) {
		this.servletContext = servletContext;
		this.productService = productService;
	}
	
	@GetMapping("productList.do")
	public String productList(@RequestParam(defaultValue = "1") int page, Model model) {
		Map<String, Object> resultMap = productService.getProductList(page);
		model.addAttribute("productList", resultMap.get("productList"));
		model.addAttribute("pagingBean", resultMap.get("pagingBean"));
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
	public String insProductPro(@RequestParam("category") String category,
			@RequestParam("pname") String pname,
			@RequestParam("com") String com,
			@RequestParam("price") int price,
			@RequestParam("img") MultipartFile img,
			@RequestParam("img2") MultipartFile img2,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		File dir = new File(uploadDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String imgName = "";
		String img2Name = "";
		
		try {
			if(!img.isEmpty()) {
				imgName = saveFile(img, uploadDir);
				log.info("업로드 파일 이름 : {}", imgName);
			}
			
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("업로드 파일 이름 : {}", img2Name);
			}
		} catch(IOException e) {
			log.error("예외 : {}", e);
		}
		
		Product product = new Product();
		product.setCategory(category);
		product.setPname(pname);
		product.setCom(com);
		product.setPrice(price);
		product.setImg(imgName);
		product.setImg2(img2Name);
		productService.insProduct(product);
		
		return "redirect:productList.do";
	}
	
	public String saveFile(MultipartFile file, String uploadDir) throws IOException {
		String originalFileName = file.getOriginalFilename();
		String newFilename = UUID.randomUUID().toString() + "_" + originalFileName;
		File serverFile = new File(uploadDir + File.separator + newFilename);
		file.transferTo(serverFile);
		return newFilename;
	}
	
	@GetMapping("editProduct.do")
	public String upProduct(@RequestParam("pno") int pno, Model model) {
		Product product = productService.getProduct(pno);
		model.addAttribute("product", product);
		return "product/editProduct";
	}
	
	@PostMapping("editProductPro.do")
	public String upProductPro(@RequestParam("pno") int pno,
			@RequestParam("category") String category,
			@RequestParam("pname") String pname,
			@RequestParam("com") String com,
			@RequestParam("price") int price,
			@RequestParam("img") MultipartFile img,
			@RequestParam("img2") MultipartFile img2,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Product before = productService.getProduct(pno);
		
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		File dir = new File(uploadDir);
		
		String imgName = "";
		String img2Name = "";
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			if(!img.isEmpty()) {
				imgName = saveFile(img, uploadDir);
				log.info("변경 이미지1 이름 : {}", imgName);
			} else {
				imgName = before.getImg();
			}
			
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("변경 이미지2 이름 : {}", img2Name);
			} else {
				img2Name = before.getImg2();
			}
		} catch(IOException e) {
			log.error("예외 : {}", e);
		}
		
		Product product = new Product();
		product.setPno(pno);
		product.setCategory(category);
		product.setPname(pname);
		product.setCom(com);
		product.setPrice(price);
		product.setImg(imgName);
		product.setImg2(img2Name);
		
		productService.upProduct(product);
		return "redirect:productList.do";
	}
	
	@GetMapping("delProduct.do")
	public String delProduct(@RequestParam("pno") int pno, Model model) {
		productService.delProduct(pno);
		return "redirect:productList.do";
	}
}
