package com.test.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Getter
@ToString
@Table(name = "tblMemo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_seq_generator")
	@SequenceGenerator(name="memo_seq_generator", sequenceName = "seqMemo", allocationSize = 1)
	private Long seq;
	private String memo;
	private LocalDate regdate;
	private Long aseq;
	
//	@OneToOne
//	@JoinColumn(name = "seq")
//	private Address address;
}
