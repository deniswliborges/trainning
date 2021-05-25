package com.deniswillian.trainning.controller;

import java.net.URI;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deniswillian.trainning.dto.ProductDTO;
import com.deniswillian.trainning.entity.Product;
import com.deniswillian.trainning.service.ProductService;

@RestController
@RequestMapping("/produtos")
public class ProductController {

	public ProductService procuctService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProductDTO dto) {
		Product obj = procuctService.fromDTO(dto);
		obj = procuctService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").build(obj.getCode());
		return ResponseEntity.created(uri).build(); 
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?>find(@PathVariable Integer code){		
		Product obj = procuctService.findCode(code);
		return ResponseEntity.ok(obj);
	}
}
