package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Switch;
import com.cloudwei.entity.ZonePatrol;

public interface ZonePatrolRepository extends
		PagingAndSortingRepository<ZonePatrol, Long> {

	Page<ZonePatrol> findBySwitchPatrol(Switch switchPatrol, Pageable pageable);

}
