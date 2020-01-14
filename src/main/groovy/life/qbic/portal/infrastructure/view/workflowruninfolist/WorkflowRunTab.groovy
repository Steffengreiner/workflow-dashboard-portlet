package life.qbic.portal.infrastructure.view.workflowruninfolist


import com.vaadin.ui.Component
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet


class WorkflowRunTab
{
    TabSheet tabSheet = new TabSheet()

    WorkflowRunTab() {}

    private TabSheet generatetabs(Layout tabLayout, Component tabComponent, String tabCaption)
    {
        tabLayout.addComponent(tabComponent)
        tabComponent.setSizeFull()
        tabSheet.addTab(tabLayout).setCaption(tabCaption)
        tabSheet.setSizeFull()
        return tabSheet

    }

    }

