package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
	
	private int sno;
	private int amount;
	private int tot;
	private String paymethod;
	private String paynum;
	private String addr;
	private String tel;
	private String delcom;
	private String deltel;
	private String delno;
	private String delstatus;
	private String st;
	private String resdate;
	private Member member;
	private Product product;
}
