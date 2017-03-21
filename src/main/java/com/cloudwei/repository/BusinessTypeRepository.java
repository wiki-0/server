package com.cloudwei.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TBusinessType;

public interface BusinessTypeRepository extends PagingAndSortingRepository<TBusinessType, Long> {
	
}
