package com.deniswillian.trainning;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deniswillian.trainning.entity.Product;
import com.deniswillian.trainning.entity.Supplier;
import com.deniswillian.trainning.repository.ProductRepository;
import com.deniswillian.trainning.repository.SupplierRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = Product.builder().name("Impressora").costs(450.00).build();
		Product p2 = Product.builder().name("Mouse").costs(35.00).build();
		Product p3 = Product.builder().name("Teclado").costs(40.00).build();
		
		Supplier sup1 = Supplier.builder().name("Informatica Leste")
				.cnpj("22.234.678-99/0001-88")
				.address("Rua Ivete Morim")
				.telephone("(11)5678-8898")
				.email("infoleste@info.com.br")
				.build();
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		supplierRepository.saveAll(Arrays.asList(sup1));
		
	}
	
}
