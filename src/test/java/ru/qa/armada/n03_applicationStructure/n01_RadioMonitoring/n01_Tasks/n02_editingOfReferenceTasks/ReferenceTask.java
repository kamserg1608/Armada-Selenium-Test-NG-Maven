package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TableWebElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with "editing of reference tasks"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/ReferenceTask.png" alt="ReferenceTask.png">
 * </p>
 */

public class ReferenceTask {
    private Logger logger;

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Locator - label of window "Editing reference manual"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]")
    private TableWebElement tableTypicalTasks;

    /**
     * Locator - label of window "Editing reference manual"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]")
    private WaitElement windowTitle;

    /**
     * Locator - button "Create"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]/./ancestor::div[@tabindex='0']//button[contains(text(),'Создать')]")
    private Button buttonCreate;

    /**
     * Locator - button "Open"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]/./ancestor::div[@tabindex='0']//button[contains(text(),'Открыть')]")
    private Button buttonOpen;

    /**
     * Locator - button "Delete"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]/./ancestor::div[@tabindex='0']//button[contains(text(),'Удалить')]")
    private Button buttonDelete;

    /**
     * Locator - button "Close"
     */
    @FindBy(xpath = "//span[ contains(text(),'Редактирование справочника типовых')]/./ancestor::div[@tabindex='0']//button[contains(text(),'Удалить')]")
    private Button buttonClose;

    /**
     * Locator - button "Refresh"
     */
    @FindBy(xpath = "(//span[ contains(text(),'Редактирование справочника типовых')]/./ancestor::div[@tabindex='0']//button)[4]")
    private Button buttonRefresh;
/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

    /**
     * Initializes webElement Use Annotation @FindBy
     */
    public ReferenceTask() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
        this.logger = LoggerFactory.getLogger(ReferenceTask.class);
    }

/////////////////////////////////////////////////////////////////
//endregion

    public void clickCreateTypicaTask(){
        buttonCreate.click();
    }

    public void deleteTypicalTask(String objectSelect){
        tableTypicalTasks.clickCell(objectSelect);
        buttonDelete.click();
    }

    public void openTypicalTask(String objectSelect){
        tableTypicalTasks.clickCell(objectSelect);
        buttonOpen.click();
    }

    public boolean checkExistTypicalTask(String objectSelect){
        return tableTypicalTasks.checkValueInTheTable(objectSelect);
    }

}
