package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.CategoryVO;
import com.ibcompany.dto.Inventory;

public interface InventoryService {
	
	public List<Inventory> getInventoryList();
	public List<CategoryVO> categoryLoading(String category);
	public int maxNum();
	public Inventory getInventoryIno(int ino);
	public Inventory getInventoryPno(int pno);
	public void insInventory(Inventory inventory);
	public void upInventoryAll(Inventory inventory);
	public void upInventoryAmount(Inventory inventory);
	public void delInventory(int ino);
}
