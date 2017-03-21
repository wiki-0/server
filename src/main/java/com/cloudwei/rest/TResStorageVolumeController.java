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

import com.cloudwei.dto.TResStorageVolumeDto;
import com.cloudwei.entity.TResStorageVolume;
import com.cloudwei.entity.TStorage;
import com.cloudwei.repository.TResStorageVolumeRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tResStorageVolume")
public class TResStorageVolumeController {
	@Autowired
	private TResStorageVolumeRepository tResStorageVolumeRepository;

	@RequestMapping()
	public Page<TResStorageVolumeDto> getTResStorageVolume(
			@RequestParam(value = "storageID", defaultValue = "") TStorage storageID,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "storageID");
		Page<TResStorageVolume> fromPage = tResStorageVolumeRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(storageID)) {
			fromPage = tResStorageVolumeRepository.findByStorageID(storageID, pageRequest);
		}
		List<TResStorageVolumeDto> content = Lists.transform(fromPage.getContent(), TResStorageVolumeDto.list);// 取到所有的直
		Page<TResStorageVolumeDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());// 转换成对象
		return page;
	}

	@RequestMapping(value = "/{id}")
	public TResStorageVolumeDto getDetail(@PathVariable Long id) {
		TResStorageVolume tResStorageVolume = tResStorageVolumeRepository.findOne(id);
		return TResStorageVolumeDto.detail.apply(tResStorageVolume);

	}
}
