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

import com.cloudwei.dto.TResRaidgroupDto;
import com.cloudwei.entity.TResRaidgroup;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TResRaidgroupRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tResRaidgroup")

public class TResRaidgroupController {
	@Autowired
	private TResRaidgroupRepository tResRaidgroupRepository;

	@RequestMapping()
	public Page<TResRaidgroupDto> getTResRaidgroup(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TResRaidgroup> fromPage = tResRaidgroupRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tResRaidgroupRepository.findByStorageID(storageID, pageRequest);
		}
		List<TResRaidgroupDto> content = Lists.transform(fromPage.getContent(), TResRaidgroupDto.list);// 取到所有的直
		Page<TResRaidgroupDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TResRaidgroupDto getDetail(@PathVariable Long id) {
		TResRaidgroup tResRaidgroup = tResRaidgroupRepository.findOne(id);
		return TResRaidgroupDto.detail.apply(tResRaidgroup);
	}
}
