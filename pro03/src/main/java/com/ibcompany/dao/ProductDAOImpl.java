package com.ibcompany.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private SqlSession sqlSession;
	
	@Autowired
	public ProductDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Product> getProductList(Map<String, Object> paramMap) {
		return sqlSession.selectList("product.getProductList", paramMap);
	}

	@Override
	public List<Product> getCategoryList(Map<String, Object> paramMap) {
		return sqlSession.selectList("product.getCategoryList", paramMap);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("product.maxNum");
	}
	
	@Override
	public int categoryMaxNum(String category) {
		return sqlSession.selectOne("product.categoryMaxNum", category);
	}

	@Override
	public Product getProduct(int pno) {
		return sqlSession.selectOne("product.getProduct", pno);
	}

	@Override
	public void insProduct(Product product) {
		sqlSession.insert("product.insProduct", product);
	}

	@Override
	public void upProduct(Product product) {
		sqlSession.update("product.upProduct", product);
	}

	@Override
	public void delProduct(int pno) {
		sqlSession.delete("product.delProduct", pno);
	}

}
