package com.test.question.string;

import java.util.Scanner;

public class Q085 {
//	문자열: 주민등록번호
	public static void main(String[] args) {
//		요구사항] 주민 등록 번호 유효성 검사를 하시오.
//			- '-'의 입력 유무 상관없이 검사하시오.
		
//		입력1
//		주민등록번호: 951220-1021547 

//		출력1
//		올바른 주민등록번호입니다.
		
//		입력2
//		주민등록번호: 951220-1234567 

//		출력2
//		올바르지 않은 주민등록번호입니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("주민등록번호: ");
		String jumin = scan.nextLine().trim().replace("-", "");
		
		if(isCorrectDate(jumin) && isCorrectValid(jumin)) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
		
	}

	private static boolean isCorrectValid(String jumin) {
		int result = 0;
		int lastNum = Character.getNumericValue(jumin.charAt(jumin.length() - 1));
		
		for(int i=0, multi = 2; i<jumin.length() - 1; i++, multi++) {
			int num = Character.getNumericValue(jumin.charAt(i));
			if(multi > 9) {
				multi = 2;
			}
			result += num * multi;
		}

		result %= 11;
		
		result = 11 - result;

		result %= 10;
		
		return result == lastNum ? true : false;
	}

	private static boolean isCorrectDate(String jumin) {
		int year = Integer.parseInt(jumin.substring(0, 2));
		int month = Integer.parseInt(jumin.substring(2, 4));
		int day = Integer.parseInt(jumin.substring(4, 6));
		
		int gender = Character.getNumericValue(jumin.charAt(6));

		switch(gender) {
			case 0: case 9:
				year += 1800;
				break;
			case 1: case 2: case 5: case 6:
				year += 1900;
				break;
			default:
				year += 2000;
		}
		
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if(day > 31) return false;
				break;
			case 4: case 6: case 9: case 11:
				if(day > 30) return false;
				break;
			case 2:
				boolean checkLeaf = isLeafYear(year);
				if(checkLeaf && day > 29 || !checkLeaf && day > 28) {
					return false;
				}
				break;
			default:
				return false;
		}
		if(day > 0) {
			return true;
		}
		return false;
	}

	private static boolean isLeafYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		return false;
	}
}
