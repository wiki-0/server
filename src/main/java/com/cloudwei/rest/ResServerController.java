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

import com.cloudwei.dto.ResServerDto;
import com.cloudwei.entity.ResServer;
import com.cloudwei.repository.ResServerRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/resServer")
public class ResServerController {

    @Autowired
    private ResServerRepository ResServerRepository;
    /**
     * 
     * @return
     */
    @RequestMapping
    public Page<ResServerDto> getResServer(
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "ip");
        Page<ResServer> fromPage = ResServerRepository.findAll(pageRequest);
        List<ResServerDto> content =
                Lists.transform(fromPage.getContent(), ResServerDto.list);
        Page<ResServerDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }
}
