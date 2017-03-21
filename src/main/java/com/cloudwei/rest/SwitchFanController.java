package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.SwitchFanDto;
import com.cloudwei.entity.Switch;
import com.cloudwei.entity.SwitchFan;
import com.cloudwei.repository.SwitchFanRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/switchFan")
public class SwitchFanController {

		@Autowired
		private SwitchFanRepository switchFanRepository;
		
		@RequestMapping
		public Page<SwitchFanDto> getSwitchFan(
				@RequestParam(value="switchID",defaultValue="")Switch switchID,
				 @RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
				 @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
			
			PageRequest pageRequest=new PageRequest(pageNum, pageSize);
			
			
			Page<SwitchFan> fromPage=switchFanRepository.findBySwitchPatrol(switchID, pageRequest);
			System.out.println(fromPage.getTotalElements());
			/*if(!StringUtils.isEmpty(switchID))
					fromPage=switchFanRepository.findByTSwithFanStatus(switchID,pageRequest);*/
			
			List<SwitchFanDto> content =
	                Lists.transform(fromPage.getContent(), SwitchFanDto.list);
	        
	        Page<SwitchFanDto> page =
	                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
	        
	        return page;
		}
		
		@RequestMapping(value = "/{id}")
		public SwitchFanDto getDetail(@PathVariable Long id){
			SwitchFan switchFan = switchFanRepository.findOne(id);
			return SwitchFanDto.detail.apply(switchFan);
		}
}
