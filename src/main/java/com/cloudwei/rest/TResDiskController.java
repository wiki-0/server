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

import com.cloudwei.dto.TResDiskDto;
import com.cloudwei.entity.TResDisk;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TResDiskRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tResDisk")

public class TResDiskController {
	@Autowired
	private TResDiskRepository tResDiskRepository;

	@RequestMapping()
	public Page<TResDiskDto> getTResDisk(@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TResDisk> fromPage = tResDiskRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tResDiskRepository.findByStorageID(storageID, pageRequest);
		}
		List<TResDiskDto> content = Lists.transform(fromPage.getContent(), TResDiskDto.list);// 取到所有的直
		Page<TResDiskDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TResDiskDto getDetail(@PathVariable Long id) {
		TResDisk tResDisk = tResDiskRepository.findOne(id);
		return TResDiskDto.detail.apply(tResDisk);
	}

}
