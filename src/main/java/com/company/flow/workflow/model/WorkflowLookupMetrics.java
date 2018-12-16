package com.company.flow.workflow.model;

import java.util.List;

public class WorkflowLookupMetrics {

    private String workflowName;
    private List<String> workflowKeywords;
    //private int workflowSalience;


    public WorkflowLookupMetrics(String workflowName, List<String> workflowKeywords) {
        super();
        this.workflowName = workflowName;
        this.workflowKeywords = workflowKeywords;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public List<String> getWorkflowKeywords() {
        return workflowKeywords;
    }

    public void setWorkflowKeywords(List<String> workflowKeywords) {
        this.workflowKeywords = workflowKeywords;
    }


}
