package com.ibcompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibcompany.dto.Inventory;
import com.ibcompany.dto.Product;
import com.ibcompany.service.InventoryService;
import com.ibcompany.service.ProductService;

@Controller
@RequestMapping("/inventory/")
public class InventoryController {
	
	private InventoryService inventoryService;
	private ProductService productService;
	
	@Autowired
	public InventoryController(InventoryService inventoryService, ProductService productService) {
		this.inventoryService = inventoryService;
		this.productService = productService;
	}
	
	@GetMapping("inventoryList.do")
	public String inventoryList(Model model) {
		List<Inventory> inventoryList = inventoryService.getInventoryList();
		List<Product> productList = productService.getProductList();
		List<Product> inProductList = new ArrayList<Product>();
		
		for(int i=0; i<inventoryList.size(); i++) {
			for(int j=0; j<productList.size(); j++) {
				if(inventoryList.get(i).getPno() == productList.get(j).getPno()) {
					inProductList.add(productList.get(j));
					continue;
				}
			}
		}
		
		model.addAttribute("inventoryList", inventoryList);
		model.addAttribute("productList", inProductList);
		
		return "admin/inventoryList";
	}
	
	@GetMapping("insInventory.do")
	public String insInventory(Model model) {
		return "admin/insInventory";
	}
	
	@PostMapping("insInventoryPro.do")
	public String insInventoryPro(@RequestAttribute("inventory") Inventory inventory, Model model) {
		Inventory inven = inventoryService.getInventoryPno(inventory.getPno());
		return "redirect:inventoryList.do";
	}
}


















