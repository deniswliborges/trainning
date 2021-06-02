package com.deniswillian.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deniswillian.trainning.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
