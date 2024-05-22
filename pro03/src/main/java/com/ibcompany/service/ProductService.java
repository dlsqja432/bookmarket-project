package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Product;

public interface ProductService {

	public List<Product> getProductList();
	public List<Product> getCategoryList();
	public int maxNum();
	public Product getProduct(int pno);
	public void insProduct(Product product);
	public void upProduct(Product product);
	public void delProduct(int pno);
}
