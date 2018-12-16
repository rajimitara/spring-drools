package com.company.flow.workflow.model;

import java.util.List;

public class WFKeywordMatchAnalysisResults {
	
	private boolean matchFound;
	private List<String> matchedKeywords;
	private String matchedWorkflowName;				
	
	public WFKeywordMatchAnalysisResults() {
		super();
	}
	
	public WFKeywordMatchAnalysisResults(boolean matchFound, List<String> matchedKeywords, String matchedWorkflowName) {
		super();
		this.matchFound = matchFound;
		this.matchedKeywords = matchedKeywords;
		this.matchedWorkflowName = matchedWorkflowName;
	}
	
	
	public boolean isMatchFound() {
		return matchFound;
	}
	public void setMatchFound(boolean matchFound) {
		this.matchFound = matchFound;
	}
	public List<String> getMatchedKeywords() {
		return matchedKeywords;
	}
	public void setMatchedKeywords(List<String> matchedKeywords) {
		this.matchedKeywords = matchedKeywords;
	}
	public String getMatchedWorkflowName() {
		return matchedWorkflowName;
	}
	public void setMatchedWorkflowName(String matchedWorkflowName) {
		this.matchedWorkflowName = matchedWorkflowName;
	}
	
	

}
