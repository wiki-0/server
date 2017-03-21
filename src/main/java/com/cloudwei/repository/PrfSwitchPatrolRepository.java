package com.cloudwei.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.PrfSwitchPatrol;
import com.cloudwei.entity.Switch;

public interface PrfSwitchPatrolRepository extends PagingAndSortingRepository<PrfSwitchPatrol, Long> {
	Page<PrfSwitchPatrol> findBySwitchPatrol(Switch switchPatrol,Pageable pageable);

}
