package life.qbic.portal.portlet.usecases.RetrieveAllRunInfo

import life.qbic.datamodel.workflows.RunInfo

interface RunInfoDataInterface {

    List<RunInfo> requestListOfWorkflowRunInfo()
}