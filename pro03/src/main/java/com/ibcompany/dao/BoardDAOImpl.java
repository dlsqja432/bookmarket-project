package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private SqlSession sqlSession;

	@Autowired
	public BoardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Board> getBoardList() {
		return sqlSession.selectList("board.getBoardList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("board.maxNum");
	}

	@Override
	public Board getBoard(int bno) {
		return sqlSession.selectOne("board.getBoard", bno);
	}

	@Override
	public void insBoard(Board board) {
		sqlSession.insert("board.insBoard", board);
	}

	@Override
	public void upBoard(Board board) {
		sqlSession.update("board.upBoard", board);
	}

	@Override
	public void delBoard(int bno) {
		sqlSession.delete("board.delBoard", bno);
	}

	@Override
	public void upVcnt(int bno) {
		sqlSession.update("board.upVcnt", bno);
	}
}
