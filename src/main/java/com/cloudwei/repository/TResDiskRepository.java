package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResDisk;
import com.cloudwei.entity.TStorage;

public interface TResDiskRepository extends PagingAndSortingRepository<TResDisk, Long> {
	Page<TResDisk> findByStorageID(TStorage storageID, Pageable pageable);

}
