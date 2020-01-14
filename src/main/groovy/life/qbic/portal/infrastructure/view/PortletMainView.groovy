package life.qbic.portal.infrastructure.view

import com.vaadin.ui.Grid
import com.vaadin.ui.Layout
import com.vaadin.ui.ListSelect
import com.vaadin.ui.TabSheet
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.HorizontalLayout
import life.qbic.portal.infrastructure.services.workflowtracking.Dummydata
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunInfoListViewModelObserver
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunListGrid
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunTab


class PortletMainView extends VerticalLayout implements WorkflowRunInfoListViewModelObserver, Layout {


    PortletMainView() {

        super()
        createContent()

    }

    /*Current Status is to Just Run all Commands in Portlet Main View for Testing,
    this will change in further development */

    private createContent() {

        //Dummy Components to Test Layout

        TextField labelField = new TextField()
        labelField.setValue("Value")

        // "Read in" (Dummy) Data from Database

        Dummydata Dummydatamaker = new Dummydata()
        List dummydata = Dummydatamaker.datagen()

        List namelist = []
        for (item in dummydata){
            namelist.add(item.getRunName())
        }
        // List all Names from Object as a Test if Data was read in successfully

        ListSelect<String> select = new ListSelect<>("The List")
        select.setItems(namelist)
        select.setRows(20)

        // Create Grid as Table for WorkflowDashboard

        WorkflowRunListGrid Gridmaker = new WorkflowRunListGrid()
        Grid grid = Gridmaker.createGrid(dummydata)

        // Create Layouts to put the individual elements into

        VerticalLayout tablayout1 = new VerticalLayout()
        VerticalLayout tablayout2 = new VerticalLayout()
        HorizontalLayout tablayout3 = new HorizontalLayout();

        //Create Tabsheet to store each Layout and switch between layouts

        WorkflowRunTab tabsheetmaker = new WorkflowRunTab()

        // Add elements to Tabsheet

        TabSheet tabsheet = tabsheetmaker.generatetabs(tablayout1, grid, "WorkflowBoard")
        tabsheetmaker.generatetabs(tablayout2, select, "Names")
        tabsheetmaker.generatetabs(tablayout3, labelField, "Template")

        this.addComponent(tabsheet)

    }

}




