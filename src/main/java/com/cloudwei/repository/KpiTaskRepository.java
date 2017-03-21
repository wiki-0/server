package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.THaGpfsResults;
import com.cloudwei.entity.THaGpfsTask;

public interface KpiTaskRepository extends PagingAndSortingRepository<THaGpfsTask, Long>{
/*	@Query("from THaGpfsResults t where t.tHaGpfsResultsShowvalue in ('OK','ERROR') and t.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType in (6)) and t.tHaGpfsResultsTaskId in (select id from TPatrolKpiTask where tPatrolKpiTaskType='aix' and patrolTime like ?1)")
	Page<THaGpfsResults> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);*/
	Page<THaGpfsTask> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
	
	/*@Query("from THaGpfsResults t where t.tHaGpfsResultsShowvalue in ('OK','ERROR') and t.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType in (6)) and t.tHaGpfsResultsTaskId in (select id from TPatrolKpiTask where tPatrolKpiTaskType='aix')")
	Page<THaGpfsResults> findAll(Pageable pageable);*/

	/*@Query("from THaGpfsResults t where t.tHaGpfsResultsShowvalue in ('OK','ERROR') and t.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType in (6)) and t.tHaGpfsResultsTaskId= ?1")
	Page<THaGpfsResults> findByTHaGpfsResultsTaskId(long tHaGpfsResultsTaskId,Pageable pageable);*/
}
