package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Free;

public interface FreeDAO {
	
	public List<Free> getFreeList();
	public int maxNum();
	public Free getFree(int no);
	public void insFree(Free free);
	public void upFree(Free free);
	public void upHits(int no);
	public void delFree(int no);
}
