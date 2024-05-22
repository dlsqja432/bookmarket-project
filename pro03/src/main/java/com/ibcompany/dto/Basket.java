package com.ibcompany.dto;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
	
	private int bno;
	private String id;
	private int pno;
	private int amount;
	private String remark;
	private String resdate;
}
