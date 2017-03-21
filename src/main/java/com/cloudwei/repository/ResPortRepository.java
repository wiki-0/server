package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.ResPort;
import com.cloudwei.entity.Switch;

public interface ResPortRepository extends
		PagingAndSortingRepository<ResPort, Long> {

	Page<ResPort> findBySwitch2(Switch switch2,Pageable pageable);

}
