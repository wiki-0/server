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

import com.cloudwei.dto.TStorageDto;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TStorageRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tStorage")

public class TStorageController {
	@Autowired
	private TStorageRepository tStorageRepository;
	
	@RequestMapping()
	public Page<TStorageDto> getTStorage(
			@RequestParam(value="patrolTime",defaultValue="") String patrolTime,
			@RequestParam(value="pageNum",defaultValue="0") int pageNum,
			@RequestParam(value="pageSize",defaultValue="10") int pageSize){
		PageRequest pageRequest = new PageRequest(pageNum,pageSize,Direction.DESC,"patrolTime");
		Page<TStorage> fromPage = tStorageRepository.findAll(pageRequest);
		if(!StringUtils.isEmpty(patrolTime)){
			fromPage = tStorageRepository.findBypatrolTimeStartingWith(patrolTime, pageRequest);
		}
		List<TStorageDto> content = Lists.transform(fromPage.getContent(), TStorageDto.list);//取到所有的直
		Page<TStorageDto> page= new PageImpl<>(content,pageRequest,fromPage.getTotalElements()) ;//转换成对象
		return page;
	}
	
	@RequestMapping(value="/{id}")
	public TStorageDto getDetail(@PathVariable Long id ){
		TStorage tStorage = tStorageRepository.findOne(id);
		return TStorageDto.detail.apply(tStorage);
	}

}
