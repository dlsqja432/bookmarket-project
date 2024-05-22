package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Inventory;

public interface InventoryDAO {
	
	public List<Inventory> getInventoryList();
	public int maxNum();
	public Inventory getInventoryIno(int ino);
	public Inventory getInventoryPno(int pno);
	public void insInventory(Inventory inventory);
	public void upInventoryAll(Inventory inventory);
	public void upInventoryAmount(Inventory inventory);
	public void delInventory(int ino);
}
