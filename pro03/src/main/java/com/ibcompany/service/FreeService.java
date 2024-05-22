package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Free;

public interface FreeService {
	
	public List<Free> getFreeList();
	public int maxNum();
	public Free getFree(int no);
	public void insFree(Free free);
	public void upFree(Free free);
	public void upHits(int no);
	public void delFree(int no);
}
