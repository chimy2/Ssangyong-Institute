package com.test.question.string;

import java.util.Arrays;
import java.util.Scanner;

public class Q091 {
//	문자열: 연산식
	public static void main(String[] args) {
//		요구사항] 연산식을 입력받아 실제 연산을 하시오.
//			- 산술 연산자만 구현하시오.(+, -, *, /, %)
//			- 연산식의 공백은 자유롭게 입력 가능합니다.
//			- 산술 연산자가 반드시 존재하는지 체크하시오.
//			- 피연산자의 갯수가 2개인지 체크하시오.
		
//		입력1
//		입력: 10 + 2 

//		출력1
//		10 + 2 = 12
		
//		입력2
//		입력: 2 * 7 

//		출력2
//		2 * 7 = 14
		
//		입력3
//		입력: 2*7 

//		출력3
//		2 * 7 = 14
		
//		입력4
//		입력: 10 # 5 

//		출력4
//		연산자가 올바르지 않습니다.
		
//		입력5
//		입력: 10 + 

//		출력5
//		피연산자가 부족합니다.
		
//		입력6
//		입력: + 20 

//		출력6
//		피연산자가 부족합니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력: ");
		String expression = scan.nextLine().replace(" ", "");
		
		String[] operators = { "+", "*", "-", "/", "%" };
		String result = "";
		
		for(int i=0; i<operators.length; i++) {
			String oper = operators[i];
			if(expression.contains(oper)) {
//				split method는 인자로 regex => regular expression을 받는데
//				+, * 은 정규표현식에 사용되는 패턴문자라 \\로 이스케이프 처리해줘야 함
				String splitStr = (i <= 1 ? "\\" : "") + oper;
				String[] operands = expression.split(splitStr);
				
				if(operands.length < 2 
						|| operands.length == 2 && operands[0].equals("")) {
					result = "피연산자가 부족합니다";
					break;
				}
				
				result += operands[0] + " " + oper +  " " + operands[1] + " = ";
				result += calculate(operands, oper);
				break;
			}
		}
		
		if(!result.equals("")) {
			System.out.println(result);
		} else {
			System.out.println("연산자가 올바르지 않습니다.");
		}
	}

	private static String calculate(String[] operands, String oper) {
		String result = "";
		int operand1 = Integer.parseInt(operands[0]);
		int operand2 = Integer.parseInt(operands[1]);

		switch(oper) {
			case "+":
				result += operand1 + operand2;
				break;
			case "*":
				result += operand1 * operand2;
				break;
			case "-":
				result += operand1 - operand2;
				break;
			case "/":
				result += operand1 / operand2;
				break;
			case "%":
				result += operand1 % operand2;
				break;
		}
		
		return result;
	}
	
	
}
