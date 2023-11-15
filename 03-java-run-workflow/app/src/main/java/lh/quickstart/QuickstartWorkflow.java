package lh.quickstart;

import io.littlehorse.sdk.common.proto.IndexType;
import io.littlehorse.sdk.common.proto.VariableType;
import io.littlehorse.sdk.wfsdk.WfRunVariable;
import io.littlehorse.sdk.wfsdk.Workflow;
import io.littlehorse.sdk.wfsdk.WorkflowThread;

public class QuickstartWorkflow {

    public static final String WF_Name = "quickstart";
    public static final String GREET = "greet";

    public void quickstartWf(WorkflowThread wf){

        WfRunVariable name = wf.addVariable("input-name", VariableType.STR);
        name.withIndex(IndexType.REMOTE_INDEX).persistent();
        wf.execute(GREET, name);

}
    public Workflow getWorkflow(){
        return Workflow.newWorkflow(WF_Name, this::quickstartWf);
    }

}
