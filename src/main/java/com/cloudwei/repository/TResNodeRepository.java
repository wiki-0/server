package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TResNode;

public interface TResNodeRepository extends PagingAndSortingRepository<TResNode, Long>{
//显示所有服务器
    Page<TResNode> findAll(Pageable pageable);

	TResNode findById(Long serverId);
	
}
