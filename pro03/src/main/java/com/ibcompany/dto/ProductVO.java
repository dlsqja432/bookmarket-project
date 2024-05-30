package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	private int pno;
	private String category;
	private String pname;
	private String com;
	private String img;
	private String img2;
	private int inprice;
	private int outprice;
	private int amount;
	private int price;
}
