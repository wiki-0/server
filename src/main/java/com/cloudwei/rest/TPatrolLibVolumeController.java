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

import com.cloudwei.dto.TPatrolLibVolumeDto;
import com.cloudwei.entity.TPatrolLibVolume;
import com.cloudwei.repository.TPatrolLibVolumeRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolLibVolume")
public class TPatrolLibVolumeController {

    @Autowired
    private TPatrolLibVolumeRepository TPatrolLibVolumeRepository;
    /**
     * 存储设备 库卷
     */    
    @RequestMapping
    public Page<TPatrolLibVolumeDto> getTPatrolLibVolume(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolLibVolume> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolLibVolumeRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolLibVolumeRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolLibVolumeDto> content =
                Lists.transform(fromPage.getContent(), TPatrolLibVolumeDto.list);
        Page<TPatrolLibVolumeDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolLibVolumeDto getDetail(@PathVariable Long id) {
        TPatrolLibVolume TPatrolLibVolume = TPatrolLibVolumeRepository.findOne(id);
        return TPatrolLibVolumeDto.detail.apply(TPatrolLibVolume);
    }
}
