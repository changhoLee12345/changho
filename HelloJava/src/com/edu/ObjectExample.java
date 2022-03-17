package com.edu;

//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
public class ObjectExample {
	public static void main(String[] args) {

		System.out.println("구구단 출력..");

		for (int j = 0; j <= 9; j++) {
			for (int i = 2; i <= 9; i++) {
				if (j == 0) {
					System.out.print("  [" + i + "단]        ");
				} else {
//					System.out.print(i + " * " + j + " = " + (i * j) + " ");
					System.out.printf("%2d * %2d = %2d  ", i, j, (i*j));
				}
			}
			System.out.println();
		}
	}
}
