package com.company.flow.workflow.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.company.flow.workflow.model.ShortlistedWorkflowsModel;
import com.company.flow.workflow.model.WorkflowLookupMetrics;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.company.flow.workflow.model.WFKeywordMatchAnalysisResults;

public class WorkflowKeyWordMatchAnalyser {
	
	private static final String DEFAULT_WF = "DEFAULT_WF";
	public static Map<String,WorkflowLookupMetrics> workflowAttributesMap;
	
	
	/**
	 * @param summaryOrDescription
	 * @return
	 */
	public List<WFKeywordMatchAnalysisResults> pullAllEligibleWorkflowMetrics(String summaryOrDescription){
		List<WFKeywordMatchAnalysisResults> keywordMatchResultSet = new ArrayList<WFKeywordMatchAnalysisResults>();				
		
		initialiseWorkflowAttributes();
		
		for (Map.Entry<String,WorkflowLookupMetrics> eachWorkflowMapEntry : workflowAttributesMap.entrySet()) {
			String workflowName = eachWorkflowMapEntry.getKey();
			WorkflowLookupMetrics eachWorkflowMetrics = eachWorkflowMapEntry.getValue();
			
			List<String> setOfKeywords = eachWorkflowMetrics.getWorkflowKeywords();
			
			for(String eachKeyWordFromWorkflow : setOfKeywords){
				System.out.println("eachKeyWordFromWorkflow: ["+eachKeyWordFromWorkflow+"]");				
				
				if(StringUtils.containsIgnoreCase(summaryOrDescription, eachKeyWordFromWorkflow)){
										
					System.out.println("if(StringUtils.containsIgnoreCase: "+eachKeyWordFromWorkflow);
					List<String> matchedKeywords = new ArrayList<String>();
					matchedKeywords.add(eachKeyWordFromWorkflow);
					
					WFKeywordMatchAnalysisResults keywordMatchResults = new WFKeywordMatchAnalysisResults();
					keywordMatchResults.setMatchedWorkflowName(workflowName);
					keywordMatchResults.setMatchFound(true);
					keywordMatchResults.setMatchedKeywords(matchedKeywords);
					
					keywordMatchResultSet.add(keywordMatchResults);
				}
			}						
		
	    }				
		
		return keywordMatchResultSet;
	}
	
	/**
	 * @param summaryOrDescription
	 * @return
	 */
	public ShortlistedWorkflowsModel analyseKeywordMatchCriteria(String summaryOrDescription){
		
		System.out.println("pullAllEligibleWorkflowMetrics(summaryOrDescription): "+pullAllEligibleWorkflowMetrics(summaryOrDescription));
		System.out.println("pullAllShortListedWorkflowNames: ");
		ShortlistedWorkflowsModel ShortlistedWorkflowsModel = new ShortlistedWorkflowsModel(pullAllShortListedWorkflowNames(pullAllEligibleWorkflowMetrics(summaryOrDescription)));
		return ShortlistedWorkflowsModel;
	}
	
	/**
	 * @param keywordMatchResultSet
	 * @return
	 */
	public HashSet<String> pullAllShortListedWorkflowNames(List<WFKeywordMatchAnalysisResults> keywordMatchResultSet){
		
		HashSet<String> shortListedWorkflows = new HashSet<String>(); 
		
		for(WFKeywordMatchAnalysisResults eachKeyWordMatchResult : keywordMatchResultSet){
			shortListedWorkflows.add(eachKeyWordMatchResult.getMatchedWorkflowName());
		}
		
		System.out.println("shortListedWorkflows size: "+shortListedWorkflows.size());
		
		return shortListedWorkflows;
		
	}
	

	
	/**
	 * @param shortListedWorkflows
	 * @param requestedWorkflow
	 * @return
	 */
	public ShortlistedWorkflowsModel validateIfWorkflowExists(HashSet<String> shortListedWorkflows, String requestedWorkflow){
		
		boolean salienceRequestMatched = false;
		ShortlistedWorkflowsModel finalisedWorkflowsModel = new ShortlistedWorkflowsModel();
		
		System.out.println("CollectionUtils.isNotEmpty(shortListedWorkflows): "+CollectionUtils.isNotEmpty(shortListedWorkflows));
		
		if(CollectionUtils.isNotEmpty(shortListedWorkflows)){
			System.out.println("1shortListedWorkflows: "+shortListedWorkflows.size());
				
				if(shortListedWorkflows.contains(requestedWorkflow))
					salienceRequestMatched = true;
		}
		
		finalisedWorkflowsModel.setSalienceRequestMatched(salienceRequestMatched);
		
		
		
		return finalisedWorkflowsModel;
		
		
	}
	
	/**
	 * @param summaryOrDescription
	 * @return
	 */
	public String iterateAndIdentifyKeywordMatch(String summaryOrDescription){
		
		initialiseWorkflowAttributes();
		
		String matchedWorkflowByKeyWord = DEFAULT_WF;
		
		System.out.println("summaryOrDescription: "+summaryOrDescription);
		
		for (Map.Entry<String,WorkflowLookupMetrics> eachWorkflowMapEntry : workflowAttributesMap.entrySet()) {
			String workflowName = eachWorkflowMapEntry.getKey();
			WorkflowLookupMetrics eachWorkflowMetrics = eachWorkflowMapEntry.getValue();
			
			List<String> setOfKeywords = eachWorkflowMetrics.getWorkflowKeywords();
			
			for(String eachKeyWordFromWorkflow : setOfKeywords){
				System.out.println("eachKeyWordFromWorkflow:"+eachKeyWordFromWorkflow);				
				if(StringUtils.containsIgnoreCase(summaryOrDescription, eachKeyWordFromWorkflow)){
					
					System.out.println("if(StringUtils.containsIgnoreCase");
					matchedWorkflowByKeyWord = workflowName;
					return matchedWorkflowByKeyWord;
				}
			}						
		
	    }				
		
		
		return matchedWorkflowByKeyWord;
	}
	
	
	private void initialiseWorkflowAttributes(){
		List<String> wfKeyWords = new ArrayList<String>();
		
		wfKeyWords.add("Keyword1");
		
		List<String> wfKeyWords2 = new ArrayList<String>();
		
		wfKeyWords2.add("Keyword2");
		
		List<String> wfKeyWords3 = new ArrayList<String>();
		
		wfKeyWords3.add("ebay");
		
		List<String> wfKeyWords4 = new ArrayList<String>();
		
		wfKeyWords4.add("login");
		
		System.out.println("initialiseWorkflowAttributes() triggered");
				
		workflowAttributesMap = new HashMap<String,WorkflowLookupMetrics>();
		
		workflowAttributesMap.put("SNAP_WF_1",new WorkflowLookupMetrics("SNAP_WF_1",wfKeyWords));
		workflowAttributesMap.put("SNAP_WF_2",new WorkflowLookupMetrics("SNAP_WF_2",wfKeyWords2));
		workflowAttributesMap.put("EBAY_WF",new WorkflowLookupMetrics("EBAY_WF",wfKeyWords3));
		workflowAttributesMap.put("LOGIN_WF",new WorkflowLookupMetrics("LOGIN_WF",wfKeyWords4));
		
	
	} 


}
