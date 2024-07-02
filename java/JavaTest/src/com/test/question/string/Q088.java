package com.test.question.string;

import java.util.Scanner;

public class Q088 {
//	문자열: 금지어
	public static void main(String[] args) {
//		요구사항] 금지어를 마스킹 처리 하시오.
//			- 금지어
//				- 바보
//				- 멍청이
		
//		입력1
//		입력: 너랑 안놀아 바보야!! 

//		출력1
//		너랑 안놀아 **야!!
//		금지어를 1회 마스킹했습니다.
		
//		입력2
//		입력: 그것도 모르다니 멍청이;; 

//		출력2
//		그것도 모르다니 ***;;
//		금지어를 1회 마스킹했습니다.
		
//		입력3
//		입력: 잘 생각해봐 바보 멍청이 

//		출력3
//		잘 생각해봐 ** ***
//		금지어를 2회 마스킹했습니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력: ");
		String input = scan.nextLine();

		String[] words = { "바보", "멍청이" };
		
		int count = 0;
		
		for(int i=0; i<words.length; i++) {
			int len = words[i].length();
			for(int j=0; j<input.length(); j++) {
				int idx = input.indexOf(words[i]);
				if(idx > -1) {
					input = input.substring(0, idx) + "*".repeat(len) + input.substring(idx + len);
					j = idx + len;
					count++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(input);
		System.out.println("금지어를 " + count + "회 마스킹했습니다.");
	}
}
