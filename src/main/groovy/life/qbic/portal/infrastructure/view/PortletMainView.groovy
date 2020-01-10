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

        TextField labelField2 = new TextField()
        labelField.setValue("Value2")

        // "Read in" (Dummy) Data from Database

        Dummydata Dummydatamaker = new Dummydata()
        List dummydata = Dummydatamaker.datagen()

        // List to test if dummy data was imported

        List namelist = []
        for (item in dummydata){
            namelist.add(item.getRunName())
        }

        ListSelect<String> select = new ListSelect<>("The List")
        select.setItems(namelist)
        select.setRows(5)
        this.addComponent(select)

        VerticalLayout tablayout1 = new VerticalLayout()
        WorkflowRunTab tabsheetmaker = new WorkflowRunTab()
        HorizontalLayout tablayout2 = new HorizontalLayout();

        WorkflowRunListGrid Gridmaker = new WorkflowRunListGrid()
        Grid grid = Gridmaker.createGrid(dummydata)

        // Add Grid to Layout
        //this.addComponent(grid)

        TabSheet tabsheet = tabsheetmaker.generatetabs(tablayout2, grid, "WorkflowBoard")
        tabsheetmaker.generatetabs(tablayout1, labelField, "Details")

        this.addComponent(tabsheet)





    }

}




