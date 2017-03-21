package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolPath;

public interface TPatrolPathRepository
        extends PagingAndSortingRepository<TPatrolPath, Long> {
	Page<TPatrolPath> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolPath> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
