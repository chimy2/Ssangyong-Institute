package ch03.sec06;

public class CompareOperatorExample {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 10;
		boolean result1 = num1 == num2;
		boolean result2 = num1 != num2;
		boolean result3 = num1 <= num2;
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		
		char char1 = 'A';
		char char2 = 'B';
		boolean result4 = char1 < char2;
		System.out.println("result4: " + result4);
		
		int num3 = 1;
		double num4 = 1.0;
		boolean result5 = num3 == num4;
		System.out.println("result5: " + result5);
		
		float num5 = 0.1f;
		double num6 = 0.1;
		boolean result6 = num5 == num6;
		boolean result7 = num5 == (float)num6;
		System.out.println("result6: " + result6);
		System.out.println("result7: " + result7);
//		🌟🌟🌟 float값과 double값을 비교할 때는 정밀도의 차이 때문에
//			비교 연산이 제대로 되지 않는다. 따라서 float값을 double로 형변환 후 연산
		
		String str1 = "자바";
		String str2 = "Java";
		boolean result8 = str1.equals(str2);
		boolean result9 = !str1.equals(str2);
		System.out.println("result8: " + result8);
		System.out.println("result9: " + result9);
		/*
		result1: true
		result2: false
		result3: true
		result4: true
		result5: true
		result6: false
		result7: true
		result8: false
		result9: true
		*/
	}
}
