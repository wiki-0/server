package com.cloudwei.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.entity.TPhThReason;
import com.cloudwei.repository.TPhThReasonRepository;
import com.google.gson.Gson;

@RestController
@RequestMapping("/phthReason")
public class TPhThReasonController {
	@Autowired
	private TPhThReasonRepository phThReasonRps;
	
	@RequestMapping
	public String  getResult(
			@RequestParam(value = "phthId", defaultValue = "")String phthId,
			@RequestParam(value = "ip", defaultValue = "")String ip,
			@RequestParam(value = "resultId", defaultValue = "")String resultId) {
		TPhThReason result = phThReasonRps.findByPhthIdAndIpAndResultId(phthId, ip, resultId);
		Gson gson=new Gson();
		String resultString = "no data.";
		if(result!=null)
		{
			resultString = result.getContent();
		}
		
		String resultF=gson.toJson(resultString.replace("\n", "<br>"));
		
		return	resultF;
	}
}
