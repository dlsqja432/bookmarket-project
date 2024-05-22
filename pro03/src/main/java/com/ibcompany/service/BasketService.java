package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Basket;

public interface BasketService {

	public List<Basket> getBasketList();
	public int maxNum();
	public Basket getBasket(int bno);
	public void insBasket(Basket basket);
	public void upBasket(Basket basket);
	public void delBasket(int bno);
}
