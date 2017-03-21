package com.cloudwei.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cloudwei.entity.Result;
import com.cloudwei.entity.TJob;
import com.cloudwei.entity.TNode;
import com.google.common.base.Function;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LogPatrolx86Dto extends BaseDto {
	public static Function<Result, LogPatrolx86Dto> list = new Function<Result, LogPatrolx86Dto>() {
		@Override
		public LogPatrolx86Dto apply(Result result) {
			LogPatrolx86Dto dto = new LogPatrolx86Dto();
			if (result == null) {
				return dto;
			}
			dto.setId(result.getId());
			dto.setJobName(result.getJob().getName());
			dto.setIp(result.getNode().getHostName());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				dto.setResultTime(format.format(format.parse(result.getResultTime())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dto.setStatus(result.getStatus());
			return dto;
		}
	};

	public static Function<Result, LogPatrolx86Dto> detail = new Function<Result, LogPatrolx86Dto>() {
		@Override
		public LogPatrolx86Dto apply(Result result) {
			LogPatrolx86Dto dto = LogPatrolx86Dto.list.apply(result);
			if (result == null) {
				return dto;
			}
			if (result.getStatus().equalsIgnoreCase("OK")) {
				Gson gson = new Gson();
				JsonArray array = new JsonArray();
				if (result.getResultOutput() != null && !"".equals(result.getResultOutput())) {
					String[] results = result.getResultOutput().split("\n");
					if (results != null && results.length > 0) {
						for (int i = 0; i < results.length; i++) {
							JsonObject obj = new JsonObject();

							if (results[i] != null) {
								String[] contentsStrings = results[i].split("\t");
								if (contentsStrings != null && contentsStrings.length > 0) {
									obj.addProperty("date", contentsStrings[0]);
									obj.addProperty("time", contentsStrings[1]);
									obj.addProperty("eventId", contentsStrings[4]);
									obj.addProperty("eventSource", contentsStrings[5]);
									StringBuffer infoString = new StringBuffer();
									for (int j = 8; j < contentsStrings.length; j++) {
										infoString.append(contentsStrings[j]);
									}
									obj.addProperty("content",
											infoString.toString().replace("\r", "").replace("\t", ""));
								} else {
									obj.addProperty("content", results[i].replace("\r", "").replace("\t", ""));

								}
								array.add(obj);
							}
						}
					}
					dto.setResultOutput(gson.toJson(array));
					dto.setResultStatus("正常输出流");
				} else {
					dto.setResultOutput(gson.toJson(array));
					dto.setResultStatus("正常输出流");
				}
			}

			if (result.getStatus().equalsIgnoreCase("ERROR")) {

				dto.setResultError(result.getResultError());
				dto.setResultStatus("异常输出流");
			}
			return dto;
		}
	};

	private String resultStatus;
	private String resultError;
	private String resultOutput;
	private String resultTime;
	private String status;
	private TJob tJob;
	private String jobName;
	private TNode tNode;
	private String ip;
	private String account;

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getResultError() {
		return resultError;
	}

	public void setResultError(String resultError) {
		this.resultError = resultError;
	}

	public String getResultOutput() {
		return resultOutput;
	}

	public void setResultOutput(String resultOutput) {
		this.resultOutput = resultOutput;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TJob gettJob() {
		return tJob;
	}

	public void settJob(TJob tJob) {
		this.tJob = tJob;
	}

	public TNode gettNode() {
		return tNode;
	}

	public void settNode(TNode tNode) {
		this.tNode = tNode;
	}

}
