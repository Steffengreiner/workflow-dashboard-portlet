package life.qbic.portal.infrastructure.view.workflowruninfolist;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.renderers.ImageRenderer;
import java.util.List;
import life.qbic.portal.domain.listworkflowruns.WorkflowRun;

public class WorkflowRunListGrid {

  Grid<WorkflowRun> grid = new Grid<>();

  /* Possibility of adding all classes to Grid
 Grid<WorkflowRun> grid = new Grid<>(Workflo
   */

  public WorkflowRunListGrid() {}

  private Grid<WorkflowRun> createGrid(List workflowruns) {

    double NumberofListElements = workflowruns.size();

    if (NumberofListElements > 0) {
      // Bind Dummydata to Gridelement

      grid.setItems(workflowruns);

      // Add selected Elements from dummydata to Grid

      grid.addColumn(WorkflowRun::getRunName).setCaption("Run Name").setId("Run Name");
      grid.addColumn(WorkflowRun::getCurrentRunStatus).setCaption("Status").setId("Status");

      // Add ImageRenderer for Running Status

      Column<WorkflowRun, ThemeResource> imageColumn =
          grid.addColumn(
                  p -> new ThemeResource("img/RunningStatus/" + p.getCurrentRunStatus() + ".png"),
                  new ImageRenderer())
              .setCaption("Run Status Image")
              .setId("Run Status Image");
      grid.addColumn(WorkflowRun::getStartTime).setCaption("Start Time").setId("Start Time");
      grid.addColumn(WorkflowRun::getCompletedCount)
          .setCaption("Completed Count")
          .setId("Completed Count");
      grid.addColumn(WorkflowRun::getRunningCount)
          .setCaption("Running Count")
          .setId("Running Count");
      grid.addColumn(WorkflowRun::getSubmittedCount)
          .setCaption("Submitted Count")
          .setId("Submitted Count");
      grid.addColumn(WorkflowRun::getFailedCount).setCaption("Failed Count").setId("Failed Count");

      // set dimensions of grid

      grid.setWidth("100%");
      grid.setHeight("100%");
      //grid.setHeightbyRows(NumberofListElements);


      return grid;
    }
    else {

      return null;

    }
  }
}
