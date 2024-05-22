package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qna {
	
	private int no;
	private String title;
	private String content;
	private int lev;
	private int parno;
	private int hits;
	private String resdate;
	private Member member;
}
