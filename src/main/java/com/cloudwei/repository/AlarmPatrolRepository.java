package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.AlarmPatrol;

public interface AlarmPatrolRepository extends
		PagingAndSortingRepository<AlarmPatrol, Long> {
	Page<AlarmPatrol> findByTapDeviceName(String tapDeviceName,Pageable pageable);
}
