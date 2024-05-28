package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.ProductDAO;
import com.ibcompany.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

	@Override
	public List<Product> getCategoryList(String category) {
		return productDAO.getCategoryList(category);
	}

	@Override
	public int maxNum() {
		return productDAO.maxNum();
	}

	@Override
	public Product getProduct(int pno) {
		return productDAO.getProduct(pno);
	}

	@Override
	public void insProduct(Product product) {
		productDAO.insProduct(product);
	}

	@Override
	public void upProduct(Product product) {
		productDAO.upProduct(product);
	}

	@Override
	public void delProduct(int pno) {
		productDAO.delProduct(pno);
	}

}
