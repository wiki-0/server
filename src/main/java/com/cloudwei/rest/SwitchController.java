package com.cloudwei.rest;

import com.cloudwei.dto.SwitchDto;
import com.cloudwei.entity.Switch;
import com.cloudwei.repository.SwitchRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/switch")
public class SwitchController {
	@Autowired
	private SwitchRepository switchRepository;

	@RequestMapping()
	public Page<SwitchDto> getSwitch(@RequestParam(value = "patrolTime", defaultValue = "") String patrolTime,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
		System.out.println("switchswitchswitchswitchswitchswitch");
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
		Page<Switch> fromPage = switchRepository.findAll(pageRequest);
		if (!StringUtils.isEmpty(patrolTime)) {

			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date queryDate = matter1.parse(patrolTime + " 00:00:00");
			Date endDate = matter1.parse(patrolTime + " 23:59:59");
			fromPage = switchRepository.findByPatrolTimeBetween(queryDate, endDate, pageRequest);
		}
		List<SwitchDto> content = Lists.transform(fromPage.getContent(), SwitchDto.list);
		Page<SwitchDto> page = new PageImpl<>(content, pageRequest, fromPage.getTotalElements());
		return page;
	}
}
