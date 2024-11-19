package com.test.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.jpa.dto.AddressDTO;
import com.test.jpa.entity.Address;
import com.test.jpa.entity.AddressNameAgeMapping;

//DAO 역할 > 데이터베이스 조작(SQL X) > 객체(Address Entity) 조작
//- JPARepository<취급할 엔티티, 엔티티의 @Id 기본키 자료형>

public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<Address> findByName(String name);

	Optional<Address> findByAddress(String address);

	Optional<Address> findByGender(String gender);

	Address findFirstByAge(int age);

	Address findByNameAndGender(String name, String gender);

	List<Address> findByGenderAndAge(String gender, int age);

	List<Address> findByGenderOrAge(String gender, int age);

	List<Address> findByGenderOrAgeOrName(String gender, int age, String name);

	List<Address> findByAgeGreaterThan(int age);

	List<Address> findByAgeLessThan(int age);

	List<Address> findByAgeLessThanEqual(int age);

	List<Address> findByAgeBetween(int i, int j);

	List<Address> findByAddressIsNull();

	List<Address> findByAddressIsNotNull();

	List<Address> findByAgeIn(List<Integer> ages);

	List<Address> findByAddressStartingWith(String address);

	List<Address> findByAddressStartsWith(String address);

	List<Address> findByAddressEndingWith(String address);

	List<Address> findByAddressContains(String address);

	List<Address> findByAddressLike(String address);

	List<Address> findByAddressNotLike(String address);

	Optional<Address> findByNameIs(String name);

	Optional<Address> findByNameEquals(String name);

	List<Address> findAllByOrderByNameAsc();

	List<Address> findByGenderOrderByNameAsc(String gender);

	List<Address> findByGenderOrderByNameDesc(String gender);

	List<Address> findByGenderOrderByAgeAscNameDesc(String gender);

	List<Address> findByGenderAndAgeOrderByAgeAscNameDesc(String gender, int age);

	List<Address> findByGender(String gender, Sort by);

	List<Address> findByGender(Sort by, String string);

	List<AddressNameAgeMapping> findAllByGender(String string);

//	JPQL > @Query
//	1. Address(엔티티)를 대상으로 한다.
//	2. 반드시 엔티티의 별칭을 만든다.
//	3. 컬럼은 테이블 소속을 표시한다.
//	@Query("SQL 작성")
	@Query("select a.name from Address as a")	// JPQL 구문
//	@Query(value="select name from tblAddress", nativeQuery = true)	// 원래 오라클 구문
	List<String> listName();

	@Query("select a from Address as a")
	List<Address> listAll();

//	순서로 바인딩
	@Query("select a from Address as a where a.gender = ?1")
	List<Address> listAll(String gender);

//	이름으로 바인딩
	@Query("select a from Address as a where a.age >= :age")
	List<Address> listAll(@Param(value="age") int age);

	@Query("select a from Address as a where a.gender = :#{#dto.gender} and a.address like '%' || :#{#dto.address} || '%'")
	List<Address> listAll(@Param(value="dto") AddressDTO dto);

	@Query("select new com.test.jpa.dto.AddressDTO(a.seq, a.name, a.age, a.address, a.gender, year(current_date) - a.age) from Address as a")
	List<AddressDTO> listCustomAll();

	
}
