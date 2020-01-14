package life.qbic.portal.infrastructure.services.workflowtracking

import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.domain.listworkflowruns.WorkflowRunStatus
import com.vaadin.data.util.*

// Class simulating Selection of Dataset stored as List to use for View Development

class Dummydata {

    Dummydata()
    {

    }
    // Method that generates a random assortment of the given data template and returns it as an arraylist
    def datagen() {
        List<WorkflowRun> WorkflowRunList = new ArrayList<>()
        final String[] names = ["Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                                "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                                "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                                "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                                "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                                "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                                "Jaydan Jackson", "Bernard Nilsen"]

        Random ra = new Random(System.nanoTime())

        for (String name : names) {
            WorkflowRun r = new WorkflowRun()
            r.setRunName(name)
            r.setCompletedCount(ra.nextInt(10 - 0 + 1) + 0)
            r.setFailedCount(ra.nextInt(10 - 0 + 1) + 0)
            r.setRunningCount(ra.nextInt(10 - 0 + 1) + 0)
            r.setSubmittedCount(ra.nextInt(10 - 0 + 1) + 0)
            r.setRunningTaskName("TemplateTask");
            r.setStartTime(new Date());
            r.setCurrentRunStatus(WorkflowRunStatus.values()[ra.nextInt(WorkflowRunStatus.values().length)]);
            WorkflowRunList << r
        }
        return WorkflowRunList

    }
}

