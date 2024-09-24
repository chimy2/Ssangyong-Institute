package com.test.java;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ex03_Statement {
	public static void main(String[] args) {
//		Ex03_Statement.java
		/*
		 * Connection
		 * - 연결/종료
		 * 
		 * Statement
		 * - 모든 SQL 실행하는 역할
		 * 
		 * 1. Statement
		 * 	- 기본
		 * 
		 * 2. PreparedStatement
		 * 	- Statement 개량 > 매개 변수 처리 특화
		 * 
		 * 3. CallableStatement
		 * 	- Statement 개량 > 프로시저 호출 전용
		 */
		
//		단축키: Ctrl + 1
		
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
	}

	private static void m5() {
//		UI + SQL + 데이터 사용자 입력
		Scanner scan = new Scanner(System.in);
				
		System.out.print("이름: ");
		String name = scan.nextLine();
		
//		*** 자바와 오라클은 아무 관계가 없다.
//		- 자바는 오라클의 자료형이 뭔지 모른다.
		System.out.print("나이: ");
//		int age = Integer.parseInt(scan.nextLine());
		String age = scan.nextLine();
		
		System.out.print("성별(m,f): ");
		String gender = scan.nextLine();
		
		System.out.print("전화번호: ");
		String tel = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) " 
				+ "values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			System.out.println(stat.executeUpdate(sql));
			
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m5");
			e.printStackTrace();
		}
	}

	private static void m4() {
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.open();
			
			if(!conn.isClosed()) {
//				String sql = "create table tblJava (seq number primary key, data varchar2(100) not null)";
				String sql = "drop table tblJava";
				
				stat = conn.createStatement();
				
				int result = stat.executeUpdate(sql);
				
//				DDL은 return 값이 0으로 나옴
				if(result > 0) {
					System.out.println("생성 성공");
				} else {
					System.out.println("생성 실패");
				}
				
				stat.close();
				conn.close();
			} else {
				System.out.println("DB 접속 실패");
			}
			
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m4");
			e.printStackTrace();
		}
	}

	private static void m3() {

		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.open();
			
			if(!conn.isClosed()) {
				String sql = "delete from tblAddress where seq = 2";
				
				stat = conn.createStatement();
				
				int result = stat.executeUpdate(sql);
				
				if(result > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				
				stat.close();
				conn.close();
			} else {
				System.out.println("DB 접속 실패");
			}
			
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m3");
			e.printStackTrace();
		}
	}

	private static void m2() {
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.open();
			
			if(!conn.isClosed()) {
				String sql = "update tblAddress set age = age + 1";
				
				stat = conn.createStatement();
				
				int result = stat.executeUpdate(sql);
				
				if(result > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				
				stat.close();
				conn.close();
			} else {
				System.out.println("DB 접속 실패");
			}
			
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m2");
			e.printStackTrace();
		}
	}

	private static void m1() {
		Connection conn = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		
		try {
//			1. 
			conn = DBUtil.open();
			
//			반드시 연결이 됐는지 확인
			if(!conn.isClosed()) {
//				2.
//				- 자바는 SQL을 모른다. > SQL을 문자열로 취급한다.
//				- ORA-00911: invalid character 
//					> sql 안에 ;, 즉 문장 종결자를 넣을 수 없다 
//						- 문장 종결자를 넣는 이유 ? > 구분하기 위해서
//						- 문장 종결자를 넣지 않는다? > 여러 명령을 실행할 수 없다.
//				String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) "
//						+ "values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동', default);";
				String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) "
						+ "values (seqAddress.nextVal, '호랑이', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동', default)";
				
				stat = conn.createStatement();
				
//				반환값 없는 쿼리 > 오라클에게 전달되어 실행
//				- SQL Developer > Ctrl + Enter
//				- ***** SQL 실행하는 순간 자동으로 commit이 발생한다.(JDBC) == Auto Commit
//				- 반환값을 돌려주는 것이 아니라 몇개의 레코드에 적용되었는지 돌려준다
				int result = stat.executeUpdate(sql);
				
				if(result == 1) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}
				
//				conn.rollback();
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
				
//				자원 해제
//				AutoCommit을 false 해놔도 접속을 종료하면 자동으로 커밋됨
				stat.close();
				conn.close();
				
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m1");
			e.printStackTrace();
		}
		
	}
}
