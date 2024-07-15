package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class BoardExample3 {
//	Field
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
//	Constructor
	public BoardExample3() {
		try {
//			JDBC Driver 등록
			Class.forName("orcle.jdbc.OracleDriver");
			
//			연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl",
					"java",
					"oracle"
					);
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
//	Method
	public void list() {
//		타이틀 및 컬럼명 출력
	}
}
