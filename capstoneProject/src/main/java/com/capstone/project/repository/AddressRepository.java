package com.capstone.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.project.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findByState(String state);

}
