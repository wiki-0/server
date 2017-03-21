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

import com.cloudwei.dto.TStoragePowerDto;
import com.cloudwei.entity.TStorage;
import com.cloudwei.entity.TStoragePower;
import com.cloudwei.repository.TStoragePowerRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tStoragePower")

public class TStoragePowerController {
	@Autowired
	private TStoragePowerRepository tStoragePowerRepository;

	@RequestMapping()
	public Page<TStoragePowerDto> getTStoragePower(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TStoragePower> fromPage = tStoragePowerRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tStoragePowerRepository.findByStorageID(storageID, pageRequest);
		}
		List<TStoragePowerDto> content = Lists.transform(fromPage.getContent(), TStoragePowerDto.list);// 取到所有的直
		Page<TStoragePowerDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TStoragePowerDto getDetail(@PathVariable Long id) {
		TStoragePower tStoragePower = tStoragePowerRepository.findOne(id);
		return TStoragePowerDto.detail.apply(tStoragePower);
	}

}
