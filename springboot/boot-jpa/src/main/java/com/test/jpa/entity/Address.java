package com.test.jpa.entity;

import com.test.jpa.dto.AddressDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity
//- 데이터베이스의 테이블의 참조 객체
//- DB의 tblAddress 테이블과 연결된 객체
//- 엔티티에는 Setter를 구현 안함 > 생성자로 구현
//- 엔티티에는 필요에 따라 Getter는 구현 가능함.

@Entity
@Getter
@ToString
@Table(name = "tblAddress")
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor	> final이 붙은 멤버변수만 생성자의 매개변수로 만듦
public class Address {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "별칭")
//	@SequenceGenerator(name="별칭", sequenceName = "seqAddress", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_generator")
	@SequenceGenerator(name="address_seq_generator", sequenceName = "seqAddress", allocationSize = 1)
	private Long seq;

	private String name;
	private Integer age;
//	값 타입으로 사용해도 되지만 참조형으로 맞추는 경우가 많기 때문에 int 대신 Integer로 사용
//	나중에 발생할 수 있는 문제를 대비해서 값형이 아닌 참조형 값 타입은 null을 넣을 수 없음
//	값 타입을 자주 사용하면 코드가 딱딱해짐, 참조 타입을 쓰면 부드러워짐
	private String address;
	private String gender;
	
//	Entity(본인) > (변환) > DTO
	
	public static AddressDTO toDTO(Address address) {
//		AddressDTO dto = new AddressDTO();
//		
//		dto.setSeq(address.getSeq());
//		dto.setName(address.getName());
//		dto.setAge(address.getAge());
//		dto.setAddress(address.getAddress());
//		dto.setGender(address.getGender());
		
		return AddressDTO.builder()
				.seq(address.seq)
				.name(address.name)
				.age(address.age)
				.address(address.address)
				.gender(address.gender)
				.build();
	}
	
	public AddressDTO toDTO() {
//		AddressDTO dto = new AddressDTO();
//		
//		dto.setSeq(this.getSeq());
//		dto.setName(this.getName());
//		dto.setAge(this.getAge());
//		dto.setAddress(this.getAddress());
//		dto.setGender(this.getGender());
		
		return AddressDTO.builder()
			.seq(this.getSeq())
			.name(this.getName())
			.age(this.getAge())
			.address(this.getAddress())
			.gender(this.getGender())
			.build();
	}
	
//	*** JAP의 Entity는 MVC에서 흔히 사용하는 DTO는 역할이 다르다.
//	- DTO > 계층간의 데이터 전달
//		- setName() 호출 > 전달할 데이터 추가 or 변경
//	- Entity > DB 조작 O, 계층간의 데이터 전달 X
//		- setName() 호출 > DB 데이터 추가 or 수정, 단순하게 데이터 전달 X

//	주소 수정 Setter
	public void updateAddress(String address) {
		this.address = address;
	}
	
}
