package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.BoardDAO;
import com.ibcompany.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public int maxNum() {
		return boardDAO.maxNum();
	}

	@Override
	public Board getBoard(int bno) {
		return boardDAO.getBoard(bno);
	}

	@Override
	public void insBoard(Board board) {
		boardDAO.insBoard(board);
	}

	@Override
	public void upBoard(Board board) {
		boardDAO.upBoard(board);
	}

	@Override
	public void delBoard(int bno) {
		boardDAO.delBoard(bno);
	}

	@Override
	public void upVcnt(int bno) {
		boardDAO.upVcnt(bno);
	}
}
