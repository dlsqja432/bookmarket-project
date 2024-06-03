package com.ibcompany.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ibcompany.dto.Product;

public interface ProductDAO {
	
	public List<Product> getProductList(Map<String, Object> paramMap);
	public List<Product> getCategoryList(Map<String, Object> paramMap);
	public int maxNum();
	public int categoryMaxNum(String category);
	public Product getProduct(int pno);
	public void insProduct(Product product);
	public void upProduct(Product product);
	public void upStar(Map<String, Object> paramMap);
	public void delProduct(int pno);
}
