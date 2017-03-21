package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResLunMapping;
import com.cloudwei.entity.TStorage;

public interface TResLunMappingRepository extends PagingAndSortingRepository<TResLunMapping, Long> {
	Page<TResLunMapping> findByStorageID(TStorage storageID, Pageable pageable);

}
