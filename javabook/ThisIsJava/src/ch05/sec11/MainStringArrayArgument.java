package ch05.sec11;

import java.util.Arrays;

public class MainStringArrayArgument {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("프로그램 입력값이 부족");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
//		eclipse에서 입력값 주기
//		- Run As > Run Configuraions > Arguments > Program arguments 창에 입력
//		명령 프롬프트나 터미널에서 입력값 주기
//		- bin 폴더까지 이동 후 java 명령어 실행
//		ex. bin > java ch05.sec11.MainArrayArgument 10 20
	}
}
