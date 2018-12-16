package com.company.flow.workflow.model;

import org.kie.api.definition.type.Modifies;
import org.kie.api.definition.type.PropertyReactive;

import java.util.HashSet;

@PropertyReactive
public class ShortlistedWorkflowsModel {
	
	HashSet<String> shortlistedWorkflows;
	boolean salienceRequestMatched;

	public ShortlistedWorkflowsModel() {
		super();
	}		

	public boolean isSalienceRequestMatched() {
		return salienceRequestMatched;
	}

	public void setSalienceRequestMatched(boolean salienceRequestmatched) {
		this.salienceRequestMatched = salienceRequestmatched;
	}

	public ShortlistedWorkflowsModel(HashSet<String> shortlistedWorkflows) {
		super();
		this.shortlistedWorkflows = shortlistedWorkflows;
	}

	public HashSet<String> getShortlistedWorkflows() {
		return shortlistedWorkflows;
	}

	@Modifies( { "shortlistedWorkflows" } )
	public void setShortlistedWorkflows(HashSet<String> shortlistedWorkflows) {
		this.shortlistedWorkflows = shortlistedWorkflows;
	}		

}
