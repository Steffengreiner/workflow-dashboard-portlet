package life.qbic.portal.portlet.usecases.RetrieveAllRunInfo

import life.qbic.datamodel.workflows.RunInfo

class RetrieveAllRunInfo {

    RunInfoDataSourceInterface runInfoDataSource
    RetrieveAllRunInfoOutputBoundary retrieveAllRunInfoOutputBoundary

    RetrieveAllRunInfo(RunInfoDataSourceInterface runInfoDataSource, RetrieveAllRunInfoOutputBoundary retrieveAllRunInfoOutputBoundary) {
        this.runInfoDataSource = runInfoDataSource
        this.retrieveAllRunInfoOutputBoundary = retrieveAllRunInfoOutputBoundary
    }

    def execute() {
        def workflowRunInfoList = this.runInfoDataSource.requestListOfWorkflowRunInfo()
        if (isWorkflowRunInfoListValid(workflowRunInfoList)) {
            this.retrieveAllRunInfoOutputBoundary.receiveRunInfoList(workflowRunInfoList)
        }

    }

    private static boolean isWorkflowRunInfoListValid(List<RunInfo> workflowRunInfoList) {
        if (workflowRunInfoList.size() > 0) {
            return workflowRunInfoList.every { runInfo ->
                (runInfo.hasProperty('runName') && runInfo.hasProperty('runStatus') && runInfo.hasProperty('runId'))
            }
        }
        return false
    }
}
