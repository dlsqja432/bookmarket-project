package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	private SqlSession sqlSession;
	
	@Autowired
	public InventoryDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Inventory> getInventoryList() {
		return sqlSession.selectList("inventory.getInventoryList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("inventory.maxNum");
	}

	@Override
	public Inventory getInventoryIno(int ino) {
		return sqlSession.selectOne("inventory.getInventoryIno", ino);
	}

	@Override
	public Inventory getInventoryPno(int pno) {
		return sqlSession.selectOne("inventory.getInventoryPno", pno);
	}

	@Override
	public void insInventory(Inventory inventory) {
		sqlSession.insert("inventory.insInventory", inventory);
	}

	@Override
	public void upInventoryAll(Inventory inventory) {
		sqlSession.update("inventory.upInventoryAll", inventory);
	}
	
	@Override
	public void upInventoryAmount(Inventory inventory) {
		sqlSession.update("inventory.upInventoryAmount", inventory);
	}

	@Override
	public void delInventory(int ino) {
		sqlSession.delete("inventory.delInventory", ino);
	}
}
