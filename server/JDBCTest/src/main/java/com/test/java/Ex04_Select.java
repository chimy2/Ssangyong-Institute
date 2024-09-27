package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_Select {
	public static void main(String[] args) {
//		Ex04_Select.java

//		m1();
//		m2();
//		m3();
//		m4();
		m5();
	}

//	Connection conn = null;
//	Statement stat = null;
//	ResultSet rs = null;
//
//	try {
//		conn = DBUtil.open();
//		stat = conn.createStatement();
//
//		String sql = "";
//	} catch (Exception e) {
//		System.out.println("Ex04_Select.m1");
//		e.printStackTrace();
//	}

	private static void m5() {
//		tblInsa + tblBonus
//		요구사항] 특정 직원에게 보너스를 지급하시오.
//		1. 모든 직원 명단 출력(번호, 이름, 부서, 직위) > select 
//		2. 사용자 > 직원 선택(번호 입력)
//		3. 사용자 > 보너스 금액 입력
//		4. 보너스 지급
//		5. 지급된 내역을 출력

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);

		try {
			conn = DBUtil.open("localhost", "hr", "java1234");
			stat = conn.createStatement();

//			1. 모든 직원 명단 출력(번호, 이름, 부서, 직위) > select 
			String sql = "select num, name, buseo, jikwi from tblInsa order by num asc";

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				System.out
					.printf(
							"%s. %s(%s, %s)\n",
							rs.getString("num"),
							rs.getString("name"),
							rs.getString("buseo"),
							rs.getString("jikwi"));
			}
			
			rs.close();

//			2. 사용자 > 직원 선택(번호 입력)
//			3. 사용자 > 보너스 금액 입력
			System.out.print("직원 번호: ");
			String num = scan.nextLine();
			
			System.out.print("보너스: ");
			String bonus = scan.nextLine();
			
//			4. 보너스 지급
			sql = String.format("insert into tblBonus (seq, num, bonus) values (seqBonus.nextVal, %s, %s)", num, bonus);
			
			stat.executeUpdate(sql);
			
//			5. 지급된 내역을 출력
			sql = "select i.num as num, i.name as name, b.bonus as bonus from tblInsa i "
					+ "inner join tblBonus b on i.num = b.num where b.seq = (select max(seq) from tblBonus)";
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				System.out.printf("%s, %s, %s\n", 
						rs.getString("num"),
						rs.getString("name"),
						rs.getString("bonus")
						);
			}
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex04_Select.m1");
			e.printStackTrace();
		}
	}

	private static void m4() {
//		부서 입력 > 해당 부서의 직원 명단 출력(직원명, 직위, 지역, 급여)

		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open("localhost", "hr", "java1234");
			stat = conn.createStatement();

			String sql = "select distinct buseo from tblInsa order by buseo asc";

			rs = stat.executeQuery(sql);

			System.out.println("[부서명을 입력하세요.]");

			while (rs.next()) {
				System.out.println("- " + rs.getString("buseo"));
			}

			System.out.println("부서명: ");
			String buseo = scan.nextLine();

			rs.close();
//			stat.close();
//			conn.close();
//			두번째 SQL X

			sql = String.format("select name, jikwi, city, basicpay from tblInsa where buseo = '%s'", buseo);

			rs = stat.executeQuery(sql);

			System.out.println("[이름]\t[직위]\t[지역]\t[급여]");

			while (rs.next()) {
				System.out
					.println(
							String
								.format(
										"%s\t%s\t%s\t%,d원",
										rs.getString("name"),
										rs.getString("jikwi"),
										rs.getString("city"),
										rs.getInt("basicpay")));
			}

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("Ex04_Select.m1");
			e.printStackTrace();
		}

	}

	private static void m3() {
//		다중값 반환
//		N행 1열
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = "select name from tblAddress";

			rs = stat.executeQuery(sql);

//			ResultSet.next가 호출되지 않았음
//			System.out.println(rs.getString("name"));

//			rs.next();
//			System.out.println(rs.getString("name"));
//			
//			rs.next();
//			System.out.println(rs.getString("name"));

//			결과 집합을 모두 소모했음
//			rs.next();
//			System.out.println(rs.getString("name"));

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}

			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex04_Select.m1");
			e.printStackTrace();
		}
	}

	private static void m2() {
//		다중값 반환
//		1행 N열

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = "select * from tblAddress where seq = 4";

			rs = stat.executeQuery(sql);

//			rs.next();	// 100% 값이 있을거란 보장이 없음

			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");

				System.out.println(name);
				System.out.println(age);
				System.out.println(gender);
			} else {
				System.out.println("데이터가 없습니다.");
			}

			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex04_Select.m2");
			e.printStackTrace();
		}
	}

	private static void m1() {
//		단일값 반환
//		- 1행 1열
//		개강 후 수업 진행 방식은 대면 수업
//		오리엔테이션은 2024년 6월 18일 화요일 오후 04:0에 진행
//		제소하 품고후 
//		출석 체크는 센터 지문 인식기
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();
			stat = conn.createStatement();

//			String sql = "select count(*) from tblAddress";
			String sql = "select count(*) as cnt from tblAddress";

			rs = stat.executeQuery(sql);

//			ResultSet rs == 커서(cursor) > 파일 읽기, Iterator, stream, 향상된 for, 커서

			rs.next(); // 커서를 다음 레코드 이동

//			현재 커서가 가리키고 있는 레코드의 원하는 컬럼을 가져오기
//			- rs.get자료형(컬럼);
//			String count = rs.getString(1);	// 컬럼 순서
//			String count = rs.getString("count(*)");	// 컬럼명 > 가독성을 높이기 위해 주로 사용
			int count = rs.getInt("cnt");

			System.out.println(count);

			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex04_Select.m1");
			e.printStackTrace();
		}
	}
}