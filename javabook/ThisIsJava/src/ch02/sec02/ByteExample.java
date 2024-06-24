package ch02.sec02;

public class ByteExample {
	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
//		byte var6 = 128;
//		컴파일 에러(Type mismatch: cannot convert from int to byte)
//		byte 자료형은 1byte의 크기로 8bit의 메모리값을 갖는데
//		-128 ~ 127 초과 범위의 값을 선언했기 때문에 컴파일 오류가 생김
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		/*
		-128
		-30
		0
		30
		127
		 */
	}
}
