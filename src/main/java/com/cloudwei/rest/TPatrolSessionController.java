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

import com.cloudwei.dto.TPatrolSessionDto;
import com.cloudwei.entity.TPatrolSession;
import com.cloudwei.repository.TPatrolSessionRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolSession")
public class TPatrolSessionController {

    @Autowired
    private TPatrolSessionRepository TPatrolSessionRepository;
    /**
     * 会话
     */    
    @RequestMapping
    public Page<TPatrolSessionDto> getTPatrolSession(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolSession> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolSessionRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolSessionRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolSessionDto> content =
                Lists.transform(fromPage.getContent(), TPatrolSessionDto.list);
        Page<TPatrolSessionDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolSessionDto getDetail(@PathVariable Long id) {
        TPatrolSession TPatrolSession = TPatrolSessionRepository.findOne(id);
        return TPatrolSessionDto.detail.apply(TPatrolSession);
    }
}
