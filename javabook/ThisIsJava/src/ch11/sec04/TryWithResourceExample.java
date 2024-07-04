package ch11.sec04;

public class TryWithResourceExample {
	public static void main(String[] args) {
//		자원 관리를 위해 try-with-resources 블록을 사용하는데
//		그를 위해서 미리 AutoCloseable 인터페이스를 구현해야한다
//			> close() 함수를 미리 정의하기 위해서
		try(MyResource res = new MyResource("A")) {
			String data = res.read1();
			int value = Integer.parseInt(data);
		} catch (Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
		
		System.out.println();
		
		try (MyResource res = new MyResource("A")) {
			String data = res.read2();
//			NumberFormatException 발생
			int value = Integer.parseInt(data);
		} catch (Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
		
		System.out.println();
		
		MyResource res1 = new MyResource("A");
		MyResource res2 = new MyResource("B");
		try ( res1; res2) {
			String data1 = res1.read1();
			String data2 = res2.read1();
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
		/*
		[MyResource(A) 열기]
		[MyResource(A) 읽기]
		[MyResource(A) 닫기]

		[MyResource(A) 열기]
		[MyResource(A) 읽기]
		[MyResource(A) 닫기]
		예외 처리: For input string: "abc"

		[MyResource(A) 열기]
		[MyResource(B) 열기]
		[MyResource(A) 읽기]
		[MyResource(B) 읽기]
		[MyResource(B) 닫기]
		[MyResource(A) 닫기]
		*/
	}
}
