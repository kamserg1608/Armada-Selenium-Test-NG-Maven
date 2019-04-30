package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n01_typicalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TextField;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;


/**
 * <h1>This class work with tab "Typical task" of window "creating a monitoring job"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../../../src/test/resources/doc-files/TypicalTask.png" alt="альтернативный текст">
 * </p>
 */

public class TypicalTask {
  /**
   * delegating class used in {@link TypicalTaskSelection} method
   */
  private TypicalTaskSelection typicalTaskSelection;

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Locator - Tab typical task of the  windowBookmarks "monitoring task creation"
   */
  @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Типовая задача']")
  private TabElement tabTask;

  /**
   * Locator - Fields for entering the name of the task
   */
  @FindBy(xpath = "//input[@id='testid_name_typical_task_RcTaskDialog-input']")
  private TextField taskNameField;

  /**
   * Locator - Button safe task entirely
   */
  @FindBy(xpath = "//table[@id='OK-RcTaskDialog']//button[text()='Сохранить']")
  private Button safeCreateTaskRadioControl;

/////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Locator - Typical task selection button
   */
  @FindBy(xpath = "//table[@id='testid_select_commonTaskDialogSelectorField_RcTaskDialog']//td[@class='x-btn-mc']//button")
  private Button openSampleTasks;

  /**
   * Locator - label of windowBookmarks "typical task selection"
   */
  @FindBy(xpath = "//span[text()='Выбор типовой задачи']")
  private WaitElement taskSelectionPanel;

  /**
   * Locator - Control label "group of measurement types" of windowBookmarks "typical task selection"
   * WaitElement
   */
  private By groupMeasurementType = By.xpath("//span[contains(text(), 'Группа типов измерений')]");
///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public TypicalTask() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver), this);
    this.typicalTaskSelection = new TypicalTaskSelection();
  }
///////////////////////////////////////////////////////////////////////
//endregion

  /**
   * activation Tab TypicalTask
   */
  public void activateTabTask() {
    tabTask.click();
  }

  /**
   * set name into field "Name"
   *
   * @param name Input name Task
   */
  public void setNameTask(String name) {
    taskNameField.setText(name);
  }

  /**
   * integrated function establishing standard tasks.
   *
   * <h3>Uses the following functions.</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #setNameTask(String nameTask) } method.</li>
   *     <li> Use the {@link TypicalTaskSelection#selectTask()} method. </li>
   *   </ul>
   * </div>
   */
  public void chooseTypicalTask() {
    setNameTask("AZAZ");
    openSampleTasks.click();
    SingletonWaitingItem.waitElementVisibly(taskSelectionPanel);
    SingletonWaitingItem.presenceOfElementLocated(groupMeasurementType);

//    TypicalTaskSelection typicalTaskSelection = new TypicalTaskSelection();
    typicalTaskSelection.selectTask();
  }

  /**
   * This method does not use
   *
   * @deprecated Use in first example code
   */
  @Deprecated
  public void chooseTypicalTask1() {
    setNameTask("AZAZ");
    openSampleTasks.click();
  }
}
