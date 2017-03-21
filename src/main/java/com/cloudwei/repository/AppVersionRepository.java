package com.cloudwei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudwei.entity.AppVersion;

public interface AppVersionRepository extends JpaRepository<AppVersion, Long>{

}
