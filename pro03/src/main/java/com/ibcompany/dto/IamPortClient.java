package com.ibcompany.dto;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IamPortClient {
	
	public final static String CODE = "imp60481580";
	public final static String KEY = "1147403416611088";
	public final static String SECRET = "ABlPEFinEF0egaXsrPLpo3YII9PoUs7H9b3hFABKgUaOPBxGdZHgz4bYXLzRwi0fF2SpQiY17Njc88I9";
	
	private String randChar;

	public IamPortClient() {
		Date date = new Date();
		this.randChar = date + RandomStringUtils.randomAlphanumeric(12);
	}
}
