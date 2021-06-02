package com.deniswillian.trainning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;
	@Column
	private String name;
	@Column
	private long cnpj;
	@Column
	private String endereço;
	@Column
	private String telefone;
	@Column
	private String email;
	
}
