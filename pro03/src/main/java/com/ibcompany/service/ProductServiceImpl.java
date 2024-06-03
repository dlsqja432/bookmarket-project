package com.ibcompany.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.ProductDAO;
import com.ibcompany.dto.Product;
import com.ibcompany.util.PagingBean;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	//페이지당 게시물 수
	private int contentNumberPerPage = 4;
	
	//페이지 그룹 당 페이지 수
	private int pageNumberPerPageGroup = 3;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public Map<String, Object> getProductList(int nowPage) {
		Map<String, Object> resultMap = new HashMap<>();
		
		//총 게시물 수
		int totalContents = productDAO.maxNum();
		
		//PagingBean 생성
		PagingBean pagingBean = new PagingBean(totalContents, nowPage, contentNumberPerPage, pageNumberPerPageGroup);
		
		//페이징을 위한 파라미터 설정
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRowNumber", pagingBean.getStartRowNumber() - 1); //MySQL은 0부터 시작하므로 -1
		paramMap.put("contentNumberPerPage", contentNumberPerPage);
		
		//게시물 리스트 조회
		List<Product> productList = productDAO.getProductList(paramMap);
		
		resultMap.put("productList", productList);
		resultMap.put("pagingBean", pagingBean);
		return resultMap;
	}

	@Override
	public Map<String, Object> getCategoryList(int nowPage, String category) {
		Map<String, Object> resultMap = new HashMap<>();
		
		//총 게시물 수
		int totalContents = productDAO.categoryMaxNum(category);
		
		//PagingBean 생성
		PagingBean pagingBean = new PagingBean(totalContents, nowPage, contentNumberPerPage, pageNumberPerPageGroup);
		
		//페이징을 위한 파라미터 설정
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("category", category);
		paramMap.put("startRowNumber", pagingBean.getStartRowNumber() - 1);
		paramMap.put("contentNumberPerPage", contentNumberPerPage);
		
		//게시물 리스트 조회
		List<Product> categoryList = productDAO.getCategoryList(paramMap);
		
		resultMap.put("category", category);
		resultMap.put("categoryList", categoryList);
		resultMap.put("pagingBean", pagingBean);
		
		return resultMap;
	}

	@Override
	public int maxNum() {
		return productDAO.maxNum();
	}
	
	@Override
	public int categoryMaxNum(String category) {
		return productDAO.categoryMaxNum(category);
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
