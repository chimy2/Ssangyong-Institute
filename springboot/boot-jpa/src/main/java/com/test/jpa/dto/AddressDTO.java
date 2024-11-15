package com.test.jpa.dto;

import com.test.jpa.entity.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
//	본인(DTO) > (변환) > 엔티티
	public static Address toEntity(AddressDTO dto) {
		return Address.builder()
				.seq(dto.seq)
				.name(dto.name)
				.age(dto.age)
				.address(dto.address)
				.gender(dto.gender)
				.build();
	}
	
	public Address toEntity() {
		return Address.builder()
				.seq(this.seq)
				.name(this.name)
				.age(this.age)
				.address(this.address)
				.gender(this.gender)
				.build();
	}
}
