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

import com.cloudwei.dto.TResNodeDto;
import com.cloudwei.entity.TResNode;
import com.cloudwei.repository.TResNodeRepository;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/tresNode")
public class TResNodeController {

    @Autowired
    private TResNodeRepository TResNodeRepository;
    /**
     * 
     * @return
     */
    @RequestMapping
    public Page<TResNodeDto> getTResNode(
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "ip");
        Page<TResNode> fromPage = TResNodeRepository.findAll(pageRequest);
        List<TResNodeDto> content =
                Lists.transform(fromPage.getContent(), TResNodeDto.list);
        Page<TResNodeDto> page =
                new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
        return page;
    }
}
