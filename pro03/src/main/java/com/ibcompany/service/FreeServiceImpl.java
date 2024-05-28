package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibcompany.dao.FreeDAO;
import com.ibcompany.dto.Free;

@Service
public class FreeServiceImpl implements FreeService {

	private FreeDAO freeDAO;
	
	@Autowired
	public FreeServiceImpl(FreeDAO freeDAO) {
		this.freeDAO = freeDAO;
	}

	@Override
	public List<Free> getFreeList() {
		return freeDAO.getFreeList();
	}

	@Override
	public int maxNum() {
		return freeDAO.maxNum();
	}

	@Transactional
	@Override
	public Free getFree(int no) {
		freeDAO.upHits(no);
		return freeDAO.getFree(no);
	}

	@Override
	public void insFree(Free free) {
		freeDAO.insFree(free);
	}

	@Override
	public void upFree(Free free) {
		freeDAO.upFree(free);
	}

	@Override
	public void delFree(int no) {
		freeDAO.delFree(no);
	}

}
