package com.cloudwei.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPatrolKpiTask;

public interface TPatrolKpiTaskRepository extends PagingAndSortingRepository<TPatrolKpiTask, Long> {
    List<TPatrolKpiTask> findByTPatrolKpiTaskType(String tPatrolKpiTaskType);
    Page<TPatrolKpiTask> findByTPatrolKpiTaskType(String tPatrolKpiTaskType,Pageable pageable);
    
    @Query("from TPatrolKpiTask t where t.tPatrolKpiTaskType='aix' and t.patrolTime like ?1")
    Page<TPatrolKpiTask> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
    
    @Query(value ="from TPatrolKpiTask t where t.tPatrolKpiTaskType = ?1 and t.patrolType='auto' and t.patrolTime like ?2")
    Page<TPatrolKpiTask> findByTPatrolKpiTaskTypeAndPatrolTimeStartingWith(String tPatrolKpiTaskType,String patrolTime,Pageable pageable);

    @Query(value="from TPatrolKpiTask t where t.tPatrolKpiTaskType= ? and t.patrolType='auto'")
    Page<TPatrolKpiTask> findAll(String str,Pageable pageable);

}
