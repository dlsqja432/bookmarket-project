package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Basket;

@Repository
public class BasketDAOImpl implements BasketDAO {

	private SqlSession sqlSession;

	@Autowired
	public BasketDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Basket> getBasketList() {
		return sqlSession.selectList("basket.getBasketList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("basket.maxNum");
	}

	@Override
	public Basket getBasket(int bno) {
		return sqlSession.selectOne("basket.getBasket", bno);
	}

	@Override
	public void insBasket(Basket basket) {
		sqlSession.insert("basket.insBasket", basket);
	}

	@Override
	public void upBasket(Basket basket) {
		sqlSession.update("basket.upBasket", basket);
	}

	@Override
	public void delBasket(int bno) {
		sqlSession.delete("basket.delBasket", bno);
	}

}
