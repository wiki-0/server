package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.LogPatrolx86Dto;
import com.cloudwei.entity.Result;
import com.cloudwei.repository.LogPatrolx86Repository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/logPatrolx86")
public class LogPatrolx86Controller {
	@Autowired
	private LogPatrolx86Repository LogPatrolx86Depository;

	@RequestMapping()
	public Page<LogPatrolx86Dto> getResult(@RequestParam(value = "patrolStatus", defaultValue = "") String patrolStatus,
			@RequestParam(value = "resultTime", defaultValue = "") String resultTime,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "resultTime");
		Page<Result> results = LogPatrolx86Depository.findAll(pageRequest);
		if (!StringUtils.isEmpty(resultTime)) {
			results = LogPatrolx86Depository.findResult(resultTime + "%", patrolStatus, pageRequest);
		}
		List<LogPatrolx86Dto> content = Lists.transform(results.getContent(), LogPatrolx86Dto.list);
		Page<LogPatrolx86Dto> page = new PageImpl<>(content, pageRequest, results.getTotalElements());
		return page;
	}

	@RequestMapping(value = "/{id}")
	public LogPatrolx86Dto getDetail(@PathVariable Long id) {
		Result result = LogPatrolx86Depository.findOne(id);
		return LogPatrolx86Dto.detail.apply(result);
	}

}
