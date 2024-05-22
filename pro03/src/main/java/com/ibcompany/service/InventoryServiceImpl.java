package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.InventoryDAO;
import com.ibcompany.dto.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryDAO inventoryDAO;
	
	@Autowired
	public InventoryServiceImpl(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	@Override
	public List<Inventory> getInventoryList() {
		return inventoryDAO.getInventoryList();
	}

	@Override
	public int maxNum() {
		return inventoryDAO.maxNum();
	}

	@Override
	public Inventory getInventoryIno(int ino) {
		return inventoryDAO.getInventoryIno(ino);
	}

	@Override
	public Inventory getInventoryPno(int pno) {
		return inventoryDAO.getInventoryPno(pno);
	}

	@Override
	public void insInventory(Inventory inventory) {
		inventoryDAO.insInventory(inventory);
	}

	@Override
	public void upInventoryAll(Inventory inventory) {
		inventoryDAO.upInventoryAll(inventory);
	}
	
	@Override
	public void upInventoryAmount(Inventory inventory) {
		inventoryDAO.upInventoryAmount(inventory);
	}

	@Override
	public void delInventory(int ino) {
		inventoryDAO.delInventory(ino);
	}
}
