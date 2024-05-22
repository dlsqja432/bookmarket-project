package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Qna;

public interface QnaDAO {

	public List<Qna> getQnaList();
	public int maxNum();
	public Qna getQna(int no);
	public void insQuestion(Qna qna);
	public void insAnswer(Qna qna);
	public void upParno();
	public void upQna(Qna qna);
	public void upHits(int no);
	public void delQuestion(int parno);
	public void delAnswer(int no);
}
