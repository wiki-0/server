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

import com.cloudwei.dto.TPatrolVolumeDto;
import com.cloudwei.entity.TPatrolVolume;
import com.cloudwei.repository.TPatrolVolumeRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolVolume")
public class TPatrolVolumeController {

    @Autowired
    private TPatrolVolumeRepository TPatrolVolumeRepository;
    /**
     * 卷
     */    
    @RequestMapping
    public Page<TPatrolVolumeDto> getTPatrolVolume(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolVolume> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolVolumeRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolVolumeRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolVolumeDto> content =
                Lists.transform(fromPage.getContent(), TPatrolVolumeDto.list);
        Page<TPatrolVolumeDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolVolumeDto getDetail(@PathVariable Long id) {
        TPatrolVolume TPatrolVolume = TPatrolVolumeRepository.findOne(id);
        return TPatrolVolumeDto.detail.apply(TPatrolVolume);
    }
}
