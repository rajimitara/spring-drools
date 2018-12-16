package com.company.flow.workflowserv;

import com.company.flow.workflow.model.SelectedWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.flow.workflow.service.WorkflowSuggestionService;

@RestController
@RequestMapping("/workflow")
public class FlowController {
	
	@Autowired
	WorkflowSuggestionService snapWorkflowSuggestionService;
	
	@GetMapping("/welcome")
	public SelectedWorkflow welcomeToMMI2() {
		SelectedWorkflow selectedWorkflow = new SelectedWorkflow();
		snapWorkflowSuggestionService.suggestAWorkflow(selectedWorkflow);
	    return selectedWorkflow;	    	  
	    
	}


}
