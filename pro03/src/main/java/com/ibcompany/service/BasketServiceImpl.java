package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.BasketDAO;
import com.ibcompany.dto.Basket;

@Service
public class BasketServiceImpl implements BasketService {

	private BasketDAO basketDAO;

	@Autowired
	public BasketServiceImpl(BasketDAO basketDAO) {
		this.basketDAO = basketDAO;
	}

	@Override
	public List<Basket> getBasketList() {
		return basketDAO.getBasketList();
	}

	@Override
	public int maxNum() {
		return basketDAO.maxNum();
	}

	@Override
	public Basket getBasket(int bno) {
		return basketDAO.getBasket(bno);
	}

	@Override
	public void insBasket(Basket basket) {
		basketDAO.insBasket(basket);
	}

	@Override
	public void upBasket(Basket basket) {
		basketDAO.upBasket(basket);
	}

	@Override
	public void delBasket(int bno) {
		basketDAO.delBasket(bno);
	}

}
