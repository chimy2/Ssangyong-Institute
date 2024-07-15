package com.test.question;

public class Q045 {
	
	public static void main(String[] args) {
		
		int num = 123;
		
		System.out.println(num % 10);
		num /= 10;
		System.out.println(num % 10);
		num /= 10;
		System.out.println(num % 10);
		
		
		for (int i = 1; i <= 50; i++) {
            int clapCount = countThreeSixNine(i);
            if (clapCount > 0) {
                for (int j = 0; j < clapCount; j++) {
                    System.out.print("짝");
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
            
        }
		
	}
	
	public static int countThreeSixNine(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

}
