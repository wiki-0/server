package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.TAlarmPatrolDto;
import com.cloudwei.entity.TAlarmPatrol;
import com.cloudwei.repository.TAlarmPatrolRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tAlarmPatrol")
public class TAlarmPatrolController {
	@Autowired
	private TAlarmPatrolRepository tAlarmPatrolRepository;

	@RequestMapping()
	public Page<TAlarmPatrolDto> getTAlarm(
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize);
		Page<TAlarmPatrol> fromPage = tAlarmPatrolRepository.findAll(pageRequest);
		List<TAlarmPatrolDto> content = Lists.transform(fromPage.getContent(), TAlarmPatrolDto.list);// 取到所有的直
		Page<TAlarmPatrolDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TAlarmPatrolDto getDetail(@PathVariable Long id) {
		TAlarmPatrol tAlarmPatrol = tAlarmPatrolRepository.findOne(id);
		return TAlarmPatrolDto.detail.apply(tAlarmPatrol);
	}
}
