package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Board;

public interface BoardService {
	
	public List<Board> getBoardList();
	public int maxNum();
	public Board getBoard(int bno);
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void delBoard(int bno);
}
