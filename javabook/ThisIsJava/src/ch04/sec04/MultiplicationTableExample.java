package ch04.sec04;

public class MultiplicationTableExample {
	public static void main(String[] args) {
		for (int m = 2; m <= 9; m++) {
			System.out.println("*** " + m + "단 ***");
			for (int n = 1; n <= 9; n++) {
				System.out.println(m + " x " + n + " = " + (m * n));
			}
		}
		/*
		*** 2단 ***
		2 x 1 = 2
		2 x 2 = 4
		2 x 3 = 6
		2 x 4 = 8
		~
		9 x 5 = 45
		9 x 6 = 54
		9 x 7 = 63
		9 x 8 = 72
		9 x 9 = 81
		*/
	}
}
