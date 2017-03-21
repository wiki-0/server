package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.ZonePatrolDto;
import com.cloudwei.entity.Switch;
import com.cloudwei.entity.ZonePatrol;
import com.cloudwei.repository.ZonePatrolRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/zonePatrol")
public class ZonePatrolController {
	@Autowired
	private ZonePatrolRepository zonePatrolRepository;
	
	
	@RequestMapping()
	public Page<ZonePatrolDto> getZonePatrol(
			@RequestParam(value = "switchID",defaultValue = "") Switch switchID,
			@RequestParam(value = "pageNum",defaultValue ="0")int pageNum,
			@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
		PageRequest pageRequest = new PageRequest(pageNum, pageSize);
		Page<ZonePatrol> fromPage= zonePatrolRepository.findBySwitchPatrol(switchID, pageRequest);
		List<ZonePatrolDto> content = Lists.transform(fromPage.getContent(), ZonePatrolDto.list);
		Page<ZonePatrolDto> page = new PageImpl<>(content,pageRequest,fromPage.getTotalElements());
		return page;
	}
}
