package com.cloudwei.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.BackupClient;

public interface BackupClientRepository
        extends PagingAndSortingRepository<BackupClient, Long> {
	@Query("select t from BackupClient t group by t.ip")
    Page<BackupClient> getAll(Pageable pageable);
}
