package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Fileboard;

public interface FileboardDAO {
	
	public List<Fileboard> getFileboardList();
	public int maxNum();
	public Fileboard getFileboard(int no);
	public void insFileboard(Fileboard fileboard);
	public void upFileboard(Fileboard fileboard);
	public void upHits(int no);
	public void delFileboard(int no);
}
