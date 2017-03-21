package com.cloudwei.rest;

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

import com.cloudwei.dto.BackupCliResDto;
import com.cloudwei.entity.BackupCliRes;
import com.cloudwei.repository.BackupCliResRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/patrolBackupCliRes")
public class BackupCliResController {

    @Autowired
    private BackupCliResRepository BackupCliResRepository;
    /**
     * 客户端状态
     * @return
     * @throws ParseException 
     */
    @RequestMapping
    public Page<BackupCliResDto> getBackupCliRes(
            @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
            @RequestParam(value = "patrolType", defaultValue = "auto") String patrolType,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<BackupCliRes> fromPage;
        if (StringUtils.isEmpty(queryTime)) {
        	fromPage = BackupCliResRepository.findAll(pageRequest);
        }else{
            SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date start=matter1.parse(queryTime+" 00:00:00");
    		Date end =matter1.parse(queryTime+" 23:59:59");        	
        	fromPage = BackupCliResRepository.findByPatrolTypeAndPatrolTimeBetween(patrolType, start, end, pageRequest);
        }       
        List<BackupCliResDto> content =
                Lists.transform(fromPage.getContent(), BackupCliResDto.list);
        Page<BackupCliResDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public BackupCliResDto getDetail(@PathVariable Long id) {
        BackupCliRes BackupCliRes = BackupCliResRepository.findOne(id);
        return BackupCliResDto.detail.apply(BackupCliRes);
    }
}
