package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.PatrolActivityLog;

public interface PatrolActivityLogRepository
        extends PagingAndSortingRepository<PatrolActivityLog, Long> {
	//StartingWith就是以patrilTime开头去匹配时间
    Page<PatrolActivityLog> findByPatrolTypeAndPatrolTimeStartingWith(String patrolType,String patrolTime,Pageable pageable);
    
    Page<PatrolActivityLog> findByPatrolType(String patrolType,Pageable pageable);
  //Page<User> userPage = userRepository.findByPhoneStartingWithAndAddressContaining(phone,address,new PageRequest(page, pageSize,new Sort(Direction.ASC,"name","phone")));
    Page<PatrolActivityLog> findByPatrolTimeStartingWith(String patrolTime,Pageable pageable);
}
