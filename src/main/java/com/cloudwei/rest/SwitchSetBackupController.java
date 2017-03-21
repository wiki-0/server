package com.cloudwei.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

import com.cloudwei.dto.SwitchSetBackupDto;
import com.cloudwei.entity.SwitchSetBackup;
import com.cloudwei.repository.SwitchSetBackupRepository;
import com.google.common.collect.Lists;

import java.util.List;


@RestController
@RequestMapping("/switchSetBackup")
public class SwitchSetBackupController {
	
	@Autowired
	private SwitchSetBackupRepository switchSetBackupRepository;
	
	@RequestMapping
	public Page<SwitchSetBackupDto> getSwitchSetBackup(
			@RequestParam(value="switchSetBackupIp",defaultValue="")String switchSetBackupIp,
			@RequestParam(value = "pageNum",defaultValue="0")int pageNum,
			@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
		
		PageRequest pageRequest=new PageRequest(pageNum, pageSize,Direction.DESC,"switchSetBackupIp");
		
		Page<SwitchSetBackup> fromPage=switchSetBackupRepository.findAll(pageRequest);
		
		if(!StringUtils.isEmpty(switchSetBackupIp))
			fromPage=switchSetBackupRepository.findBySwitchSetBackupIp(switchSetBackupIp, pageRequest);
		
		
		List<SwitchSetBackupDto> content=
				Lists.transform(fromPage.getContent(),SwitchSetBackupDto.list );
		
		 Page<SwitchSetBackupDto> page =
	                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
		
		return page;
	}
	
	@RequestMapping(value = "/{id}")
	public SwitchSetBackupDto getDetail(@PathVariable Long id){
		SwitchSetBackup switchSetBackup = switchSetBackupRepository.findOne(id);
		return SwitchSetBackupDto.detail.apply(switchSetBackup);
	}
}
