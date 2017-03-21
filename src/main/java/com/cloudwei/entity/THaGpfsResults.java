package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="T_Ha_Gpfs_RESULT")
public class THaGpfsResults extends BaseEntity {

	@Column(name="THaGpfsResults_SET_ID")
	private long tHagpfsResultsSetId;
	
	@Column(name="THaGpfsResults_TASK_ID")
	private long tHaGpfsResultsTaskId;
	
	@Column(name="THaGpfsResults_RESULT")
	private String tHaGpfsResultsResult;
	
	@Column(name="THaGpfsResults_SHOWVALUE")
	private String tHaGpfsResultsShowvalue;

	public long gettHagpfsResultsSetId() {
		return tHagpfsResultsSetId;
	}

	public void settHagpfsResultsSetId(long tHagpfsResultsSetId) {
		this.tHagpfsResultsSetId = tHagpfsResultsSetId;
	}

	public long gettHaGpfsResultsTaskId() {
		return tHaGpfsResultsTaskId;
	}

	public void settHaGpfsResultsTaskId(long tHaGpfsResultsTaskId) {
		this.tHaGpfsResultsTaskId = tHaGpfsResultsTaskId;
	}

	public String gettHaGpfsResultsResult() {
		return tHaGpfsResultsResult;
	}

	public void settHaGpfsResultsResult(String tHaGpfsResultsResult) {
		this.tHaGpfsResultsResult = tHaGpfsResultsResult;
	}

	public String gettHaGpfsResultsShowvalue() {
		return tHaGpfsResultsShowvalue;
	}

	public void settHaGpfsResultsShowvalue(String tHaGpfsResultsShowvalue) {
		this.tHaGpfsResultsShowvalue = tHaGpfsResultsShowvalue;
	}
	

}
