package com.test.mybatis.dao;

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
}
