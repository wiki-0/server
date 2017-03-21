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

import com.cloudwei.dto.TResControllerDto;
import com.cloudwei.entity.TResController;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TResControllerRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tResController")

public class TResControllerController {
	@Autowired
	private TResControllerRepository tResControllerRepository;

	@RequestMapping()
	public Page<TResControllerDto> getTResController(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TResController> fromPage = tResControllerRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tResControllerRepository.findByStorageID(storageID, pageRequest);
		}
		List<TResControllerDto> content = Lists.transform(fromPage.getContent(), TResControllerDto.list);// 取到所有的直
		Page<TResControllerDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TResControllerDto getDetail(@PathVariable Long id) {
		TResController tResController = tResControllerRepository.findOne(id);
		return TResControllerDto.detail.apply(tResController);
	}

}
