package com.test.memo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.memo.model.MemoDTO;
import com.test.util.DBUtil;

//DB 관련 코드 담당 > JDBC 코드 담당
public class MemoDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MemoDAO() {
		this.conn = DBUtil.open();
	}

//	AddOk 서블릿이 입력 데이터를 줄테니 DB에 insert 해달라고 요청
	public int add(MemoDTO dto) {
		try {
			String sql = "insert into tblMemo (seq, name, pw, memo, regdate) "
					+ "values (seqMemo.nextVal, ?, ?, ?, default)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getMemo());

//			적용된 행의 개수
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("MemoDAO.add");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<MemoDTO> list() {

		try {
			String sql = "select * from tblMemo order by seq desc";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);	// 메모 목록
			
//			ResultSet(rs) > (변환) > ArrayList<MemoDTO>
			ArrayList<MemoDTO> result = new ArrayList<>();

			while (rs.next()) {
//				레코드 1줄 > MemoDTO 1개씩 생성
				MemoDTO dto = new MemoDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));

				result.add(dto);
			}

			return result;
		} catch (Exception e) {
			System.out.println("MemoDAO.list");
			e.printStackTrace();
		}

		return null;
	}

	public MemoDTO get(String seq) {
		try {
			String sql = "select * from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				MemoDTO dto = new MemoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setMemo(rs.getString("memo"));
				dto.setName(rs.getString("name"));
				
				return dto;
			}
		
		} catch (Exception e) {
			System.out.println("MemoDAO.get");
			e.printStackTrace();
		}
		return null;
	}

	public int edit(MemoDTO dto) {
		try {
			String sql = "update tblMemo set memo = ? where seq = ?";
			System.out.println("1");
			
			pstat = conn.prepareStatement(sql);
			System.out.println("2");
			
			pstat.setString(1, dto.getMemo());
			pstat.setString(2, dto.getSeq());
			System.out.println("3");
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("MemoDAO.edit");
			e.printStackTrace();
		}
		
		return 0;
	}

//	EditOk 서블릿이 메모를 수정하기 전에 권한이 있는지 확인?
	public int check(MemoDTO dto) {
		try {
			String sql = "select count(*) as cnt from tblMemo where seq = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("MemoDAO.check");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delete(MemoDTO dto) {
		try {
			String sql = "delete from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("MemoDAO.delete");
			e.printStackTrace();
		}
		return 0;
	}
}