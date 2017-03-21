package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TStorage;
import com.cloudwei.entity.TStoragePower;

public interface TStoragePowerRepository extends PagingAndSortingRepository<TStoragePower, Long> {
	Page<TStoragePower> findByStorageID(TStorage storageID, Pageable pageable);

}
