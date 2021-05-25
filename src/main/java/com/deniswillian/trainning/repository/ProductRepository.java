package com.deniswillian.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deniswillian.trainning.entity.Product;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
