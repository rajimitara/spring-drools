package com.company.flow.workflow.model;

public class SelectedWorkflow {
	
	private String selectedWorkflowName;
	
	public SelectedWorkflow() {}

	public SelectedWorkflow(String selectedWorkflowName) {
		super();
		this.selectedWorkflowName = selectedWorkflowName;
	}

	public String getSelectedWorkflowName() {
		return selectedWorkflowName;
	}

	public void setSelectedWorkflowName(String selectedWorkflowName) {
		this.selectedWorkflowName = selectedWorkflowName;
	}
	
	

}
