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

import com.cloudwei.dto.AlarmPatrolDto;
import com.cloudwei.entity.AlarmPatrol;
import com.cloudwei.repository.AlarmPatrolRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/alarmPatrol")
public class AlarmPatrolController {
	@Autowired
	private AlarmPatrolRepository alarmPatrolRepository;
	
	@RequestMapping()
	public Page<AlarmPatrolDto> getAlarmPatrol(
			@RequestParam(value="tapDeviceName",defaultValue="") String tapDeviceName,
			@RequestParam(value="pageNum",defaultValue="0") int pageNum,
			@RequestParam(value="pageSize",defaultValue="10") int pageSize){
		PageRequest pageRequest = new PageRequest(pageNum,pageSize,Direction.DESC,"tapDeviceName");
		Page<AlarmPatrol> fromPage = alarmPatrolRepository.findAll(pageRequest);
		if(!StringUtils.isEmpty(tapDeviceName)){
			fromPage = alarmPatrolRepository.findByTapDeviceName(tapDeviceName, pageRequest);
		}
		List<AlarmPatrolDto> content = Lists.transform(fromPage.getContent(), AlarmPatrolDto.list);//取到所有的直
		Page<AlarmPatrolDto> page= new PageImpl<>(content,pageRequest,fromPage.getTotalElements()) ;//转换成对象
		return page;
	}
	
	@RequestMapping(value="/{id}")
	public AlarmPatrolDto getDetail(@PathVariable Long id ){
		AlarmPatrol alarmPatrol = alarmPatrolRepository.findOne(id);
		return AlarmPatrolDto.detail.apply(alarmPatrol);
	}

}
