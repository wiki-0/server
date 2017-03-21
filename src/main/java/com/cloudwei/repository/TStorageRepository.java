package com.cloudwei.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TStorage;

public interface TStorageRepository extends PagingAndSortingRepository<TStorage, Long>{
	Page<TStorage> findByElementNameAndPatrolTimeStartingWith(String patrolTime,String elementName,Pageable pageable);
	Page<TStorage> findByElementName(String elementName,Pageable pageable);
	Page<TStorage> findBypatrolTimeStartingWith(String patrolTime,Pageable pageable);
	List<TStorage> findByElementNameAndPatrolTimeBetween(String elementName,Date startDate,Date endDate);
}
