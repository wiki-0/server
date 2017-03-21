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

import com.cloudwei.dto.TPatrolStgpoolDto;
import com.cloudwei.entity.TPatrolStgpool;
import com.cloudwei.repository.TPatrolStgpoolRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolStgpool")
public class TPatrolStgpoolController {

    @Autowired
    private TPatrolStgpoolRepository TPatrolStgpoolRepository;
    /**
     * 存储池
     * @return
     */
    @RequestMapping
    public Page<TPatrolStgpoolDto> getTPatrolStgpool(
            @RequestParam(value = "serverId", defaultValue = "2") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolStgpool> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolStgpoolRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolStgpoolRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolStgpoolDto> content =
                Lists.transform(fromPage.getContent(), TPatrolStgpoolDto.list);
        Page<TPatrolStgpoolDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolStgpoolDto getDetail(@PathVariable Long id) {
        TPatrolStgpool TPatrolStgpool = TPatrolStgpoolRepository.findOne(id);
        return TPatrolStgpoolDto.detail.apply(TPatrolStgpool);
    }
}
