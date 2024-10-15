package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.toy.user.model.UserDTO;
import com.test.util.DBUtil;

public class UserDAO {

//	정적 변수(자기 자신의 인스턴스를 담을 변수)
	private static UserDAO dao;

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

//	public UserDAO() {
//		this.conn = DBUtil.open("localhost", "toy", "java1234");
//	}

	private UserDAO() {
//		외부에서 객체를 못만들게 하고 싶을 때 사용
		this.conn = DBUtil.open("localhost", "toy", "java1234");
	}

//	싱글톤 패턴 때 관례적으로 객체를 만들 때 사용하는 함수
	public static UserDAO getInstance() {
		if (dao == null) {
			dao = new UserDAO();
		}

		return dao;
	}

	public int register(UserDTO dto) {
		try {
			String sql = "insert into tblUser values (?, ?, ?, ?, 1, ?, ?, default, default)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPic());
			pstat.setString(6, dto.getIntro());

			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("UserDAO.register");
			e.printStackTrace();
		}
		return 0;
	}

	public int unregister(String id) {
		try {

			String sql = "update tblUser set pw = '0000', name = '탈퇴', email = '탈퇴', "
					+ "pic = default, intro = null, ing = 0 where id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

//	로그인
	public UserDTO login(UserDTO dto) {
//		queryParamDTOReturn

		try {

			String sql = "select * from tblUser where id = ? and pw = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());

			rs = pstat.executeQuery();

			if (rs.next()) {

				UserDTO result = new UserDTO();

				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setLv(rs.getString("lv"));
				result.setPic(rs.getString("pic"));
				result.setIntro(rs.getString("intro"));
				result.setRegdate(rs.getString("regdate"));
				result.setIng(rs.getString("ing"));

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<UserDTO> listUser() {
//		query
		try {

			String sql = "select * from tblUser where ing = 1";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			ArrayList<UserDTO> list = new ArrayList<UserDTO>();

			while (rs.next()) {

				UserDTO dto = new UserDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setLv(rs.getString("lv"));
				dto.setPic(rs.getString("pic"));
				dto.setIntro(rs.getString("intro"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setIng(rs.getString("ing"));

				list.add(dto);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	아이디 > 회원 정보 가져오기
	public UserDTO getUser(String id) {
//		queryParamDTOReturn
		try {
			String sql = "select * from tblUser where id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			if (rs.next()) {

				UserDTO dto = new UserDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setLv(rs.getString("lv"));
				dto.setPic(rs.getString("pic"));
				dto.setIntro(rs.getString("intro"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setIng(rs.getString("ing"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<HashMap<String, String>> loadCalendar(HashMap<String, String> map) {
		try {
			
			String sql = "select "
					+ "to_char(l.regdate, 'yyyy-mm-dd') as regdate, "
					+ "count(*) as cnt, "
					+ "(select count(*) from tblBoard where to_char(regdate, 'yyyy-mm-dd') = to_char(l.regdate, 'yyyy-mm-dd') and id = ?) as bcnt, "
					+ "(select count(*) from tblComment where to_char(regdate, 'yyyy-mm-dd') = to_char(l.regdate, 'yyyy-mm-dd') and id = ?) as ccnt "
					+ "from tblLog l where to_char(l.regdate, 'yyyy-mm') = ? and l.id = ? "
					+ "group by to_char(l.regdate, 'yyyy-mm-dd')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("id"));
			pstat.setString(2, map.get("id"));
			pstat.setString(3, String.format("%s-%02d", map.get("year"), Integer.parseInt(map.get("month"))));			
			pstat.setString(4, map.get("id"));
			
			rs = pstat.executeQuery();
			
			ArrayList<HashMap<String, String>> list =new ArrayList<HashMap<String, String>>();
			
			while (rs.next()) {
				HashMap<String, String> result = new HashMap<String, String>();
				
				result.put("regdate", rs.getString("regdate"));
				result.put("cnt", rs.getString("cnt"));
				result.put("bcnt", rs.getString("bcnt"));
				result.put("ccnt", rs.getString("ccnt"));
				
				list.add(result);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void addLog(String id) {
		try {

			String sql = "insert into tblLog values (seqLog.nextVal, ?, default)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}