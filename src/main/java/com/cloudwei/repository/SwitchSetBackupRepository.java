package com.cloudwei.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.SwitchSetBackup;

public interface SwitchSetBackupRepository extends PagingAndSortingRepository<SwitchSetBackup, Long>{
	
	Page<SwitchSetBackup> findBySwitchSetBackupIp(String switchSetBackupIp,Pageable pageable);
	
}
