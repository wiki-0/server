package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Switch;
import com.cloudwei.entity.SwitchFan;

public interface SwitchFanRepository extends PagingAndSortingRepository<SwitchFan, Long>{
	Page<SwitchFan> findByTSwithFanStatus(String tSwithFanStatus,Pageable pageable);
	
	@Query("from SwitchFan t where t.switchPatrol =?1")
	Page<SwitchFan> findBySwitchPatrol(Switch switchPatrol,Pageable pageable);
}
