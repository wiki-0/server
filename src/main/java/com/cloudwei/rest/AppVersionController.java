package com.cloudwei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.entity.AppVersion;
import com.cloudwei.repository.AppVersionRepository;

@RestController
@RequestMapping(value = "/appVersion")
public class AppVersionController {

    @Autowired
    private AppVersionRepository appVersionRepository;

    @RequestMapping(value = "/check")
    public String check(String version) {
        List<AppVersion> list = appVersionRepository.findAll(new Sort(Direction.DESC, "date"));
        if (list.size() > 0) {
            AppVersion newAppVersion = list.get(0);
            return newAppVersion.getVersion();
        }
        return "";
    }
}
