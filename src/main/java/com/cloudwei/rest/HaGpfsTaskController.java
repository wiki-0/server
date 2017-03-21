package com.cloudwei.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.HaGpfsTaskDto;
import com.cloudwei.entity.THaGpfsTask;
import com.cloudwei.repository.HaGpfsTaskRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/haGpfs")
public class HaGpfsTaskController {
	@Autowired
	private HaGpfsTaskRepository haGpfsTaskRepository;
//	private HaGpfsSetRepository HaGpfsSetRepository;

	@RequestMapping
	public Page<HaGpfsTaskDto> getHaGpfsTask(
				@RequestParam(value = "patrolIP", defaultValue = "") String patrolIP,
	            @RequestParam(value = "patrolTime", defaultValue = "")String patrolTime,
	            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
	            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
		Page<THaGpfsTask> fromPage=haGpfsTaskRepository.findByTHaGpfsTaskIpAndPatrolTimeStartingWith(patrolIP, patrolTime, pageRequest);

//		List<THaGpfsSet> tHaGpfsSet=HaGpfsSetRepository.findByTHaGpfsSetTypeBetween("3", "5");
		
		if (StringUtils.isEmpty(patrolTime)) {
        	Date date=new Date();
        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        	String today=format.format(date);
            fromPage = haGpfsTaskRepository.findByTHaGpfsTaskIpAndPatrolTimeStartingWith(patrolIP, today, pageRequest);
        }
		List<HaGpfsTaskDto> content =
                Lists.transform(fromPage.getContent(), HaGpfsTaskDto.list);
        Page<HaGpfsTaskDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
		return page;
	}
}
