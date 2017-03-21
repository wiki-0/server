package com.cloudwei.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.Result;

public interface TPatrolMiniCpRepository extends PagingAndSortingRepository<Result, Long>{
	Page<Result> findById(long id,Pageable pageable);
	
	/**巡检时间 巡检ip 不为空
	 * 巡检IP
	 * @param resultTime
	 * @param ip
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.resultTime like ?1 and t.job.type=2 and t.node.ip= ?2")
	Page<Result> findByResultTimeAndNodeIp(String resultTime,String ip,Pageable pageable);
	
	@Query("from Result t where t.resultTime like ?1 and t.job.type=2")
	Page<Result> findByResultTimeStartingWith(String resultTime,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 不为空
	 * 巡检分类：ALARM
	 * @param resultTime
	 * @param status
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.status= ?1 and t.resultTime like ?2 and t.resultOutput!='' ")
	Page<Result> findByStatusAndResultTimeStartingWith(String status,String resultTime,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 不为空
	 * 巡检分类：OK
	 * @param status
	 * @param resultTime
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.status= ?1 and  t.resultTime like ?2 and t.resultOutput='' ")
	Page<Result> findByStatusAndResultTimeStartingWith2(String status,String resultTime,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 不为空
	 * 巡检分类：ERROR
	 * @param status
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.resultTime like ?1 and t.status= ?2 ")
	Page<Result> findByResultTimeStartingWithAndStatus(String resultTime,String status,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 ip都不为空
	 * 巡检分类：ALARM
	 * @param resultTime
	 * @param status
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.resultTime like ?1 and t.node.ip= ?2 and t.status= ?3 and t.resultOutput!='' ")
	Page<Result> findByResultTimeStartingWithAndNodeIpAndStatus1(String resultTime,String ip,String status,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 ip都不为空
	 * 巡检分类：OK
	 * @param resultTime
	 * @param status
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.resultTime like ?1 and t.node.ip= ?2 and t.status= ?3 and t.resultOutput='' ")
	Page<Result> findByResultTimeStartingWithAndNodeIpAndStatus2(String resultTime,String ip,String status,Pageable pageable);
	
	/**
	 * 巡检时间 巡检分类 ip都不为空
	 * 巡检分类：ERROR
	 * @param status
	 * @param pageable
	 * @return
	 */
	@Query("from Result t where t.resultTime like ?1 and t.node.ip= ?2 and t.status= ?3")
	Page<Result> findByResultTimeStartingWithAndNodeIpAndStatus3(String resultTime,String ip,String status,Pageable pageable);
	
}
