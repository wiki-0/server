package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.AlarmPatrol;
import com.cloudwei.entity.TPrfDssystem;
import com.cloudwei.entity.TStorage;

public interface TPrfDssystemRepository extends PagingAndSortingRepository<TPrfDssystem, Long>{
	
	Page<TPrfDssystem> findByStorageID(TStorage storageID,Pageable pageable);

}
