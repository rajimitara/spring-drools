package com.company.flow.workflow.model;

public class IncomingRequest {

	private String summary;
	private String description;
			
	public IncomingRequest(String summary, String description) {
		super();
		this.summary = summary;
		this.description = description;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
