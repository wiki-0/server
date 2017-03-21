package com.cloudwei.repository;

import java.util.Date;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResult;

public interface TResultRepository
        extends PagingAndSortingRepository<TResult, Long> {
	List<TResult> findByStatusAndResultTimeBetween(String status ,Date startDate,Date endDate);
	
	List<TResult> findByNodeIdAndStatusAndResultTimeBetween(String nodeId ,String status ,Date startDate,Date endDate);
	
	@Query("select t from TResult t join t.Job j where t.resultTime between ?1 and ?2 and t.status = ?3 and j.id = ?4 order by j.id desc")
	List<TResult> getStatus(Date startDate ,Date endDate ,String status , Long jobId);
	
	@Query("select t from TResult t join t.Job j where  t.status = ?1 and j.id = ?2 order by j.id desc")
	List<TResult> getAllStatus(String status , Long jobId);
	
	@Query("select t from TResult t join t.Job j where t.resultTime between ?1 and ?2 and j.type = ?3 order by t.id desc")
	Page<TResult> getJobType(Date resultTime ,Date endTime , String type ,Pageable pageable);
	
	@Query("select t from TResult t join t.User j where j.id = ?1")
	List<TResult> findByUserId(Long id);
	
	@Query("select t from TResult t join t.Job j where t.status = ?1 and t.resultTime between ?2 and ?3 and j.id = ?4 order by j.id desc")
	List<TResult> getJobId(String status ,Date startDate ,Date endDate , Long jobId);

	TResult findById(Long id);
}
