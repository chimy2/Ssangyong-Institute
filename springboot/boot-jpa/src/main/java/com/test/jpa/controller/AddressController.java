package com.test.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.Tuple;
import com.test.jpa.dto.AddressDTO;
import com.test.jpa.entity.Address;
import com.test.jpa.entity.AddressNameAgeMapping;
import com.test.jpa.entity.Info;
import com.test.jpa.entity.Memo;
import com.test.jpa.repository.AddressRepository;
import com.test.jpa.repository.CustomAddressRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddressController {

	private final AddressRepository addressRepository;
	private final CustomAddressRepository customAddressRepository;
	
	/*
	@GetMapping("/m0.do")
	public String m0(Model model) {
		
		
		return "result";
	}
	*/
	
	
	@GetMapping("/m01.do")
	public String m01(Model model) {
		/*
		 * 
		 * JPA 사용법
		 * 1. Query Method	> 간단한 작업
		 * 	- 정해진 키워드 + 메서드명 > 호출 > SQL 실행
		 * 
		 * 2. JPQL
		 * 	- 직접 SQL 작성 > 실행
		 * 
		 * 3. Query DSL		> 복잡한 작업
		 * 	- SQL 관련 각각의 조작을 자바 메소드를 통해서 실행
		 * 
		 */
		
//		[C]RUD
//		- 레코드 추가하기 > insert
//		1. 추가할 레코드 정보 확보
//		2. 엔티티 객체 생성
//		3. 리포지토리 객체 + 엔티티 객체 전달 > insert 요청
		
		Address address = new Address(null, "꿀꿀이", 5, "서울특별시 강남구 역삼동 한돈빌딩", "m", null, null); 
		
		Address result = addressRepository.save(address);

//		Controller > (전달) > View
//		이때 entity를 그대로 view에 전달하면 안되고 dto를 넣어 전달해줘야함
//		- Address 엔티티 > (변환) > AddressDTO
		model.addAttribute("address", result.toDTO());
		
		return "result_dto";
	}
	
	@GetMapping("/m02.do")
	public String m02(Model model) {
		/*
		 * JPA 사용법
		 * 1. Query Method
		 * 	- 정해진 키워드 + 메서드명 > 호출 > SQL 실행
		 * 	- 메서드 이름으로 쿼리를 생성하는 방식 > 정해진 키워드 + 조합 
		 * 		> JPA가 해당 메서드 이름을 분석해서 JPQL(SQL)을 생성하고 실행한다.
		 * 	- 장점
		 * 		- 별도의 쿼리를 작성하지 않고 쿼리를 자동으로 생성
		 * 		- 단순한 CRUD엣 효율적
		 * 		- 메서드 이름 > 가독성 향상
		 * 	- 단점
		 * 		- 복잡한 업무 쿼리에는 부적합
		 * 		- 복잡한 업무의 메서드명 매우 길어짐
		 * 
		 * 2. JPQL, Java Persistence Query Language
		 * 	- 직접 SQL 작성 > 실행
		 * 	- JPA에서 사용하는 전용 SQL
		 * 	- SQL은 테이블을 대상 실행 > JPQL은 엔티티를 대상 실행
		 * 	- 장점
		 * 		- SQL과 구문이 유사
		 * 		- 객체지향 관점의 SQL
		 * 		- @Query 사용
		 * 	- 단점
		 * 		- 문자열로 작성 > 컴파일 때 오류 확인 불가 > 런타임 때 오류 확인 가능 
		 * 			> JDBC, MyBatis의 단점이기도 함
		 * 		- 동적 쿼리 작성이 불편
		 * 
		 * 3. QueryDSL
		 * 	- SQL 관련 각각의 조작을 자바 메소드를 통해서 실행
		 * 	- SQL을 자바 코드로 만드는 프레임워크
		 * 	- 장점
		 * 		- 컴파일 때 오류 확인 가능
		 * 		- IDE > 자동 완성 기능 활용 가능
		 * 		- 동적 쿼리 작성 수월
		 * 		- 복잡한 쿼리도 수월
		 * 	- 단점
		 * 		- 초기 설정 복잡
		 * 		- 학습 곡선 높음
		 * 
		 * 정리
		 * 1. 단순한 CRUD > Query Method > 40%
		 * 2. 정적이면서 복잡한 쿼리 > JPQL > 25%
		 * 3. 동적이거나 복잡한 쿼리 > QueryDSL > 35%
		 * 
		 */
		
//		C[R]UD
//		- 1개의 레코드를 가져오기 + 기본키 조건
		
//		옛날 코드
//		addressRepository.getById(2L);
//		addressRepository.getOne(2L);
		
//		현재 코드
		Optional<Address> address = addressRepository.findById(2L);

//		if (address != null) {
//		if (address.isPresent()) {
//			model.addAttribute("address", address.get().toDTO());
//		}
		
		address.ifPresent(value -> model.addAttribute("address", value.toDTO()));
		
		return "result_dto";
	}

	@GetMapping("/m03.do")
	public String m03(Model model) {
//		CR[U]D
//		- 레코드 수정하기
//		1. 엔티티 새로 만든 뒤 > 이 값으로 기존 레코드를 수정
//		2. 기존 엔티티 검색 > 기존 엔티티 수정 > 레코드를 수정
		
//		1.
//		Address address = Address.builder()
//				.seq(53L)
//				.name("꿀꿀이")	// ***
//				.age(5)
//				.address("서울특별시 강남구 역삼동 한돈빌딩 8층")
//				.gender("m")
//				.build();

//		2.
		Address address = addressRepository.findById(53L).get();
		address.updateAddress("서울시 강동구 천호동");
		
		Address result = addressRepository.save(address);
		
		model.addAttribute("address", result.toDTO());

		return "result_dto";
	}
	
	

	@GetMapping("/m04.do")
	public String m04(Model model) {
//		CRU[D]
//		- 레코드 삭제하기
		
//		Address address = Address.builder()
//				.seq(52L)
//				.build();
		
		Address address = addressRepository.findById(53L).get();
		
		addressRepository.delete(address);
		
		return "result_dto";
	}
	
//	C > save(Entity)
//	R > findById(PK)
//	U > save(Entity)
//	D > delete(Entity)

	@GetMapping("/m05.do")
	public String m05(Model model) {
//		Query Method
//		- 키워드 조합 > 메서드 이름 만들기		
//		- 메서드명 = Subject Part + Predicate Part
//					= 가져올 컬럼 + 조건
		
//		Select문
//		- findBy, getBy, readBy, queryBy, searchBy, streamBy 등..
//		- findBy(***)
		
//		메서드명 = findBy + Subject Part [+ Predicate Part]
		
//		'다람쥐' 검색
//		- select * from tblAddress where name = '다람쥐'
//		Optional<Address> address = addressRepository.findByName("다람쥐");
		Optional<Address> address = addressRepository.findByAddress("서울특별시 서초구 서초대로 77길 45 아크로비스타 101동 3호");
		
//		Query did not return a unique result: 28 results were returned
//		Optional<Address> address = addressRepository.findByGender("m");
//		findBy는 유니크한 단 한 개의 레코드를 가져와야 함 		
		
		model.addAttribute("address", address.get().toDTO());

		return "result_dto";
	}
	
	@GetMapping("/m06.do")
	public String m06(Model model) {
		
//		카운트
		long count = addressRepository.count();
		
//		레코드 존재 유무: count(*) > 0
		boolean result = addressRepository.existsById(1L);
		
		model.addAttribute("count", count);
		
		model.addAttribute("result", result);

		return "result_item";
	}
	
	@GetMapping("/m07.do")
	public String m07(Model model) {

//		전체 select
		
		List<Address> list = addressRepository.findAll();
		
//		List<Entity> > (변환) > List<DTO>
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m08.do")
	public String m08(Model model) {
		
//		First, Top
//		- 가져올 레코드의 개수를 지정한다.
//		- 키워드 뒤에 숫자를 지정한다. 생략(1)
//		- 1이면 단수 반환, N이면 복수 반환
		Address address = addressRepository.findFirstByAge(3);
//		현재 오라클 버전은 지원안하기 때문에 에러남
		
		model.addAttribute("address", address.toDTO());
		
		return "result_dto";
	}

	@GetMapping("/m09.do")
	public String m09(Model model) {
		
//		And, Or
		
//		- where name = '강아지' and gender = 'm'
		Address address = addressRepository.findByNameAndGender("강아지", "m");
		
		model.addAttribute("address", address);
		
		return "result_dto";
	}
	
	@GetMapping("/m10.do")
	public String m10(Model model) {
		
//		- where gender = 'm' and age = 3
//		- where gender = 'm' or age = 3
//		- where gender = 'm' or age = 3 or name = '강아지'
//		List<Address> list = addressRepository.findByGenderAndAge("m", 3);
//		List<Address> list = addressRepository.findByGenderOrAge("m", 3);
		List<Address> list = addressRepository.findByGenderOrAgeOrName("m", 3, "강아지");
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m11.do")
	public String m11(Model model) {
		
//		After, Before, GreaterThan(GreaterThanEqual), LessThan(LessThanEqual), Between
//		- After, GreaterThan(GreaterThanEqual) > 크다
//		- Before, LessThan(LessThanEqual) > 작다
//		- Between > 범위
//		- After/Before > 날짜시간 비교
//		- GreaterThan/LessThan > 크기 비교
		
//		List<Address> list = addressRepository.findByAgeGreaterThan(5);
//		List<Address> list = addressRepository.findByAgeLessThan(5);
//		List<Address> list = addressRepository.findByAgeLessThanEqual(5);
		
		List<Address> list = addressRepository.findByAgeBetween(3, 5);
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m12.do")
	public String m12(Model model) {
		
//		isEmpty, isNull
//		isNotEmpty, isNotNull
//		- isNull > null 체크
//		- isEmpty > 빈문자열, 컬렉션 size(0) 등을 체크
//		DB에 따라서 isNull과 isEmpty를 구분없이 쓰는 경우도 있음
		
//		List<Address> list = addressRepository.findByAddressIsNull();
		List<Address> list = addressRepository.findByAddressIsNotNull();
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m13.do")
	public String m13(Model model) {
		
//		In, NotIn
//		- 열거형 조건
		
		List<Integer> ages = List.of(3, 5, 7);
		
		List<Address> list = addressRepository.findByAgeIn(ages);
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m14.do")
	public String m14(Model model) {
		
//		StartingWith(StartsWith), EndingWith(EndsWith), Contains, Like
		
//		List<Address> list = addressRepository.findByAddressStartingWith("서울특별시 강남구");
//		List<Address> list = addressRepository.findByAddressStartsWith("서울특별시 강남구");
//		List<Address> list = addressRepository.findByAddressEndingWith("층");
//		List<Address> list = addressRepository.findByAddressContains("역삼");
//		List<Address> list = addressRepository.findByAddressLike("%타워%");
		List<Address> list = addressRepository.findByAddressNotLike("%타워%");
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m15.do")
	public String m15(Model model) {
		
//		Is, Equals
//		Optional<Address> address = addressRepository.findByName("강아지");
//		Optional<Address> address = addressRepository.findByNameIs("강아지");
		Optional<Address> address = addressRepository.findByNameEquals("강아지");
		
		address.ifPresent(value -> model.addAttribute("address", value.toDTO()));
		
		return "result_dto";
	}
	
	@GetMapping("/m16.do")
	public String m16(Model model) {
		
//		정렬 
//		- OrderBy컬럼명Asc
//		- OrderBy컬럼명Desc
		
//		다중 정렬
//		- OrderBy컬럼명Asc컬럼명Desc컬럼명Asc
		
//		List<Address> list = addressRepository.findAll();
//		List<Address> list = addressRepository.findAllByOrderByNameAsc();
//		List<Address> list = addressRepository.findByGenderOrderByNameAsc("m");
//		List<Address> list = addressRepository.findByGenderOrderByNameDesc("m");
//		List<Address> list = addressRepository.findByGenderOrderByNameDesc("m");
		
//		List<Address> list = addressRepository.findByGenderOrderByAgeAscNameDesc("m");
//		List<Address> list = addressRepository.findByGenderAndAgeOrderByAgeAscNameDesc("m", 3);
		
//		List<Address> list = addressRepository.findAll(Sort.by("name"));
//		List<Address> list = addressRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//		List<Address> list = addressRepository.findAll(Sort.by("age", "name"));	//desc를 표현하지 못함
		
//		List<Address> list = addressRepository.findAll(Sort.by(
//				Sort.Order.desc("age"),
//				Sort.Order.asc("name")
//			));
		
//		List<Address> list = addressRepository.findByGender("m", Sort.by("age"));
		List<Address> list = addressRepository.findByGender(Sort.by("age"), "m");
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
//	가변 인자 리스트
	public void test(String... args) {
		
		for (int i=0; i<args.length; i++) {
			System.out.println(i + ":" + args[i]);
		}
	}
	
	@GetMapping("/m17.do")
	public String m17(Model model) {
		
//		여태껏 Select
//		- select * from tblAddress
		
//		일부 컬럼만 가져오기 Select
//		- select name, age from tblAddress
//		- 인터페이스 사용
//		- com.test.jpa.entity > "AddressNameAgeMapping.java"(I)
		
		List<AddressNameAgeMapping> list = addressRepository.findAllByGender("f");
		
		model.addAttribute("list2", list);
		
		return "result_list";
	}
	
	@GetMapping("/m18.do")
	public String m18(Model model) {
//		페이징
		PageRequest pageRequest = PageRequest.of(5, 10);
		
		Page<Address> list = addressRepository.findAll(pageRequest);
//		오라클 버전이 낮아 제대로 실행이 안되므로 21c로 재설치

//		Page 1 of 5 containing com.test.jpa.entity.Address instances
//		System.out.println(list);
		
//		페이지 정보
		System.out.println(list.getNumber());			//0 > 페이지 번호
		System.out.println(list.getNumberOfElements());	//10 > 가져온 엔티티 수
		System.out.println(list.getTotalElements());	//50 > 총 엔티티 수
		System.out.println(list.getTotalPages());		//5 > 총 페이지수
		System.out.println(list.getSize());				//10 > 한 페이지당 엔티티 수 
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m19.do")
	public String m19(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		page--;
		PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("name"));
		
		Page<Address> list = addressRepository.findAll(pageRequest);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=list.getTotalPages(); i++) {
			sb.append("""
					<a href="/m19.do?page=%d"">%d</a>
					""".formatted(i, i));
		}
		
		model.addAttribute("list", list);
		model.addAttribute("sb", sb.toString());
		
		return "result_list";
	}
	
	@GetMapping("/m20.do")
	public String m20(Model model, Pageable pageable) {
//		m20.do?page=0
		
//		m20.do?page=0&size=10
//		m20.do?page=1&size=10
//		m20.do?page=2&size=10
		
//		m20.do?page=0&size=10&sort=name,asc
//		m20.do?page=1&size=10&sort=name,desc
//		m20.do?page=2&size=10&sort=name,asc
		
		Page<Address> list = addressRepository.findAll(pageable);
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m21.do")
	public String m21(Model model, Pageable pageable) {
//		[이전 페이지] 5 [다음 페이지]
		Slice<Address> list = addressRepository.findAll(pageable);
		
		System.out.println(list.getNumber());				//현재페이지
		System.out.println(list.getNumberOfElements());		//가져온 데이터 수
		System.out.println(list.getSize());					//한 페이지 당 수 
		System.out.println(list.hasContent());				//true > 현재 슬라이스의 데이터 유무
		System.out.println(list.hasNext());					//true > 다음 슬라이스의 데이터 존재 유무
		System.out.println(list.nextOrLastPageable());		//다음페이지이나 마지막 페이지일 경우 예외처리되어있음
		//Page request [number: 1, size 10, sort: UNSORTED]
		System.out.println(list.nextPageable());			//무조건 다음페이지
		System.out.println(list.previousOrFirstPageable());
		System.out.println(list.previousPageable());
		System.out.println(list.isFirst());
		System.out.println(list.isLast());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
				<a href="/m21.do?page=%d&size=10">이전 페이지</a>
				""".formatted(list.previousOrFirstPageable().getPageNumber()));
		
		sb.append("""
				<a href="/m21.do?page=%d&size=10">다음 페이지</a>
				""".formatted(list.nextOrLastPageable().getPageNumber()));
		
		model.addAttribute("list", list);
		model.addAttribute("sb", sb.toString());
		
		return "result_list";
	}
	
	@GetMapping("/m22.do")
	public String m22(Model model) {
		
//		JPQL
//		- Query Method로 작성하기 힘든 작업들을 직접 SQL 작성을 통해서 구현
		
//		List<String> names = addressRepository.listName();
//		model.addAttribute("names", names);
		
//		List<Address> list = addressRepository.listAll();	//findAll();
//		List<Address> list = addressRepository.listAll("f");	//findAll();
//		List<Address> list = addressRepository.listAll(5);	//findAll();
		
//		조건 데이터 2개
//		- 강남구 + f
//		AddressDTO dto = AddressDTO.builder()
//				.gender("f")
//				.address("강남구")
//				.build();
//		List<Address> list = addressRepository.listAll(dto);
		
		List<AddressDTO> list = addressRepository.listCustomAll();
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m23.do")
	public String m23(Model model) {
		/*
		 * Query DSL(Domain Specific Language)
		 * - JPQL 작성을 도와주는 동적 쿼리 빌더(오픈 소스 라이브러리)
		 * 
		 * JPQL을 직접 작성하지 않고 Query DSL을 사용하는 이유?
		 * - JPQL은 문자열로 질의를 작성
		 * 
		 * QClass 생성
		 * - 엔티티 클래스에 대응하는 정적 클래스 > QClass로부터 질의에 사용하는 여러 메서드를 제공받는다.
		 * 
		 * Query SDL 설정
		 * - 스프링 빈 선언
		 * - 자바 방식으로 빈 설정
		 * - "com.test.jpa.config" > "QueryDSLConfig.java"
		 * - QClass 생성하기
		 * 
		 * 파일
		 * - com.test.jpa.repository > "CustomAddressRepository.java"
		 * 
		 * 기존 클래스는 jparepository를 상속 받으나 
		 * query sdl은 기본 리포지토리라서 보통 따로 분리해서 만듦
		 */
		
//		전체 리스트 가져오기
		List<Address> list = customAddressRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m24.do")
	public String m24(Model model) {
		
//		단일 조회(레코드 1개)
		Address address = customAddressRepository.findAddressByName("강아지");
		
		model.addAttribute("address", address);
		
		return "result_dto";
	}
	
	@GetMapping("/m25.do")
	public String m25(Model model) {
		
//		특정 컬럼 가져오기
//		- 1개 컬럼
		List<String> names = customAddressRepository.findAllName();
		
		model.addAttribute("names", names);
		
		return "result_list";
	}
	
	@GetMapping("/m26.do")
	public String m26(Model model) {
		
//		특정 컬럼 가져오기
//		- N개 컬럼
//		List<Address> list = customAddressRepository.findAllNameAndAgeAndGender();
		List<Tuple> list = customAddressRepository.findAllNameAndAgeAndGender();
		
//		[[강아지, 3, m], [고양이, 2, f], [병아리, 1, f], [사자, 7, m], [호랑이, 6, f], ..]
//		System.out.println(list);
		
		for (Tuple tuple: list) {
			System.out.println(tuple.get(0, String.class));
			System.out.println(tuple.get(1, Integer.class));
			System.out.println(tuple.get(2, String.class));
		}
		
		model.addAttribute("tlist", list);
		
		return "result_list";
	}
	
	@GetMapping("/m27.do")
	public String m27(Model model) {
		
//		일부 컬럼 가져오기
//		1. Tuple
//		2. DTO
		
		List<AddressDTO> list = customAddressRepository.findAllNameAndAddress();
		
		model.addAttribute("dlist", list);
		
		return "result_list";
	}
	
	@GetMapping("/m28.do")
	public String m28(Model model) {
		
//		where() 절
		List<Address> list= customAddressRepository.findAllByGender("m");
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m29.do")
	public String m29(Model model) {
		
//		정렬
		List<Address> list = customAddressRepository.findAllOrderBy();
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m30.do")
	public String m30(Model model, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		
//		customAddressRepository.findAllPagenation(가져올 시작위치, 사이즈);
		
//		page=1 > 0
//		page=2 > 10
//		page=3 > 20
		int offset = (page - 1) * 10;
		
		List<Address> list = customAddressRepository.findAllPagenation(offset, 10);
		
		int count = customAddressRepository.count();
		
		StringBuilder sb = new StringBuilder();
		
//		for (int i=1; i<=총페이지수; i++) {
		for (int i=1; i<=(int)Math.ceil(count/10.0); i++) {
			sb.append(String.format("<a href='/m30.do?page=%d'>%d</a>", i, i));
		}
		
		model.addAttribute("list", list);
		model.addAttribute("sb", sb.toString());
		
		return "result_list";
	}
	
	@GetMapping("/m31.do")
	public String m31(Model model) {
		
//		집계함수
		Tuple tuple = customAddressRepository.findAllAggregation();
		
		model.addAttribute("tuple", tuple);
		
		return "result_item";
	}
	
	@GetMapping("/m32.do")
	public String m32(Model model) {
		
//		group by, having > 집계함수
		
		List<Tuple> list = customAddressRepository.findAllGroupByGender();
		
		model.addAttribute("glist", list);
		
		return "result_list";
	}
	
	@GetMapping("/m33.do")
	public String m33(Model model) {
		
//		Join
//		- tblAddress : tblInfo
//		- 1 : 1
//		- tblAddress : tblMemo
//		- 1 : N 
		
		List<Info> list = customAddressRepository.findAllJoinInfo();
		
		model.addAttribute("joinInfoList", list);
		
		return "result_list";
	}
	
	@GetMapping("/m34.do")
	public String m34(Model model) {
		
//		Join
//		- 1:N
//		List<엔티티> list = customAddressRepository.findAllJoinAddress();
		List<Address> list = customAddressRepository.findAllJoinAddress();
		
		model.addAttribute("joinAddressList", list);
		
		return "result_list";
	}
	
	@GetMapping("/m35.do")
	public String m35(Model model) {
		
//		서브쿼리 > Query DSL
//		- where절 > 비교값 > 구현 가능
//		- select절 > 컬럼값 > 구현 가능
//		- from절 > 테이블 > 구현 불가능
		
//		select * from tblAddress where age = (select max(age) from tblAddress);
		
		List<Address> list = customAddressRepository.findAllByMaxAge();
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m36.do")
	public String m36(Model model) {
		
//		서브쿼리 > Query DSL
//		- select절 > 컬럼값 > O
		
//		select name, age, 평균나이 from tblAddress
//		1. DTO + 평균나이 변수 추가
//		2. Tuple > 보편적으로 더 편함
		List<Tuple> talist = customAddressRepository.findAllByAvgAge();
		
		model.addAttribute("talist", talist);
		
		return "result_list";
	}
	
	@GetMapping("/m37.do")
	public String m37(Model model, @RequestParam(name = "gender", required = false) String gender, @RequestParam(name = "age", required = false) Integer age) {
		System.out.println(gender);
		System.out.println(age);
		
//		동적 쿼리
//		- m37.do > select * from tblAddress
//		- m37.do?gender=m > select * from tblAddress where gender = 'm'
//		- m37.do?age=3 > select * from tblAddress where age = 3
//		- m37.do?gender=m&age=3 > select * from tblAddress where gender = 'm' and age = 3
		
		List<Address> list = customAddressRepository.findAllMultiParameter(gender, age);
		
		model.addAttribute("list", list);
		
		return "result_list";
	}
	
	@GetMapping("/m38.do")
	public String m38(Model model) {
		
//		단방향 매핑 vs 양방향 매핑
		
//		단방향 매핑
//		- 부모 > 자식
//		- LIst<부모>
		
		List<Address> m38List = customAddressRepository.m38();
		
		model.addAttribute("m38list", m38List);
		
		return "result_list";
	}
	
	@GetMapping("/m39.do")
	public String m39(Model model) {
		
//		단방향 매핑
//		- 자식 > 부모
//		- List<부모>
		
		List<Memo> m39list = customAddressRepository.m39();
		
		model.addAttribute("m39list", m39list);
		
		return "result_list";
	}
	
	@GetMapping("/m0.do")
	public String m0(Model model) {
		
		
		return "result_list";
	}
}
