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
		Product p1 = new Product(1,"Impressora",123.00);
		Product p2 = new Product(2,"Mouse",123.00);
		Product p3 = new Product(3,"Tablet",123.00);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		
	}
	
}
