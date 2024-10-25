package com.test.security;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",		// 데이터 소스를 가져오기 위해서
			"file:src/main/webapp/WEB-INF/spring/security-context.xml"	// passwordEncoder를 가져오기 위해
		})
public class MemberTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Test
	public void testNotNull() {
//		아까 테스트용으로 만든 PasswordEncoder가 겹쳐서 에러가 남
//			> 27번 코드를 주석처리
		assertNotNull(dataSource);
		
		assertNotNull(passwordEncoder);
	}
	
//	@Test
	public void testEncypt() {
		String pw = "1111";
//		$2a$10$t6U.J91FQmqKLaGZWTTDeukqsvVUUKBcjVgnqHeknfhqorcbCPi7.
		
		System.out.println(passwordEncoder.encode(pw));
		String pw2 = "1111";
//		$2a$10$CCjYpqkN65hjOnTHEYfZKunCURf9LmET6.kAuJMkUM0egoYlTBO4q
		
		System.out.println(passwordEncoder.encode(pw2));
	}
	
	@Test
	public void insertMember() {
		String sql ="insert into member (memberid, memberpw, membername, enabled, email, age, gender) values (?, ?, ?, default, ?, ?, ?)";
		
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "dog");
			pstat.setString(2, passwordEncoder.encode("1111"));
			pstat.setString(3, "강아지");
			pstat.setString(4, "dog@gmail.com");
			pstat.setString(5, "3");
			pstat.setString(6, "m");
			
			pstat.executeUpdate();
			
			pstat.setString(1, "cat");
			pstat.setString(2, passwordEncoder.encode("1111"));
			pstat.setString(3, "고양이");
			pstat.setString(4, "cat@gmail.com");
			pstat.setString(5, "2");
			pstat.setString(6, "f");
			
			pstat.executeUpdate();
			
			pstat.setString(1, "tiger");
			pstat.setString(2, passwordEncoder.encode("1111"));
			pstat.setString(3, "호랑이");
			pstat.setString(4, "tiger@gmail.com");
			pstat.setString(5, "10");
			pstat.setString(6, "f");
			
			pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertAuth() {
		String sql = "insert into member_auth (memberid, auth) values (?, ?)";
		
		try {
			
			Connection conn = dataSource.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "dog");
			pstat.setString(2, "ROLE_MEMBER");
			pstat.executeUpdate();
			
			pstat.setString(1, "cat");
			pstat.setString(2, "ROLE_MEMBER");
			pstat.executeUpdate();
			
			pstat.setString(1, "tiger");
			pstat.setString(2, "ROLE_MEMBER");
			pstat.executeUpdate();
			
			pstat.setString(1, "tiger");
			pstat.setString(2, "ROLE_ADMIN");
			pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
