package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolSession;

public interface TPatrolSessionRepository
        extends PagingAndSortingRepository<TPatrolSession, Long> {
	Page<TPatrolSession> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolSession> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
