package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.MonitoringTask;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n02_editingOfReferenceTasks.ReferenceTask;

/**
 * <h1>This class work with tab Tasks of SubMenu "RadioMonitoring"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabTasks.png" alt="tabTasks.png">
 * </p>
 */

public class Tasks {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Locator - Button allows you to add new task
   */
  @FindBy(xpath = "//button[text()='Добавить']")
  private Button buttonAddTask;

  /**
   * Locator - label of the "windowBookmarks of creating job radio monitoring"
   */
  @FindBy(xpath = "//span[contains(text(),'задания радиоконтроля')]")
  private WaitElement creatingMonitoringJob;

///////////////////////////////////////////////////////////////////

  /**
   * Locator - Button allows you to add new typical tasks
   */
  @FindBy(xpath = "//button[text()='Типовые задачи']")
  private ru.qa.armada.n01_workWithWebElement.webPageElements.Button buttonAddTypicalTask;

  /**
   * Locator - label of the "windowBookmarks of editing the reference book of typical tasks"
   */
  @FindBy(xpath = "//span[contains(text(),'Редактирование справочника')]")
  private WaitElement windowDirectoryEditing;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public Tasks() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver), this);
  }

////////////////////////////////////////////////////////////////////////
//endregion

  /**
   * Click button "add new Task"
   *
   * @return Main window for editing job parameters
   */
  public MonitoringTask addTask() {
    buttonAddTask.click();
    SingletonWaitingItem.waitElementVisibly(creatingMonitoringJob);
    return new MonitoringTask();
  }

  /**
   * Click button "add new Typical task"
   *
   * @return Main window for editing job parameters
   */
  public ReferenceTask addTypicalTask() {
    buttonAddTypicalTask.click();
    SingletonWaitingItem.waitElementVisibly(windowDirectoryEditing);
    return new ReferenceTask();
  }

// TODO: Need check old code on validation
/*
  public void addTask(){

    buttonAddTask.click();
    SingletonWaitingItem.waitElementVisibly(taskNameField);
    typicalTask.chooseTypicalTask();
    frequincies.addFrequency();
    equipment.addEquipment();
    safeCreateTaskRadioControl.click();
  }

  public void addTask1(){
    tabTask.click();
    SingletonWaitingItem.waitElementVisibly(labelTask);
    buttonAddTask.click();
    SingletonWaitingItem.waitElementVisibly(taskNameField);
    typicalTask.chooseTypicalTask1();

    List<List<String>> table = new ArrayList<List<String>>();
    table = headerTypicalTask.getValueRowsWithColumns();


    String tableElement1 = headerTypicalTask.getValueFromCell(1,"Наименование");
    String tableElement = headerTypicalTask.getValueFromCell(1,1);
    headerTypicalTask.clickCell(1,"Наименование");
    headerTypicalTask.clickCell(2,1);
  }
*/
}
