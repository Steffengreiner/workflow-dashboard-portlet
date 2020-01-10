package life.qbic.portal.domain.listworkflowruns

// Define WorkflowRun Class containing necessary attributes for the user

class WorkflowRun {

    WorkflowRun()
    {
    }

    WorkflowRun(String runName, String runningTaskName, Date startTime, WorkflowRunStatus currentRunStatus, int submittedCount, int runningCount, int completedCount, int failedCount) {

        this.runName = runName
        this.runningTaskName = runningTaskName
        this.startTime = startTime
        this.currentRunStatus = currentRunStatus
        this.submittedCount = submittedCount
        this.runningCount = runningCount
        this.completedCount = completedCount
        this.failedCount = failedCount
    }

    String runName;
    String runningTaskName;
    Date startTime;
    WorkflowRunStatus currentRunStatus;
    int submittedCount;
    int runningCount;
    int completedCount;
    int failedCount;

    String getRunName() {
        return runName
    }

    void setRunName(String runName) {
        this.runName = runName
    }

    String getRunningTaskName() {
        return runningTaskName
    }

    void setRunningTaskName(String runningTaskName) {
        this.runningTaskName = runningTaskName
    }

    Date getStartTime() {
        return startTime
    }

    void setStartTime(Date startTime) {
        this.startTime = startTime
    }

    WorkflowRunStatus getCurrentRunStatus() {
        return currentRunStatus
    }

    void setCurrentRunStatus(WorkflowRunStatus currentRunStatus) {
        this.currentRunStatus = currentRunStatus
    }

    int getSubmittedCount() {
        return submittedCount
    }

    void setSubmittedCount(int submittedCount) {
        this.submittedCount = submittedCount
    }

    int getRunningCount() {
        return runningCount
    }

    void setRunningCount(int runningCount) {
        this.runningCount = runningCount
    }

    int getCompletedCount() {
        return completedCount
    }

    void setCompletedCount(int completedCount) {
        this.completedCount = completedCount
    }

    int getFailedCount() {
        return failedCount
    }

    void setFailedCount(int failedCount) {
        this.failedCount = failedCount
    }

}
