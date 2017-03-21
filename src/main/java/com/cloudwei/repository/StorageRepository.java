package com.cloudwei.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Storage;

public interface StorageRepository extends PagingAndSortingRepository<Storage, Long>{
	
	List<Storage> findByElementNameAndPatrolTimeBetween(String elementName,Date startDate,Date endDate);
}
