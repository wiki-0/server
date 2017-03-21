package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Result;

public interface LogPatrolx86Repository extends PagingAndSortingRepository<Result, Long> {
	@Query(value = "from Result t where t.job.type ='1' and t.resultTime like ?1 and t.status = ?2")
	Page<Result> findResult(String resultTime, String status, Pageable pageable);

	@Query(value = "from Result t where t.job.type ='1' ")
	Page<Result> findAll(Pageable pageable);
	
	Page<Result> findByResultTimeStartingWith(String resultTime, Pageable pageable);

}
