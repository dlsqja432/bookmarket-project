package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	
	private int ino;
	private int pno;
	private String pname;
	private int inprice;
	private int outprice;
	private int amount;
	private String remark;
	private String resdate;
}
