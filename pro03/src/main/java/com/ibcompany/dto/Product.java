package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int pno;
	private String category;
	private String pname;
	private String com;
	private int price;
	private String img;
	private String img2;
	private float star;
	private int rcnt;
}
