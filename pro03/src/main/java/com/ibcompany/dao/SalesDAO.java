package com.ibcompany.dao;

import java.util.List;

import com.ibcompany.dto.Sales;

public interface SalesDAO {
	int maxNum();	//총 거래수
	List<Sales> getAllSalesList();	//관리자 판매 전체 목록
	List<Sales> getStateSalesList(String st);	//관리자 판매 진행 상태별 목록
	List<Sales> getDelStateSalesList(String delStatus);	//관리자 배송 상태별 목록
	List<Sales> getPnoSalesList(int pno);	//상품별 판매 목록
	List<Sales> getSalesList(String id);	//고객별 구매 목록
	Sales getSales(int sno);	//해당 구매 건별 상세 내역
	void insSales(Sales sales);	// 구매(판매) 처리
	void upSales(Sales sales);	//구매(판매) 처리
	void upDelivery(Sales sales);	//배송지 변경
	void completeDelivery(Sales sales);	//거래 완료
	void delSales(int sno);	//결제 취소
}
