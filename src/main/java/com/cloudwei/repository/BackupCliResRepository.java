package com.cloudwei.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.BackupCliRes;

public interface BackupCliResRepository
        extends PagingAndSortingRepository<BackupCliRes, Long> {
	
    Page<BackupCliRes> findByPatrolTypeAndPatrolTimeBetween(String patrolType,Date queryDate,Date endDate,Pageable pageable);
    
    
    Page<BackupCliRes> findByPatrolTimeStartingWith(Date queryDate,Pageable pageable);
    
    Page<BackupCliRes> findByIpAndBmResultAndPatrolTimeBetween(String ip ,String bmResult,Date startDate,Date endDate,Pageable pageable);
    
    List<BackupCliRes> findByIpAndPatrolTimeBetween(String ip ,Date startDate,Date endDate);
}
