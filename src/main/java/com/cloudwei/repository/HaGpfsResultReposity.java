package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.THaGpfsResults;

public interface HaGpfsResultReposity extends PagingAndSortingRepository<THaGpfsResults, Long> {
	@Query("from THaGpfsResults t where  t.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType in (3,5)) and t.tHaGpfsResultsTaskId in (select id from THaGpfsTask where patrolTime like ?1)")
	Page<THaGpfsResults> findByPatrolTimeStartingWith(String patrolTime, Pageable pageable);

	List<THaGpfsResults> findByTHaGpfsResultsTaskId(long tHaGpfsResultsTaskId);

	List<THaGpfsResults> findByTHagpfsResultsSetIdInAndTHaGpfsResultsTaskId(List<Long> setId, long taskID);

	@Query("from THaGpfsResults t where  t.tHaGpfsResultsShowvalue in ('OK','ERROR') ")
	List<THaGpfsResults> findAll();

	/*
	 * x86
	 */
	@Query("from THaGpfsResults t where  t.tHaGpfsResultsShowvalue in ('OK','ERROR') and t.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType='7' ) and t.tHaGpfsResultsTaskId =?1")
	List<THaGpfsResults> findByTHaGpfsResultsTaskIdAndTHaGpfsResultsShowvalue(long tHaGpfsResultsTaskId);
}
