package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String author;
	private int vcnt;
	private String resdate;
}
