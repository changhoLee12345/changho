package com.edu.api;

public class ApiExample {
	public static void main(String[] args) {
		
		IDCheck idcheck = new IDCheck();
		String result = idcheck.getGender("9503041234567");
		result = idcheck.getGender("950304-3234567");

		System.out.println("end of prog");
	}
}
