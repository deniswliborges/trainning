package com.deniswillian.trainning.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Supplier {

	@Id
	@GeneratedValue
	private Integer code;
	
	private String name;
	
	private long cnpj;
	
	private String endereço;
	
	private String telefone;
	
	private String email;
	
}
