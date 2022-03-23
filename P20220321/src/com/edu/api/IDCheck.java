package com.edu.api;

public class IDCheck {
	// 주민번호 입력 -> 950304-1234567, 000205-4567890
	// 950304-1234567, 950304 1234567, 9503041234567

	// String getGender() -> 남자, 여자.
	public String getGender(String ssno) {

		ssno = ssno.replace("-", "");
		ssno = ssno.replace(" ", "");

		if (ssno.charAt(6) == '1' || ssno.charAt(6) == '3') {
			return "남자";
		} else if (ssno.charAt(6) == '2' || ssno.charAt(6) == '4') {
			return "여자";
		} else {
			return "잘못된 번호입니다";
		}
	}

}
