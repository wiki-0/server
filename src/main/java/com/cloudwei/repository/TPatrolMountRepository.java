package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolMount;

public interface TPatrolMountRepository
        extends PagingAndSortingRepository<TPatrolMount, Long> {
	Page<TPatrolMount> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolMount> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
