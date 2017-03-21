package com.cloudwei.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.THaGpfsTask;

public interface HaGpfsTaskRepository extends PagingAndSortingRepository<THaGpfsTask, Long>{
	Page<THaGpfsTask> findByTHaGpfsTaskIpAndPatrolTimeStartingWith(String tHaGpfsTaskIp,String queryTime,Pageable pageable);
	Page<THaGpfsTask> findByTHaGpfsTaskIp(String tHaGpfsTaskIp,Pageable pageable);
	Page<THaGpfsTask> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
	
	@Query(value = "from THaGpfsTask t where t.id in(select tHaGpfsResultsTaskId from THaGpfsResults ts where ts.tHaGpfsResultsShowvalue in  ('OK','ERROR') and ts.tHagpfsResultsSetId in (select id from THaGpfsSet where tHaGpfsSetType='7' ))")
	Page<THaGpfsTask> findAll(Pageable pageable);

}
