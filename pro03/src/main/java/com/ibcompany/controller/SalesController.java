package com.ibcompany.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibcompany.dto.Sales;
import com.ibcompany.service.InventoryService;
import com.ibcompany.service.ProductService;
import com.ibcompany.service.SalesService;

@Controller
@RequestMapping("/sales/")
public class SalesController {
	
	private static final Logger log = LoggerFactory.getLogger(SalesController.class);
	
	private SalesService salesService;
	private ProductService productService;
	private InventoryService inventoryService;
	private HttpSession session;

	@Autowired
	public SalesController(SalesService salesService, ProductService productService, InventoryService inventoryService, HttpSession session) {
		this.salesService = salesService;
		this.productService = productService;
		this.inventoryService = inventoryService;
		this.session = session;
	}
	
	//고객별 구매 목록
	@GetMapping("salesList.do")
	public String getSalesList(Model model) {
		String id = (String) session.getAttribute("sid");
		model.addAttribute("salesList", salesService.getSalesList(id));
		return "sales/salesList";
	}
	
	//해당 구매 건별 상세 목록
	@GetMapping("sales.do")
	public String getSales(@RequestParam("sno") int sno, Model model) {
		model.addAttribute("sales", salesService.getSales(sno));
		return "sales/get";
	}
	
	@PostMapping("insSales.do")
	public String insSales(@RequestParam("pno") int pno, Model model) {
		model.addAttribute("product", salesService.getSales(pno));
		model.addAttribute("inventory", inventoryService.getInventoryPno(pno));
		return "sales/insert";
	}
	
	//(구매)판매 처리
	@PostMapping("insSalesPro.do")
	public String insSalesPro(Sales sales, Model model) {
		salesService.insSales(sales);
		return "redirect:/product/productList.do";
	}
	
	@GetMapping("upSales.do")
	public String upSales(@RequestParam("sno") int sno, Model model) {
		model.addAttribute("sales", salesService.getSales(sno));
		return "sales/edit";
	}
	
	@PostMapping("upSalesPro.do")
	public String upSalesPro(Sales sales, Model model) {
		salesService.upSales(sales);
		return "redirect:salesList.do";
	}
}





























