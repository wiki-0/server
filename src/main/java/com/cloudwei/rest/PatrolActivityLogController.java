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

import com.cloudwei.dto.PatrolActivityLogDto;
import com.cloudwei.entity.PatrolActivityLog;
import com.cloudwei.repository.PatrolActivityLogRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolActivityLog")
public class PatrolActivityLogController {

    @Autowired
    private PatrolActivityLogRepository patrolActivityLogRepository;
    /**
     * 服务器日志
     * @return
     */
    @RequestMapping
    public Page<PatrolActivityLogDto> getPatrolActivityLog(
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<PatrolActivityLog> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
        	fromPage = patrolActivityLogRepository.findAll(pageRequest);
        }else{
        	fromPage = patrolActivityLogRepository.findByPatrolTypeAndPatrolTimeStartingWith(patrolType, queryTime, pageRequest);
        }
        List<PatrolActivityLogDto> content =
                Lists.transform(fromPage.getContent(), PatrolActivityLogDto.list);
        Page<PatrolActivityLogDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public PatrolActivityLogDto getDetail(@PathVariable Long id) {
        PatrolActivityLog patrolActivityLog = patrolActivityLogRepository.findOne(id);
        return PatrolActivityLogDto.detail.apply(patrolActivityLog);
    }
}
