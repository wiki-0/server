package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TAlarmPatrol;

public interface TAlarmPatrolRepository extends PagingAndSortingRepository<TAlarmPatrol, Long> {
	Page<TAlarmPatrol> findByTapDeviceName(String tapDeviceName, Pageable pageable);
}
