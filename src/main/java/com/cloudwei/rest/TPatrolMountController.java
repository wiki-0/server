package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.TPatrolMountDto;
import com.cloudwei.entity.TPatrolMount;
import com.cloudwei.repository.TPatrolMountRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolMount")
public class TPatrolMountController {

    @Autowired
    private TPatrolMountRepository TPatrolMountRepository;
    /**
     * 已安装存储信息
     */    
    @RequestMapping
    public Page<TPatrolMountDto> getTPatrolMount(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolMount> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolMountRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolMountRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolMountDto> content =
                Lists.transform(fromPage.getContent(), TPatrolMountDto.list);
        Page<TPatrolMountDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }
}
