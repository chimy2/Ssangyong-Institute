package com.test.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.util.DBUtil;

public class AuthDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AuthDAO() {
		this.conn = DBUtil.open();
	}

	public UserDTO login(UserDTO dto) {
		try {
//			원래 로그인 처리할 때 어떤 부분이 틀렸는지 알려줬지만 
//			요즘에는 보안때문에 정확히 로그인에 실패한 이유를 알려주지 않는다
			String sql = "select * from tblUser where id = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
//				로그인 성공 > 해당 유저 정보 반환
				UserDTO result = new UserDTO();
				
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setLv(rs.getInt("lv"));
				
				return result;
			}
		} catch (Exception e) {
			System.out.println("AuthDAO.login");
			e.printStackTrace();
		}
		return null;
	}
}
