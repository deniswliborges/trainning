package com.deniswillian.trainning.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deniswillian.trainning.dto.ProductDTO;
import com.deniswillian.trainning.entity.Product;
import com.deniswillian.trainning.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	public ProductService procuctService;
	
	@PostMapping
	public ResponseEntity<URI> insert(@Valid @RequestBody ProductDTO dto) {
		Product product = procuctService.fromDTO(dto);
		product = procuctService.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").build(product.getCode());
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping("/{code}")
	public ResponseEntity<Product>find(@PathVariable Integer code){		
	Product product = procuctService.findCode(code);
	return ResponseEntity.ok(product);
	}
	
	@GetMapping
	public ResponseEntity <List<Product>>findAll(){
		List<Product> productList = procuctService.findAll();
		return ResponseEntity.ok().body(productList);
				}
	
	
	@PutMapping("/{code}")
	public ResponseEntity <Product> update(@Valid @RequestBody ProductDTO productDTO, @PathVariable Integer code) {
		Product produtc = procuctService.fromDTO(productDTO);
		produtc.setCode(code);
		produtc = procuctService.update(produtc);		
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(value="/{code}",method=RequestMethod.DELETE)
	public ResponseEntity<Product> delet(@PathVariable Integer code){
		procuctService.delet(code);
		return ResponseEntity.noContent().build();
	}
	
}
