package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.dto.ResPortDto;
import com.cloudwei.entity.ResPort;
import com.cloudwei.entity.Switch;
import com.cloudwei.repository.ResPortRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/resPort")
public class ResPortController {

    @Autowired
    private ResPortRepository resPortRepository;

    /**
     * 
     * @return
     */
    @RequestMapping()
    public Page<ResPortDto> getResPort(
            @RequestParam(value = "switchID", defaultValue = "") Switch switchID, 
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "status");
        Page<ResPort> fromPage = resPortRepository.findBySwitch2(switchID, pageRequest);
        List<ResPortDto> content = Lists.transform(fromPage.getContent(), ResPortDto.list);
        Page<ResPortDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }
}
