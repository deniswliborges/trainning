package com.deniswillian.trainning;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deniswillian.trainning.entity.Product;
import com.deniswillian.trainning.repository.ProductRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = Product.builder().name("Impressora").costs(450.00).build();
		Product p2 = Product.builder().name("Mouse").costs(35.00).build();
		Product p3 = Product.builder().name("Teclado").costs(40.00).build();
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		
	}
	
}
