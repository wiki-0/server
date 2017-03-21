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

import com.cloudwei.dto.TPatrolPathDto;
import com.cloudwei.entity.TPatrolPath;
import com.cloudwei.repository.TPatrolPathRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolPath")
public class TPatrolPathController {

    @Autowired
    private TPatrolPathRepository TPatrolPathRepository;
    /**
     * 存储设备 路径
     * @return
     */    
    @RequestMapping
    public Page<TPatrolPathDto> getTPatrolPath(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolPath> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolPathRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolPathRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolPathDto> content =
                Lists.transform(fromPage.getContent(), TPatrolPathDto.list);
        Page<TPatrolPathDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolPathDto getDetail(@PathVariable Long id) {
        TPatrolPath TPatrolPath = TPatrolPathRepository.findOne(id);
        return TPatrolPathDto.detail.apply(TPatrolPath);
    }
}
