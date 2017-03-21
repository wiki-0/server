package com.cloudwei.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Switch;

public interface SwitchRepository extends PagingAndSortingRepository<Switch, Long> {
	
    Page<Switch> findByPatrolTimeBetween(Date startDate,Date endDate,Pageable pageable);
    
    List<Switch> findByElementNameAndPatrolTimeBetween(String elementName,Date startDate,Date endDate);
}
