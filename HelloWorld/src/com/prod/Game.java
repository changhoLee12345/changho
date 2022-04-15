package com.prod;

public class Game {
	public static void main(String[] args) {
//	 ___________________
//	|[01]|[02]|[03]|[04]|
//	|____|____|____|____|
//	|[05]|[06]|[07]|[08]|
//	|____|____|____|____|
//	|[09]|[10]|[11]|[12]|
//	|____|____|____|____|
//	|[13]|[14]|[15]|[16]|
//	|____|____|____|____|

		int[] rect = new int[16];
		int cnt = 1;
		for (int i = 0; i < rect.length; i++) {
			if (i % 2 == 0) {
				rect[i] = cnt;
			} else {
				rect[i] = cnt++;
			}
		}
		for (int i = 0; i < rect.length; i++) {
			System.out.print(rect[i] + " ");
		}
		System.out.println();

		System.out.println(" ___________________");
		for (int i = 0; i < rect.length; i++) {
			String digit = toDigit(i + 1);
			System.out.print("|" + digit);
			if (i % 4 == 3) {
				System.out.print("|\n");
				for (int j = 0; j < 4; j++) {
					System.out.print("|____");
					if (j == 3) {
						System.out.print("|\n");
					}
				}
			}
		}
	}

	public static String toDigit(int num) {

		String digit = (num < 10 ? "[0" + num + "]" : "[" + num + "]");
		return digit;

	}
}
