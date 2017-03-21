package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cloudwei.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}