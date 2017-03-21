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

import com.cloudwei.dto.TPatrolDriveDto;
import com.cloudwei.entity.TPatrolDrive;
import com.cloudwei.repository.TPatrolDriveRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolDrive")
public class TPatrolDriveController {

    @Autowired
    private TPatrolDriveRepository TPatrolDriveRepository;
    /**
     * 存储设备 驱动器
     * @return
     */    
    @RequestMapping
    public Page<TPatrolDriveDto> getTPatrolDrive(
            @RequestParam(value = "serverId", defaultValue = "") String serverId,
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<TPatrolDrive> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
            fromPage = TPatrolDriveRepository.findAll(pageRequest);
        }else{
        	fromPage = TPatrolDriveRepository.findByServerIdAndPatrolTypeAndPatrolTimeStartingWith(serverId ,patrolType, queryTime, pageRequest);
        }
        List<TPatrolDriveDto> content =
                Lists.transform(fromPage.getContent(), TPatrolDriveDto.list);
        Page<TPatrolDriveDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public TPatrolDriveDto getDetail(@PathVariable Long id) {
        TPatrolDrive TPatrolDrive = TPatrolDriveRepository.findOne(id);
        return TPatrolDriveDto.detail.apply(TPatrolDrive);
    }
}
