package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Fileboard;

public interface FileboardService {
	
	public List<Fileboard> getFileboardList();
	public int maxNum();
	public Fileboard getFileboard(int no);
	public void insFileboard(Fileboard fileboard);
	public void upFileboard(Fileboard fileboard);
	public void upHits(int no);
	public void delFileboard(int no);
}
