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

import com.cloudwei.dto.TResLunMappingDto;
import com.cloudwei.entity.TResLunMapping;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TResLunMappingRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tResLunMapping")

public class TResLunMappingController {
	@Autowired
	private TResLunMappingRepository tResLunMappingRepository;

	@RequestMapping()
	public Page<TResLunMappingDto> getTResLunMapping(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TResLunMapping> fromPage = tResLunMappingRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tResLunMappingRepository.findByStorageID(storageID, pageRequest);
		}
		List<TResLunMappingDto> content = Lists.transform(fromPage.getContent(), TResLunMappingDto.list);// 取到所有的直
		Page<TResLunMappingDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TResLunMappingDto getDetail(@PathVariable Long id) {
		TResLunMapping tResLunMapping = tResLunMappingRepository.findOne(id);
		return TResLunMappingDto.detail.apply(tResLunMapping);
	}

}
