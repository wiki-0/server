package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolProcess;

public interface TPatrolProcessRepository
        extends PagingAndSortingRepository<TPatrolProcess, Long> {
	Page<TPatrolProcess> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolProcess> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
