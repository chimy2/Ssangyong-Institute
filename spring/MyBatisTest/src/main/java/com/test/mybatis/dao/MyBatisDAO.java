package com.test.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mybatis.dto.AddressDTO;

@Repository
public class MyBatisDAO {

//	Connection > Statement
//	SqlSessionTemplate
	
//	DAO > (의존) > SqlSessionTemplate
	@Autowired
	private SqlSessionTemplate template;

	public void m1() {
		/*
		 * JDBC Statement
		 * 1. executeUpdate()
		 * 	- template.insert()
		 * 	- template.update()
		 * 	- template.delete()
		 * 		> 100% 똑같은 메서드인데 가독성을 위해 메서드를 나눠 놓음
		 * 
		 * 2. executeQuery()
		 * 	- template.selectOne()	> 결과셋의 레코드가 1줄
		 * 	- template.selectList()	> 결과셋의 레코드가 N줄
		 * 
		 */
		template.insert("mybatis.m1");
	}

	public int m2(String seq) {
		return template.delete("mybatis.m2", seq);
	}

	public int m3(AddressDTO dto) {
		return template.update("mybatis.m3", dto);
	}

	public int m4() {
//		select
//		1. selectOne()	> 결과셋 레코드 1개, 컬럼 N개 > if(rs.next());
//		2. selectList()	> 결과셋 레코드 N개, 컬럼 N개 > while(rs.next());
		
		/*
		 * sql = "select.."
		 * stat = conn.createStatement();
		 * rs = stat.executeQuery();
		 * if(rs.next()) {
		 * 		return rs.getInt("cnt");
		 * }
		*/
//		<T> the returned object type
		return template.selectOne("mybatis.m4");
	}

	public AddressDTO m5(Integer seq) {

		/*
		 * sql = "select.. where seq = ?"
		 * stat = conn.prepareStatement();
		 * pstat.setInt(1, seq);
		 * rs = stat.executeQuery();
		 * if(rs.next()) {
		 * 		레코드 1줄 > DTO 1개
		 * 		AddressDTO dto = new AddressDTO();
		 * 		dto.setSeq(rs.getString("seq");
		 * 		dto.setName(rs.getString("name");
		 * 		return rs.getInt("cnt");
		 * }
		*/
		
//		SQL Mapping Framework > SQL의 실행 결과를 객체지향으로 매핑해준다.
//		*** SqlSessionTemplate > 레코드 1줄 > (매핑) > DTO 1개
		return template.selectOne("mybatis.m5", seq);
	}

//	public ArrayList<String> m6() {
	public List<String> m6() {
		/*
		 * sql = "select.."
		 * stat = conn.createStatement();
		 * rs = stat.executeQuery();
		 * ArrayList<String> list = new..;
		 * while(rs.next()) {
		 * 		list.add(rs.getString("name"));
		 * }
		 * return list;
		 */
		
//		selectList 반환 타입이 ArrayList<Object> 라서 형변환이 필요한데
//		상위 class로 반환하게 하여 자동 형변환 되도록 함
		
		return template.selectList("mybatis.m6");
	}

	public List<AddressDTO> m7() {
		/*
		 * sql = "select.."
		 * stat = conn.createStatement();
		 * rs = stat.executeQuery();
		 * ArrayList<AddressDTO> list = new..;
		 * while(rs.next()) {
		 * 		AddressDTO dto = new AddressDTO();
		 * 		dto.setSeq(rs.getString("seq"));
		 * 		dto.setName(rs.getString("name"));
		 * 		list.add(dto);
		 * }
		 * return list;
		 */
		return template.selectList("mybatis.m7");
	}

	public int m8(String table) {
		
		return template.selectOne("mybatis.m8", table);
	}

	public List<AddressDTO> m9(int age) {
		
		return template.selectList("mybatis.m9", age);
	}

	public List<AddressDTO> m10(String word) {
		
		return template.selectList("mybatis.m10", word);
	}

	public List<AddressDTO> m11(String gender) {
		return template.selectList("mybatis.m11", gender);
	}

	public List<AddressDTO> m12(String gender) {
		return template.selectList("mybatis.m12", gender);
	}

	public List<AddressDTO> m13(HashMap<String, String> map) {
		return template.selectList("mybatis.m13", map);
	}

	public int m14(AddressDTO dto) {
		return template.insert("mybatis.m14", dto);
	}

	public List<AddressDTO> m15(List<String> search) {
		return template.selectList("mybatis.m15", search);
	}
}
