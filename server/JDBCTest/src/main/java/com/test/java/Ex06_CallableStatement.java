package com.test.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Ex06_CallableStatement {
	public static void main(String[] args) {
//		Ex06_CallableStatement
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
//		m6();
	}

	private static void m6() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();

			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}

	private static void m5() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open("localhost", "hr", "java1234");

			String sql = "{ call procM5(?, ?) }";

			stat = conn.prepareCall(sql);

			stat.setString(1, "개발부");

			stat.registerOutParameter(2, OracleTypes.CURSOR);

			stat.executeQuery();

//			out > 오라클 커서 == 결과셋 == JDBC ResultSet
			rs = (ResultSet) stat.getObject(2);	// 반환된 커서는 ResultSet으로 받아서옴

			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}

	private static void m4() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open("localhost", "hr", "java1234");

			String sql = "{ call procM4(?, ?, ?, ?) }";

			stat = conn.prepareCall(sql);

//			in
			stat.setString(1, "1002");

//			out
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);

			stat.executeQuery();

			String name = stat.getString(2);
			String buseo = stat.getString(3);
			String jikwi = stat.getString(4);

			System.out.println(name);
			System.out.println(buseo);
			System.out.println(jikwi);

			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("데이터 존재하지 않음");
//			System.out.println("Ex06_CallableStatement.m1");
//			e.printStackTrace();
		}
	}

	private static void m3() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();

			String sql = "{ call procM3(?) }";

			stat = conn.prepareCall(sql);

//			in parameter
//			stat.setString(1, 값);

//			out parameter
			stat.registerOutParameter(1, OracleTypes.NUMBER);

			stat.executeQuery();

//			rs.getInt(1); > resultset에 반환 받아서 가져오는게 아니라 등록해놨던 값을 받아옴
			System.out.println(stat.getInt(1));

			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}

	private static void m2() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();

			String sql = "{ call procM2(?, ?, ?, ?, ?) }";

			stat = conn.prepareCall(sql);
			stat.setString(1, "병아리");
			stat.setInt(2, 1);
			stat.setString(3, "m");
			stat.setString(4, "010");
			stat.setString(5, "서울시");

			int result = stat.executeUpdate();

			System.out.println(result);

			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}

	private static void m1() {
		Connection conn = null;
		CallableStatement stat = null;
//		프로시저 전용
		ResultSet rs = null;

		try {
			conn = DBUtil.open();

			String sql = "{ call procM1 }";

//			매개변수를 넣을 수 있으므로 PreparedStatement처럼 sql을 먼저 넣어준다
			stat = conn.prepareCall(sql);

			int result = stat.executeUpdate();
			System.out.println(result);

			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}

	private static void m0() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.open();

			conn.close();
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
	}
}
