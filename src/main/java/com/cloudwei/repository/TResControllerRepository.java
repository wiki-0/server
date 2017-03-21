package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResController;
import com.cloudwei.entity.TStorage;

public interface TResControllerRepository extends PagingAndSortingRepository<TResController, Long> {

	Page<TResController> findByStorageID(TStorage storageID, Pageable pageable);
}
