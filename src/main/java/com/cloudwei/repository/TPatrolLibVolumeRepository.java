package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolLibVolume;

public interface TPatrolLibVolumeRepository
        extends PagingAndSortingRepository<TPatrolLibVolume, Long> {
	Page<TPatrolLibVolume> findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(String serverId ,String patrolType,String patrolTime,Pageable pageable);
	
	Page<TPatrolLibVolume> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
