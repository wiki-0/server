package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findAll();
	
	User findByUserName(String userName);

}
