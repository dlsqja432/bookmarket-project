package com.ibcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fileboard {
	
	private int no;
	private String title;
	private String content;
	private String url;
	private int hits;
	private String resdate;
	private String author;
}
