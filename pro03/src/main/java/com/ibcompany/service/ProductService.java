package com.ibcompany.service;

import java.util.Map;

import com.ibcompany.dto.Product;

public interface ProductService {

	public Map<String, Object> getProductList(int nowPage);
	public Map<String, Object> getCategoryList(int nowPage, String category);
	public int maxNum();
	public int categoryMaxNum(String category);
	public Product getProduct(int pno);
	public void insProduct(Product product);
	public void upProduct(Product product);
	public void delProduct(int pno);
}
