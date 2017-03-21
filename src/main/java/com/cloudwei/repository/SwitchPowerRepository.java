package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Switch;
import com.cloudwei.entity.SwitchPower;

public interface SwitchPowerRepository extends PagingAndSortingRepository<SwitchPower, Long>{
	
	Page<SwitchPower> findByTspsPhysicalPackageId(String tspsPhysicalPackageId,Pageable pageable);
	
	Page<SwitchPower> findByTspsSerialNumber(String tspsSerialNumber,Pageable pageable);
	
	Page<SwitchPower> findByTspsTotalOutputPower(String tspsTotalOutputPower,Pageable pageable);
	
	Page<SwitchPower> findBySwitchPatrol(Switch s,Pageable pageable);
}
