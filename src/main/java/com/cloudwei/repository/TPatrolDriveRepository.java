package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolDrive;

public interface TPatrolDriveRepository
        extends PagingAndSortingRepository<TPatrolDrive, Long> {
	Page<TPatrolDrive> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolDrive> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
