package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.AccordionElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TableWebElement;import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
/**
 * <h1>This class work with "Creating a typical monitoring task"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p><b> The first way to the window </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/CreatingTypicalMonitoringTask_1.png" alt="CreatingTypicalMonitoringTask_1.png">
 * </p>
 * <p><b> The second way to the window </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/CreatingTypicalMonitoringTask_2.png" alt="CreatingTypicalMonitoringTask_2.png">
 * </p>
 *
 */
public class CreatingTypicalMonitoringTask {
    private Logger logger;


//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Locator - label of window "Creating a typical monitoring task"
     */
    @FindBy(xpath = "//span[contains(text(),'Создание      типовой задачи радиоконтроля')]")
    private TableWebElement tableTypicalTasks;

    /**
     * Locator - accordion active part"
     */
    @FindBy(xpath = "//span[contains(text(),'змерение параметров сигналов')]/./parent::div//td//div")
    private AccordionElement measurementOfSignalParameters;

    /**
     * Locator - accordion active part"
     */
    @FindBy(xpath = "//span[contains(text(),'Анализ БС')]/./parent::div//td//div")
    private AccordionElement analysisBS;

    /**
     * Locator - accordion active part"
     */
    @FindBy(xpath = "//span[contains(text(),'Занятость частотных каналов')]/./parent::div//td//div")
    private AccordionElement frequencyChannelEmployment;
/////////////////////////////////////////////////////////////////
//endregion


//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */
    public CreatingTypicalMonitoringTask() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
        this.logger = LoggerFactory.getLogger(CreatingTypicalMonitoringTask.class);
    }

/////////////////////////////////////////////////////////////////
//endregion
    public void accordionDisclosure(){
//        measurementOfSignalParameters.click();
//        analysisBS.click();
//        frequencyChannelEmployment.click();
    }

}
