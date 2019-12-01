package ru.qa.armada.n03_applicationStructure.n08_Administration;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n01_TechnicalEvents.TechnicalEvents;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n02_SysLog.SysLog;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n03_AuthorizationLog.AuthorizationLog;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n04_Roles.Roles;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n05_StateOfCommunicationChannels.StateOfCommunicationChannels;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n06_Nodes.Nodes;
import ru.qa.armada.n03_applicationStructure.n08_Administration.n07_ReportTemplates.ReportTemplates;

/**
 *
 * <h1>This class work with SubMenu "Administration"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/Administration.png" alt="Administration.png">
 * </p>
 * */
public class Administration {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

    //region elementDefinitionTabs
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Submenu "TechnicalEvents" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Технические события']")
    private TabElement tabTechnicalEvents;

    /**
     * Locator - Submenu "SysLog" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Системный журнал']")
    private TabElement tabSysLog;

    /**
     * Locator - Submenu " AuthorizationLog " in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Журнал авторизации']")
    private TabElement tabAuthorizationLog;

    /**
     * Locator - Submenu " Roles " in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Роли']")
    private TabElement tabRoles;

    /**
     * Locator - Submenu "StateOfCommunicationChannels" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Состояние каналов связи']")
    private TabElement tabStateOfCommunicationChannels;

    /**
     * Locator - Submenu "Nodes" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Узлы']")
    private TabElement tabNodes;

    /**
     * Locator - Submenu "ReportTemplates" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Шаблоны отчётов']")
    private TabElement tabReportTemplates;

/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the "TechnicalEvents" from the tree
     */
    @FindBy(xpath = "//label[text()='Технические события']")
    private LabelElement labelTechnicalEvents;

    /**
     * Locator - Central label of the selected submenu of the "SysLog" from the tree
     */
    @FindBy(xpath = "//label[text()='Системный журнал']")
    private LabelElement labelSysLog;

    /**
     * Locator - Central label of the selected submenu of the " AuthorizationLog " from the tree
     */
    @FindBy(xpath = "//label[text()='Журнал авторизации']")
    private LabelElement labelAuthorizationLog;

    /**
     * Locator - Central label of the selected submenu of the " Roles " from the tree
     */
    @FindBy(xpath = "//label[text()='Роли']")
    private LabelElement labelRoles;

    /**
     * Locator - Central label of the selected submenu of the "StateOfCommunicationChannels" from the tree
     */
    @FindBy(xpath = "//label[text()='Состояние каналов связи']")
    private LabelElement labelStateOfCommunicationChannels;

    /**
     * Locator - Central label of the selected submenu of the "Nodes" from the tree
     */
    @FindBy(xpath = "//label[text()='Узлы']")

    private LabelElement labelNodes;
    /**
     * Locator - Submenu "ReportTemplates" in the tree in the Administration section
     */
    @FindBy(xpath = "//span[text()='Шаблоны отчётов']")
    private LabelElement labelReportTemplates;
/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node Administration
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Администрирование']")
    private TabElement tabAdministration;

    /**
     * Locator - node Administration
     */
    @FindBy(xpath = "//div[@class='x-tree3-node-ct x-tree3 x-component x-unselectable']//td/div[8]/div[2]")
    private TabElement StateOFViewAllTabAdministration;
/////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public Administration() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label ' TechnicalEvents '
     */
    @Step("Wait of label ' TechnicalEvents '")
    public void labelTechnicalEventsWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelTechnicalEvents);
    }
    /**
     * Wait of label 'SysLog'
     */
    @Step("Wait of label 'SysLog'")
    public void labelSysLogWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelSysLog);
    }
    /**
     * Wait of label 'AuthorizationLog'
     */
    @Step("Wait of label 'AuthorizationLog'")
    public void labelAuthorizationLogWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelAuthorizationLog);
    }
    /**
     * Wait of label 'Roles'
     */
    @Step("Wait of label ' Roles '")
    public void labelRolesWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelRoles);
    }
    /**
     * Wait of label ' StateOfCommunicationChannels '
     */
    @Step("Wait of label ' StateOfCommunicationChannels '")
    public void labelStateOfCommunicationChannelsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelStateOfCommunicationChannels);
    }
    /**
     * Wait of label ' Nodes '
     */
    @Step("Wait of label ' Nodes '")
    public void labelNodesWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelNodes);
    }
    /**
     * Wait of label '  ReportTemplates  '
     */
    @Step("Wait of label '  ReportTemplates  '")
    public void labelReportTemplatesWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelReportTemplates);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab ' TechnicalEvents '
     */
    @Step("Wait of tab 'TechnicalEvents '")
    public void tabTechnicalEventsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabTechnicalEvents);
    }
    /**
     * Wait of tab ' SysLog '
     */
    @Step("Wait of tab ' SysLog '")
    public void tabSysLogWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabSysLog);
    }
    /**
     * Wait of tab 'AuthorizationLog'
     */
    @Step("Wait of tab 'AuthorizationLog'")
    public void tabAuthorizationLogWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabAuthorizationLog);
    }
    /**
     * Wait of tab 'Roles'
     */
    @Step("Wait of tab 'Roles'")
    public void tabRolesWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabRoles);
    }
    /**
     * Wait of tab ' StateOfCommunicationChannels '
     */
    @Step("Wait of tab ' StateOfCommunicationChannels '")
    public void tabStateOfCommunicationChannelsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabStateOfCommunicationChannels);
    }
    /**
     * Wait of tab ' Nodes '
     */
    @Step("Wait of tab ' Nodes '")
    public void tabNodesWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabNodes);
    }
    /**
     * Wait of tab ' ReportTemplates '
     */
    @Step("Wait of tab ' ReportTemplates '")
    public void tabReportTemplatesWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabReportTemplates);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "TechnicalEvents" of SubMenu "Administration"
     * @return Main window for editing job parameters TechnicalEvents
     */
    @Step("Select page TechnicalEvents ")
    public TechnicalEvents selectPageTechnicalEvents(){
        tabTechnicalEvents.click();
        labelTechnicalEventsWait();
        WorkWithAttachment.getScreenWebdriver("TechnicalEventsPage");
        return new TechnicalEvents();
    }

    /**
     * Select Tab "SysLog" of SubMenu "Administration"
     * @return Main window for editing job parameters SysLog
     */
    @Step("Select page SysLog ")
    public SysLog selectPageSysLog(){
        tabSysLog.click();
        labelSysLogWait();
        WorkWithAttachment.getScreenWebdriver("SysLogPage");
        return new SysLog();
    }

    /**
     * Select Tab "AuthorizationLog" of SubMenu "Administration"
     * @return Main window for editing job parameters AuthorizationLog
     */
    @Step("Select page AuthorizationLog")
    public AuthorizationLog selectPageAuthorizationLog(){
        tabAuthorizationLog.click();
        labelAuthorizationLogWait();
        WorkWithAttachment.getScreenWebdriver("AuthorizationLogPage");
        return new AuthorizationLog();
    }

    /**
     * Select Tab "Roles" of SubMenu "Administration"
     * @return Main window for editing job parameters Roles
     */
    @Step("Select page Roles")
    public Roles selectPageRoles(){
        tabRoles.click();
        labelRolesWait();
        WorkWithAttachment.getScreenWebdriver("RolesPage");
        return new Roles();
    }

    /**
     * Select Tab "StateOfCommunicationChannels" of SubMenu "Administration"
     * @return Main window for editing job parameters StateOfCommunicationChannels
     */
    @Step("Select page StateOfCommunicationChannels ")
    public StateOfCommunicationChannels selectPageStateOfCommunicationChannels(){
        tabStateOfCommunicationChannels.click();
        labelStateOfCommunicationChannelsWait();
        WorkWithAttachment.getScreenWebdriver("StateOfCommunicationChannelsPage");
        return new StateOfCommunicationChannels();
    }

    /**
     * Select Tab "Nodes" of SubMenu "Administration"
     * @return Main window for editing job parameters Nodes
     */
    @Step("Select page Nodes")
    public Nodes selectPageNodes(){
        tabNodes.click();
        labelNodesWait();
        WorkWithAttachment.getScreenWebdriver("NodesPage");
        return new Nodes();
    }

    /**
     * Select Tab "ReportTemplates" of SubMenu "Administration"
     * @return Main window for editing job parameters ReportTemplates
     */
    @Step("Select page ReportTemplates")
    public ReportTemplates selectPageReportTemplates(){
        tabReportTemplates.click();
        labelReportTemplatesWait();
        WorkWithAttachment.getScreenWebdriver("ReportTemplatesPage");
        return new ReportTemplates();
    }

////////////////////////////////////////////////////////////////////////
//endregion

    /**
     * Select Tab Administration
     * @return Main window for editing job parameters Administration
     */
    @Step("Open Tab Administration")
    public Administration openTabAdministration(){
        String str1 = StateOFViewAllTabAdministration.getWebElement().getAttribute("style");
        String str2 = "display: none";

        boolean result = str1.contains(str2);
        if(result){
            tabAdministration.dbclick();
        }

        tabTechnicalEventsWait();
        tabSysLogWait();
        tabAuthorizationLogWait();
        tabRolesWait();
        tabStateOfCommunicationChannelsWait();
        tabRolesWait();
        tabStateOfCommunicationChannelsWait();
        tabNodesWait();
        tabTechnicalEventsWait();

        return new Administration();
    }

}

