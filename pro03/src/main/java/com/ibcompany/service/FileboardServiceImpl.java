package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.FileboardDAO;
import com.ibcompany.dto.Fileboard;

@Service
public class FileboardServiceImpl implements FileboardService {

	private FileboardDAO fileboardDAO;
	
	@Autowired
	public FileboardServiceImpl(FileboardDAO fileboardDAO) {
		this.fileboardDAO = fileboardDAO;
	}

	@Override
	public List<Fileboard> getFileboardList() {
		return fileboardDAO.getFileboardList();
	}

	@Override
	public int maxNum() {
		return fileboardDAO.maxNum();
	}

	@Override
	public Fileboard getFileboard(int no) {
		return fileboardDAO.getFileboard(no);
	}

	@Override
	public void insFileboard(Fileboard fileboard) {
		fileboardDAO.insFileboard(fileboard);
	}

	@Override
	public void upFileboard(Fileboard fileboard) {
		fileboardDAO.upFileboard(fileboard);
	}

	@Override
	public void upHits(int no) {
		fileboardDAO.upHits(no);
	}

	@Override
	public void delFileboard(int no) {
		fileboardDAO.delFileboard(no);
	}

}
