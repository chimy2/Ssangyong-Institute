package com.test.question.string;

public class Q084 {
//	문자열: 단어 횟수
	public static void main(String[] args) {
//		요구사항] 특정 단어가 문장내에 몇회 있어있는지 수를 세시오.
//			- 대상 문자열: String content = "안녕~ 길동아~ 잘가~ 길동아~";
//			- 검색 문자열: String word = "길동";
		
//		출력
//		'길동'을 총 2회 발견했습니다.
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		
		int count = 0;
		
		for(int i=0; i<content.length();) {
			int idx = content.substring(i).indexOf(word);
			if(idx > -1) {
				count++;
				i += idx + word.length();
			} else {
				break;
			}
		}
		System.out.printf("'%s'을 총 %d회 발견했습니다.", word, count);
	}
}
