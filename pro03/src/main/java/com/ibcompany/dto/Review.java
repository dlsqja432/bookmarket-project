package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
	private int rno;
	private int pno;
	private String id;
	private String content;
	private String img;
	private String resdate;
	private float star;
}
