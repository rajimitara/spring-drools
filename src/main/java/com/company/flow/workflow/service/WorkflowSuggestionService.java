package com.company.flow.workflow.service;

import com.company.flow.workflow.helpers.WorkflowKeyWordMatchAnalyser;
import com.company.flow.workflow.model.SelectedWorkflow;
import com.company.flow.workflow.model.ShortlistedWorkflowsModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.flow.workflow.model.IncomingRequest;

@Service
public class WorkflowSuggestionService {
	
	@Autowired
	 private KieContainer kieShortListWFContainer;
	
	@Autowired
	 private KieContainer kieSalientWFContainer;
		
	public WorkflowSuggestionService() {
		super();
	}

	public String suggestAWorkflow(SelectedWorkflow selectedWorkflow){
		String suggestedWorkflow = null;
		
		IncomingRequest incomingRequest = new IncomingRequest("I have a ebay login issue with my account","Now");
		WorkflowKeyWordMatchAnalyser keywordMatchAnalyser = new WorkflowKeyWordMatchAnalyser();
		ShortlistedWorkflowsModel shortListedWorkflowModel = new ShortlistedWorkflowsModel();
		
		KieSession kieShortListWFSession = createKIESession(kieShortListWFContainer);
		kieShortListWFSession.setGlobal("keywordMatchAnalyser", keywordMatchAnalyser);
		//kieShortListWFSession.setGlobal("shortListedWorkflowModel",shortListedWorkflowModel);
		
		kieShortListWFSession.insert(incomingRequest);				
		System.out.println("Firing kieShortListWFSession rules now");
		
		//kieShortListWFSession.dispose();
						
        
        System.out.println("shortListedWorkflowModel.getShortlistedWorkflows(): "+shortListedWorkflowModel.getShortlistedWorkflows());              
        
        //KieSession kieSalientWFSession = createKIESession(kieSalientWFContainer);
		kieShortListWFSession.setGlobal("keywordMatchAnalyser", keywordMatchAnalyser);
		kieShortListWFSession.setGlobal("selectedWorkflow", selectedWorkflow);

		//kieShortListWFSession.insert(shortListedWorkflowModel);
		//kieShortListWFSession.insert(kieShortListWFSession);
		System.out.println("Fired kieShortListWFSession rules now: "+kieShortListWFSession.fireAllRules());

		//System.out.println("Fired kieShortListWFSession rules now: "+kieShortListWFSession.fireAllRules());
		kieShortListWFSession.dispose();
		
        System.out.println("selectedWorkflow.getSelectedWorkflowName(): "+selectedWorkflow.getSelectedWorkflowName());
		        
		return selectedWorkflow.getSelectedWorkflowName();
	}

	/**
	 * @param drlSpecificContainer
	 * @return
	 */
	private KieSession createKIESession(KieContainer drlSpecificContainer){
		return drlSpecificContainer.newKieSession();
	}
	
}
