package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolStgpool;

public interface TPatrolStgpoolRepository
        extends PagingAndSortingRepository<TPatrolStgpool, Long> {

	Page<TPatrolStgpool> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
    
    Page<TPatrolStgpool> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
