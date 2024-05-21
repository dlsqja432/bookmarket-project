package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Board;

public interface BoardDAO {
	
	public List<Board> getBoardList();
	public int maxNum();
	public Board getBoard(int bno);
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void upVcnt(int bno);
	public void delBoard(int bno);
}
