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

import com.cloudwei.dto.TPrfDssystemDto;
import com.cloudwei.entity.TPrfDssystem;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TPrfDssystemRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("tPrfDssystem")

public class TPrfDssystemController {

	@Autowired
	private TPrfDssystemRepository tPrfDssystemRepository;

	@RequestMapping()
	public Page<TPrfDssystemDto> getTPrfDssystem(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TPrfDssystem> fromPage = tPrfDssystemRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tPrfDssystemRepository.findByStorageID(storageID, pageRequest);
		}
		List<TPrfDssystemDto> content = Lists.transform(fromPage.getContent(), TPrfDssystemDto.list);// 取到所有的直
		Page<TPrfDssystemDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TPrfDssystemDto getDetail(@PathVariable Long id) {
		TPrfDssystem tPrfDssystem = tPrfDssystemRepository.findOne(id);
		return TPrfDssystemDto.detail.apply(tPrfDssystem);
	}

}
