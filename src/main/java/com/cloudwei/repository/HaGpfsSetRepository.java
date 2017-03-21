package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.THaGpfsSet;


public interface HaGpfsSetRepository extends PagingAndSortingRepository<THaGpfsSet, Long>{
	@Query("select t from THaGpfsSet t where t.tHaGpfsSetType in (3,5)")
	List<THaGpfsSet> findAll();
	
	Page<THaGpfsSet> findByTHaGpfsSetTypeBetween(String first,String end,Pageable pageable);
	
	List<THaGpfsSet> findByTHaGpfsSetType(String type);
}
