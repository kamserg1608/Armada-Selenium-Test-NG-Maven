package ru.qa.armada.n03_applicationStructure.n06_TasksToExternalStaff;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 *
 * <h1>This class work with SubMenu "TasksToExternalStaff"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/TasksToExternalStaff.png" alt="TasksToExternalStaff.png">
 * </p>
 * */
public class TasksToExternalStaff {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////


    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " TasksToExternalStaff " from the tree
     */
    @FindBy(xpath = "//label[text()='Задания внешнему персоналу']")
    private LabelElement labelTasksToExternalStaff;

    /////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node TasksToExternalStaff
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Задания внешнему персоналу']")
    private TabElement tabTasksToExternalStaff;
    /////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public TasksToExternalStaff() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label 'TasksToExternalStaff'
     */
    @Step("Wait of label 'TasksToExternalStaff'")
    public void labelTasksToExternalStaffWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelTasksToExternalStaff);
    }
    ////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'TasksToExternalStaff'
     */
    @Step("Wait of tab 'TasksToExternalStaff'")
    public void tabTasksToExternalStaffWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabTasksToExternalStaff);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "TasksToExternalStaff" of SubMenu "TasksToExternalStaff"
     * @return Main window for editing job parameters TasksToExternalStaff
     */
    @Step("Select page task")
    public TasksToExternalStaff selectPageTasksToExternalStaff(){
        tabTasksToExternalStaff.click();
        labelTasksToExternalStaffWait();
        WorkWithAttachment.getScreenWebdriver("TasksToExternalStaffPage");
        return new TasksToExternalStaff();
    }
////////////////////////////////////////////////////////////////////////
//endregion

}


