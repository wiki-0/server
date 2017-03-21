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

import com.cloudwei.dto.SwitchPowerDto;
import com.cloudwei.entity.Switch;
import com.cloudwei.entity.SwitchPower;
import com.cloudwei.repository.SwitchPowerRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/switchPower")
public class SwitchPowerController {
	
	@Autowired
	private SwitchPowerRepository switchPowerRepository;
	
	@RequestMapping
	public Page<SwitchPowerDto> getSwitchPower(
			 @RequestParam(value = "switchID", defaultValue = "")Switch switchID,
			 @RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
			 @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
		
		PageRequest pageRequest=new PageRequest(pageNum, pageSize);
		
		Page<SwitchPower> fromPage=switchPowerRepository.findBySwitchPatrol(switchID, pageRequest);
		
		 List<SwitchPowerDto> content =
	                Lists.transform(fromPage.getContent(), SwitchPowerDto.list);
	        
	        Page<SwitchPowerDto> page =
	                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
	        
	        return page;
	}
	
	@RequestMapping(value = "/{id}")
	public SwitchPowerDto getDetail(@PathVariable Long id){
		SwitchPower switchPower = switchPowerRepository.findOne(id);
		return SwitchPowerDto.detail.apply(switchPower);
	}
}
