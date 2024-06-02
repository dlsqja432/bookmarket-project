package com.ibcompany.dao;

import java.util.List;
import java.util.Map;

import com.ibcompany.dto.Product;

public interface ProductDAO {
	
	public List<Product> getProductList(Map<String, Object> paramMap);
	public List<Product> getCategoryList(String category);
	public int maxNum();
	public Product getProduct(int pno);
	public void insProduct(Product product);
	public void upProduct(Product product);
	public void delProduct(int pno);
}
