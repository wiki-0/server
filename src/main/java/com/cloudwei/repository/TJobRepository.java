package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TJob;

public interface TJobRepository extends PagingAndSortingRepository<TJob, Long>{
	
    List<TJob> findAll();

	TJob findById(String serverId);
}
