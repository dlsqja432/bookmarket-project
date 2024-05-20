package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Sample;

public interface SampleDAO {
	public List<Sample> getSampleList();
	public int maxNum();
	public Sample getSample(int num);
	public void insSample(Sample sample);
	public void upSample(Sample sample);
	public void delSample(int num);
}
