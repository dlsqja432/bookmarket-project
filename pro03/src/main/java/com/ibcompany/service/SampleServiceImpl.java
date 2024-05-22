package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.SampleDAO;
import com.ibcompany.dto.Sample;

@Service
public class SampleServiceImpl implements SampleService {

	private SampleDAO sampleDAO;

	@Autowired
	public SampleServiceImpl(SampleDAO sampleDAO) {
		this.sampleDAO = sampleDAO;
	}

	@Override
	public List<Sample> getSampleList() {
		return sampleDAO.getSampleList();
	}

	@Override
	public int maxNum() {
		return sampleDAO.maxNum();
	}

	@Override
	public Sample getSample(int num) {
		return sampleDAO.getSample(num);
	}

	@Override
	public void insSample(Sample sample) {
		sampleDAO.insSample(sample);
	}

	@Override
	public void upSample(Sample sample) {
		sampleDAO.upSample(sample);
	}

	@Override
	public void delSample(int num) {
		sampleDAO.delSample(num);
	}

}
