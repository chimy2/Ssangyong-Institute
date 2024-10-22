package com.test.mybatis.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

// junit 말고 pom.xml에 적었던 spring에서 쓰는 확장된 테스트

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPTest {
	
	@Autowired
//	private BasicDataSource dataSource;	> 인데 상위 객체가 있으므로 그거 씀
	private DataSource dataSource;
	
//	junit은 생성자 의존 주입이 안돼서 필드 주입으로 의존주입을 함
	
	@Test
	public void testConnection() {
		assertNotNull(dataSource);
		
		try {
//			Connection conn = DBUtil.open();
			Connection conn = dataSource.getConnection();	// 연결된 connection 객체를 돌려줌
			
			assertEquals(false, conn.isClosed());
			
			conn.close();
//			DBCP로 관리되는 Connection은 close()를 호출해도 실제 close()가 되지 않고 커넥션풀로 반납되어 돌아간다.
//			하지만 명시적으로 close하지 않아도 DBCP를 이용하기 때문에 
//			커넥션에 대한 자원 관리를 개발자가 하지 않고 메서드가 끝나면 참조가 끝나면서 사용하던 객체를 돌려준다
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Autowired
	private HikariDataSource hikariDataSource;
	
	@Test
	public void testHikariConnection() {
		assertNotNull(hikariDataSource);
		
		try {
			Connection conn = hikariDataSource.getConnection();
			
			assertEquals(false, conn.isClosed());
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
