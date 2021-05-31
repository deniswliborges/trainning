package com.deniswillian.trainning.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.deniswillian.trainning.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

	public ProductDTO(Product obj) {
		// TODO Auto-generated constructor stub
	}
	@NotNull
	private int code;
	@NotNull
	private String name;
	@NotNull
	private Double costs;
}
