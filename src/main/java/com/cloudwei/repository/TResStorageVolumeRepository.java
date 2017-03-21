package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResStorageVolume;
import com.cloudwei.entity.TStorage;

public interface TResStorageVolumeRepository extends PagingAndSortingRepository<TResStorageVolume, Long> {
	Page<TResStorageVolume> findByStorageID(TStorage storageID, Pageable pageable);

}
