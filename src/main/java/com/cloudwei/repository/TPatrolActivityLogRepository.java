package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.PatrolActivityLog;
import com.cloudwei.entity.TPatrolActivityLog;
import com.cloudwei.entity.TPatrolDrive;

public interface TPatrolActivityLogRepository
        extends PagingAndSortingRepository<TPatrolActivityLog, Long> {
    Page<TPatrolActivityLog> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
    
    Page<TPatrolActivityLog> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
