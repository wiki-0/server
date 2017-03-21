package com.cloudwei.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwei.entity.TPhThReason;

public interface TPhThReasonRepository extends PagingAndSortingRepository<TPhThReason, Long>{
	TPhThReason findByPhthIdAndIpAndResultId(String phthId,String ip,String resultId);
}
