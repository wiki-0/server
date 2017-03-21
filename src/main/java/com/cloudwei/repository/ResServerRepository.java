package com.cloudwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.ResServer;

public interface ResServerRepository extends PagingAndSortingRepository<ResServer, Long>{
//显示所有服务器
    Page<ResServer> findAll(Pageable pageable);

	ResServer findById(String serverId);
}
