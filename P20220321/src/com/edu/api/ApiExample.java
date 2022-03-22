package com.edu.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ApiExample {
	public static void main(String[] args) {
		byte[] bytes;
		try {
			bytes = "한글".getBytes("UTF-8");
			System.out.println(new String(bytes));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");
	}
}
