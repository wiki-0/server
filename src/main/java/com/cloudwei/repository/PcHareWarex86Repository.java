package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.PcHardwarex86;

public interface PcHareWarex86Repository extends PagingAndSortingRepository<PcHardwarex86, Long> {
    Page<PcHardwarex86> findByPatrolTimeStartingWith(String patrolTime, Pageable pageable);
}
