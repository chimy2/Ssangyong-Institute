package com.test.jpa.repository;

// 자동 임포트가 안돼서 적어줘야 함
import static com.test.jpa.entity.QAddress.address1;
import static com.test.jpa.entity.QInfo.info;
import static com.test.jpa.entity.QMemo.memo1;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.dto.AddressDTO;
import com.test.jpa.entity.Address;
import com.test.jpa.entity.Info;
import com.test.jpa.entity.QAddress;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomAddressRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public List<Address> findAll() {
		/*
		 * Query DSL 특징
		 * - 모든 SQL 작업을 자바 메서드로 구현한다.
		 * - selectFrom(엔티티)
		 * 		- select * from 엔티티
		 * 		- 해당 엔티티에서 모든 컬럼을 가져온다.
		 * 		- 결과셋 > 다시 원하는 추출(fetch)
		 * 
		 * - fetch() : 리스트 조회. 결과셋을 다 반환. 결과가 없으면 빈 ArrayList 반환
		 * - fetchOne() : 단일 조회. 결과가 없으면 null 반환. 결과가 2개 이상이면 예외 발생
		 * - fetchFirst() : 단일 조회. 결과가 N개라도 첫번째 레코드 반환
		 * - fetchResultSet() : 페이징 정보가 포함된 결과셋 반환
		 * - fetchCount(): 카운트 반환
		 */
//		return jpaQueryFactory.selectFrom(테이블);
//		return jpaQueryFactory.selectFrom(QClass의 table 객체를 넣어줌);	
		return jpaQueryFactory.selectFrom(address1).fetch();
		// 자동 임포트가 안돼서 임포트문을 적어줌
	}

	public Address findAddressByName(String name) {
		
//		Query did not return a unique result: 51 results were returned
//		return jpaQueryFactory.selectFrom(address1).fetchOne();
		return jpaQueryFactory
				.selectFrom(address1)
				.where(address1.name.eq(name))	//where name = '강아지'
				.fetchOne();
	}

	public List<String> findAllName() {
		
//		- selectFrom(): select * from
//		- select(): select 컬럼 지정
//			- select(컬럼).from(엔티티)
//			- select(QType.column1, QType.column2..)
		
//		select name from tblAddress
		return jpaQueryFactory.select(address1.name).from(address1).fetch();
	}

	public List<Tuple> findAllNameAndAgeAndGender() {
		return jpaQueryFactory.select(address1.name, address1.age, address1.gender).from(address1).fetch();
	}

	public List<AddressDTO> findAllNameAndAddress() {
		return jpaQueryFactory.select(Projections.constructor(AddressDTO.class, address1.name, address1.address)).from(address1).fetch();
	}

	public List<Address> findAllByGender(String gender) {
		/*
		 * where() 절
		 * - 동등 비교
		 * 	- address1.gender.eq("m"): equal
		 * 	- address1.gender.ne("m"): not equal
		 * - null 비교
		 * 	- address1.address.isNull()
		 * 	- address1.address.isNotNull()
		 * - 열거형 비교
		 * 	- address1.age.in(3, 5, 7)
		 * 	- address1.age.notIn(3, 5, 7)
		 * - 범위 비교
		 * 	- address1.age.gt(3)
		 * 	- address1.age.lt(3)
		 * 	- address1.age.goe(3): great or equal
		 * 	- address1.age.loe(3): less or equal
		 * 	- address1.age.between(3, 5)
		 * - 패턴 비교
		 * 	- address1.address.startsWith("서울특별시 강남구")
		 * 	- address1.address.endsWith("층")
		 * 	- address1.address.contains("빌딩")
		 * 	- address1.address.like("%아파트%")
		 * - and/or
		 * 	- 남자 and 5세 이상
		 * 	- where gender = 'f' and (address like '%강남구%' or address like '%강동구%')
		 * 
		 * JPA > JPQL 언어 사용
		 * 1. Query Method > 메서드명> JPQL > SQL
		 * 2. JPQL > SQL
		 * 3. Query DSL > 메서드 사용 > JPQL > SQL
		 */
		
//		return jpaQueryFactory.selectFrom(address1).where(address1.gender.eq(gender)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.gender.ne(gender)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.isNull()).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.isNotNull()).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.in(3, 5, 7)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.notIn(3, 5, 7)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.gt(3)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.lt(3)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.goe(3)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.age.loe(3)).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.startsWith("서울특별시 강남구")).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.endsWith("층")).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.contains("빌딩")).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.address.like("%아파트%")).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.gender.eq("m").and(address1.age.goe(5))).fetch();
//		return jpaQueryFactory.selectFrom(address1).where(address1.gender.eq("m").and(address1.age.goe(5)).and(address1.address.contains("강남구"))).fetch();
		return jpaQueryFactory.selectFrom(address1).where(address1.gender.eq("f").and(address1.address.contains("강남구").or(address1.address.contains("강동구")))).fetch();
	}

	public List<Address> findAllOrderBy() {
		/*
		 * 정렬
		 * - orderBy(QType.Colum.정렬기준())
		 * 
		 * 정렬기준
		 * - asc()
		 * - desc()
		 * - nullsLast()
		 * - nullsFirst()
		 */
		return jpaQueryFactory.selectFrom(address1)
//				.orderBy(address1.age.desc())
//				.orderBy(address1.age.desc(), address1.name.asc())
//				.orderBy(address1.address.asc())	//오라클은 기본적으로 null을 마지막에 배치해줌
//				.orderBy(address1.address.asc().nullsFirst())
				.orderBy(address1.address.desc().nullsLast())
				.fetch();
	}

	public List<Address> findAllPagenation(int offset, int limit) {
		
//		페이징
		
		return jpaQueryFactory.selectFrom(address1)
				.offset(offset)
				.limit(limit)
				.fetch();
	}

	public int count() {
		return (int)jpaQueryFactory.selectFrom(address1).fetchCount();
	}

	public Tuple findAllAggregation() {
		return jpaQueryFactory
				.select(address1.address.count(), 
						address1.age.avg(),
						address1.age.sum(),
						address1.age.max(),
						address1.age.min())
				.from(address1).fetchOne();
	}

	public List<Tuple> findAllGroupByGender() {
		return jpaQueryFactory
				.select(address1.gender, address1.count(), address1.age.avg())
				.from(address1)
				.groupBy(address1.gender)
				.having(address1.age.avg().gt(4.5))
				.fetch();
	}

	public List<Info> findAllJoinInfo() {
		
//		tblAddress + tblInfo
		/*
		 * 조인
		 * - join(): inner join
		 * - innerJoin(): inner join (= join())
		 * - leftJoin(): left outer join
		 * - rightJoin(): right outer join
		 */
//		return jpaQueryFactory.selectFrom(엔티티)
//		return jpaQueryFactory.selectFrom(info)
//		return jpaQueryFactory.selectFrom(info).fetch();
		
		return jpaQueryFactory
				.selectFrom(info)				//자식 테이블
//				.join(info.address, address1)	//join(연관관계, 부모테이블)
				.rightJoin(info.address, address1)	//join(연관관계, 부모테이블)
				.fetch();
	}

	public List<Address> findAllJoinAddress() {
		return jpaQueryFactory.selectFrom(address1)
//				.join(address1.memo, memo1)	//inner join
				.leftJoin(address1.memo, memo1)	//left join
				.fetch();
	}

	public List<Address> findAllByMaxAge() {

		QAddress subAddress = QAddress.address1;
		
//		select * from tblAddress where age = (select max(age) from tblAddress);
		return jpaQueryFactory.selectFrom(address1)
//				.where(address1.age.eq(서브쿼리))
//				.where(address1.age.eq(
//					JPAExpressions.select(subAddress.age.max()).from(subAddress))
//				)
				.where(address1.age.goe(
						JPAExpressions.select(subAddress.age.avg()).from(subAddress)
						))
				.fetch();
	}

	public List<Tuple> findAllByAvgAge() {
		QAddress subAddress = QAddress.address1;
		
//		select name, age, (select avg(age) from tblAddress) from tblAddress
		return jpaQueryFactory
				.select(address1.name, 
						address1.age, 
						JPAExpressions.select(subAddress.age.avg()).from(subAddress))
				.from(address1)
				.fetch();
	}

	public List<Address> findAllMultiParameter(String gender, Integer age) {
		
//		(동적) 다중 조건 생성기
		BooleanBuilder builder = new BooleanBuilder();
		
		if(gender != null) {
			builder.and(address1.gender.eq(gender));
		}
		if(age != null) {
			builder.and(address1.age.eq(age));
		}
		
		return jpaQueryFactory
				.selectFrom(address1)
//				.where(builder)
//				.where(address1.gender.eq(gender), address1.age.eq(age))
				.where(gender != null ? address1.gender.eq(gender) : null,
						age != null ? address1.age.eq(age) : null)
				.fetch();
	}
	
}
