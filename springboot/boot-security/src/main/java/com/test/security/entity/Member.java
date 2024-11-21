package com.test.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
//@Table(name = "tblMember")	> 대소문자 가림
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(generator = "member_seq_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "member_seq_generator", sequenceName = "seqMember", allocationSize = 1)
	private Long seq;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
}
