package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolVolume;

public interface TPatrolVolumeRepository
        extends PagingAndSortingRepository<TPatrolVolume, Long> {
	Page<TPatrolVolume> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolVolume> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
