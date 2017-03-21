package com.cloudwei.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.cloudwei.dto.TPatrolActivityLogDto;
import com.cloudwei.entity.TPatrolActivityLog;
import com.cloudwei.repository.TPatrolActivityLogRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tpatrolActivityLog")
public class TPatrolActivityLogController {

    @Autowired
    private TPatrolActivityLogRepository TPatrolActivityLogRepository;
    /**
     * 活动日志
     * @return
     */    
    @RequestMapping
    public Page<TPatrolActivityLogDto> getTPatrolActivityLog(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolActivityLog> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
        	fromPage = TPatrolActivityLogRepository.findAll(pageRequest);
        }else{
        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        	Date datef = format.parse(queryTime); 
         	String startDate=format.format(datef);        	
        	fromPage = TPatrolActivityLogRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, startDate, pageRequest);
        }
        List<TPatrolActivityLogDto> content =
                Lists.transform(fromPage.getContent(), TPatrolActivityLogDto.list);
        Page<TPatrolActivityLogDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolActivityLogDto getDetail(@PathVariable Long id) {
        TPatrolActivityLog TPatrolActivityLog = TPatrolActivityLogRepository.findOne(id);
        return TPatrolActivityLogDto.detail.apply(TPatrolActivityLog);
    }
}
