package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.SalesDAO;
import com.ibcompany.dto.Sales;

@Service
public class SalesServiceImpl implements SalesService {

	private SalesDAO salesDAO;

	@Autowired
	public SalesServiceImpl(SalesDAO salesDAO) {
		this.salesDAO = salesDAO;
	}

	@Override
	public int maxNum() {
		return salesDAO.maxNum();
	}

	@Override
	public List<Sales> getAllSalesList() {
		return salesDAO.getAllSalesList();
	}

	@Override
	public List<Sales> getStateSalesList(String st) {
		return salesDAO.getStateSalesList(st);
	}

	@Override
	public List<Sales> getDelStateSalesList(String delStatus) {
		return salesDAO.getDelStateSalesList(delStatus);
	}

	@Override
	public List<Sales> getPnoSalesList(int pno) {
		return salesDAO.getPnoSalesList(pno);
	}

	@Override
	public List<Sales> getSalesList(String id) {
		return salesDAO.getSalesList(id);
	}

	@Override
	public Sales getSales(int sno) {
		return salesDAO.getSales(sno);
	}

	@Override
	public void insSales(Sales sales) {
		salesDAO.insSales(sales);
	}

	@Override
	public void upSales(Sales sales) {
		salesDAO.upSales(sales);
	}

	@Override
	public void upDelivery(Sales sales) {
		salesDAO.upDelivery(sales);
	}

	@Override
	public void completeDelivery(Sales sales) {
		salesDAO.completeDelivery(sales);
	}

	@Override
	public void delSales(int sno) {
		salesDAO.delSales(sno);
	}
}
