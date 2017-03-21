package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.PrfSwitchPatrolDto;
import com.cloudwei.entity.PrfSwitchPatrol;
import com.cloudwei.entity.Switch;
import com.cloudwei.repository.PrfSwitchPatrolRepository;
import com.google.common.collect.Lists;


@RestController
@RequestMapping("/prfSwitchPatrol")
public class PrfSwitchPatrolController {
	@Autowired
	private PrfSwitchPatrolRepository prfSwitchPatrolRepository;
	
	@RequestMapping()
	public Page<PrfSwitchPatrolDto> getPrfSwitchPatrol(
			@RequestParam(value="switchID",defaultValue = "") Switch switchID,
			@RequestParam(value="pageNum",defaultValue = "0") int pageNum,
			@RequestParam(value="pageSize",defaultValue = "10") int pageSize){
		PageRequest pageRequest = new PageRequest(pageNum, pageSize);
		Page<PrfSwitchPatrol> frompPage = prfSwitchPatrolRepository.findBySwitchPatrol(switchID, pageRequest);
		List<PrfSwitchPatrolDto> content = Lists.transform(frompPage.getContent(), PrfSwitchPatrolDto.list);
		Page<PrfSwitchPatrolDto> page = new PageImpl<>(content,pageRequest,frompPage.getTotalElements());
		return page;
	}
}
