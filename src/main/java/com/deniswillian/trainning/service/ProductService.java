package com.deniswillian.trainning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.trainning.dto.ProductDTO;
import com.deniswillian.trainning.entity.Product;
import com.deniswillian.trainning.exception.ObjectNotFoundException;
import com.deniswillian.trainning.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;

	public Product findCode(Integer code) {
		Optional<Product> obj = productrepository.findById(code);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado, Id:" + code + ", Tipo:" + Product.class.getName()));
	}

	public Product insert(Product product) {
		return productrepository.save(product);
	}

	public Product update(Product product) {
		Product newObj = findCode(product.getCode());
		updateData(newObj, product);
		return productrepository.save(newObj);
	}

	public void updateData(Product newObj, Product product) {
		newObj.setName(product.getName());
	}

	public void delet(Integer code) {
		findCode(code);
	}

	public List<Product> findAll() {
		return productrepository.findAll();
	}

	public Product fromDTO(ProductDTO objDto) {
		return Product.builder()
				.code(objDto.getCode())
				.name(objDto.getName())
				.costs(objDto.getCosts())
				.build();
	}
}
