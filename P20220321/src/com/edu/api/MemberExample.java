package com.edu.api;

import java.util.Date;

public class MemberExample {
	public static void main(String[] args) {

		Date today = new Date("2022/04/04 12:34:55");
		System.out.println(today.toString());

		Member m1 = new Member("user1");
		Member m2 = new Member("user1");

	}
}
