package com.test.question;

public class Test {
	
	public static void main(String[] args) {
		
		m1();
		
		System.out.println("end");
		
	}

	private static void m1() {
		
		try {
			int n = 0;
			System.out.println(100 / n);
		} catch (Exception e) {
			//System.out.println("예외");
			e.printStackTrace();
		}
		
		
	}

}
