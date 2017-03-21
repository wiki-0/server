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

import com.cloudwei.dto.PcHardWarex86Dto;
import com.cloudwei.entity.PcHardwarex86;
import com.cloudwei.repository.PcHareWarex86Repository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/pcHardWarex86")
public class PcHardWarex86Controller {
    @Autowired
    private PcHareWarex86Repository pcHareWarex86Repository;

    @RequestMapping()
    public Page<PcHardWarex86Dto> getPcHardWare(@RequestParam(value = "patrolTime",
            defaultValue = "") String patrolTime, @RequestParam(value = "pageNum",
            defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
        Page<PcHardwarex86> fromPage = pcHareWarex86Repository.findAll(pageRequest);
        if (!StringUtils.isEmpty(patrolTime)) {
            fromPage =
                    pcHareWarex86Repository.findByPatrolTimeStartingWith(patrolTime, pageRequest);
        }
        List<PcHardWarex86Dto> content =
                Lists.transform(fromPage.getContent(), PcHardWarex86Dto.list);
        Page<PcHardWarex86Dto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }

    @RequestMapping(value = "/{id}")
    public PcHardWarex86Dto getDetail(@PathVariable Long id) {
        PcHardwarex86 pcHardwarex86 = pcHareWarex86Repository.findOne(id);
        return PcHardWarex86Dto.detail.apply(pcHardwarex86);
    }
}
