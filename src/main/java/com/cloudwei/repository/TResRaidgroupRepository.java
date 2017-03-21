package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResRaidgroup;
import com.cloudwei.entity.TStorage;

public interface TResRaidgroupRepository extends PagingAndSortingRepository<TResRaidgroup, Long> {
	Page<TResRaidgroup> findByStorageID(TStorage storageID, Pageable pageable);

}
