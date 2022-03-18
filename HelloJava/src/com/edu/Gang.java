package com.edu;

import java.util.Scanner;

public class Gang {
	public static void main(String[] args) {

		int answer = 5;
		int[] number9 = new int[9];
		// 중복제외하고 배치.
		for (int i = 0; i < number9.length;) {
			int temp = (int) (Math.random() * 9) + 1;
			if (checkExist(temp, number9)) {
				continue;
			}
			number9[i] = temp;
			i++;
		}
		// 초기화면..
		for (int i = 0; i < 9; i++) {
			System.out.printf("%3s", "?");// number9[i]);
			if (i % 3 == 2) {
				System.out.println();
			}
		}

		Scanner scn = new Scanner(System.in);
		int[] selectedAry = new int[9];
		while (true) {
			System.out.print("input>> (1~9) ");
			int val = scn.nextInt();
			// 입력했던 값들을 배열에 누적.
			for (int i = 0; i < selectedAry.length; i++) {
				if (selectedAry[i] == 0) {
					selectedAry[i] = val;
					break;
				}
			}
			if (number9[(val - 1)] == answer) {
				System.out.println("correct");
				break;
			}
			int correct = 0;
			for (int i = 0; i < number9.length; i++) {
				correct = 0;
				for (int j = 0; j < selectedAry.length; j++) {
					if (number9[i] == selectedAry[j]) {
						correct = selectedAry[j];
						break;
					}
				}
				if (correct != 0) {
					System.out.printf("%3d", number9[correct - 1]);// number9[i]);
				} else {
					System.out.printf("%3s", "?");// number9[i]);
				}

				if (i % 3 == 2) {
					System.out.println();
				}
			}

		}
		System.out.println("end of program");
	}

	public static boolean checkExist(int searchNo, int[] intAry) {
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] == searchNo) {
				return true;
			}
		}
		return false;
	}

}
