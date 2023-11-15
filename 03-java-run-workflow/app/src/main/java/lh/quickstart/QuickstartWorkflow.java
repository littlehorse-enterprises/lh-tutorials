package lh.quickstart;

import io.littlehorse.sdk.common.proto.IndexType;
import io.littlehorse.sdk.common.proto.VariableType;
import io.littlehorse.sdk.wfsdk.WfRunVariable;
import io.littlehorse.sdk.wfsdk.Workflow;
import io.littlehorse.sdk.wfsdk.WorkflowThread;

/**
 * The QuickstartWorkflow class defines the workflow for the Quickstart application.
 * It includes the steps and tasks that are part of the workflow.
 */
public class QuickstartWorkflow {

    // Constants representing the workflow name and the task name
    public static final String WF_Name = "quickstart";
    public static final String GREET = "greet";

    /**
     * Defines the logic of the 'quickstart' workflow.
     * @param wf The workflow thread used to define the workflow steps.
     */
    public void quickstartWf(WorkflowThread wf) {
        // Create and set up an input variable for the workflow
        WfRunVariable name = wf.addVariable("input-name", VariableType.STR);
        // Enable searching for workflows based on the value of the 'input-name' variable
        // and make it persistent in the workflow's database
        name.withIndex(IndexType.REMOTE_INDEX).persistent();
        // Execute the 'greet' task using the 'name' variable
        wf.execute(GREET, name);
    }

    /**
     * Creates and returns a new Workflow object for the 'quickstart' workflow.
     * @return A Workflow object representing the defined workflow.
     */
    public Workflow getWorkflow() {
        // Construct and return a new workflow using the defined workflow logic
        return Workflow.newWorkflow(WF_Name, this::quickstartWf);
    }
}
