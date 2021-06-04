package com.deniswillian.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deniswillian.trainning.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
