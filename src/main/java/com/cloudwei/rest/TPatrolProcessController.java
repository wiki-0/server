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

import com.cloudwei.dto.TPatrolProcessDto;
import com.cloudwei.entity.TPatrolProcess;
import com.cloudwei.repository.TPatrolProcessRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolProcess")
public class TPatrolProcessController {

    @Autowired
    private TPatrolProcessRepository TPatrolProcessRepository;
    /**
     * 查询进程
     */    
    @RequestMapping
    public Page<TPatrolProcessDto> getTPatrolProcess(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolProcess> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolProcessRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolProcessRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolProcessDto> content =
                Lists.transform(fromPage.getContent(), TPatrolProcessDto.list);
        Page<TPatrolProcessDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolProcessDto getDetail(@PathVariable Long id) {
        TPatrolProcess TPatrolProcess = TPatrolProcessRepository.findOne(id);
        return TPatrolProcessDto.detail.apply(TPatrolProcess);
    }
}
