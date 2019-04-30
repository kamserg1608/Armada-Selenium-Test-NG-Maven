package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n01_typicalTask.TypicalTask;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n02_frequincies.Frequencies;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n03_equipment.Equipment;


/**
 * <h1>This class work with "creating a monitoring job"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/MonitoringTask.png" alt="альтернативный текст">
 * </p>
 */

public class MonitoringTask {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Locator - Tab select a typical task of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//span[contains(text(), 'задания радиоконтроля')]//ancestor::div[@tabindex='0']//span[contains(text(), 'Типовая зада')]")
  private TabElement headerTypicalTask;

  /**
   * Locator - label of Note
   */
  @FindBy(xpath = "//label[contains(text(),'Примечание')]")
  private WaitElement labelNote;

/////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Locator - Tab select a frequency of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//span[contains(text(), 'задания радиоконтроля')]//ancestor::div[@tabindex='0']//span[contains(text(),'Частоты')]")
  private TabElement headerFrequencies;

  /**
   * Locator - label of Spectroscope
   */
  @FindBy(xpath = "//label[contains(text(), 'Спектроскоп')]")
  private WaitElement labelSpectroscope;
/////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Locator - Tab select a frequency of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//span[@class='x-tree3-node-text' and contains(text(),'Оборудование')]")
  private TabElement headerEquipment;

  /**
   * Locator - label of Number of factory
   */
  @FindBy(xpath = "//span[@class=' x-component' and contains(text(),'Заводской номер')]")
  private WaitElement labelFactoryNumber;

/////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Locator - Button to save the monitoring task of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//table[@id='OK-RcTaskDialog']//button[text()='Сохранить']")
  private Button safeCreateTaskRadioControl;

  /**
   * Locator - Button to cancel the monitoring task of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//table[@id='CANCEL-RcTaskDialog']//button[text()='Отменить']")
  private Button cancelCreateTaskRadioControl;

  /**
   * Locator - Button to apply the monitoring task of the "setting a radio monitoring task"
   */
  @FindBy(xpath = "//button[text()='Применить']")
  private Button applyCreateTaskRadioControl;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public MonitoringTask() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver), this);
  }

////////////////////////////////////////////////////////////////////////
//endregion


  /**
   * Select tab "Typical task" of window "creating a monitoring job"
   *
   * @return Open tab "Typical task"
   */
  public TypicalTask selectTypicalTask() {
    headerTypicalTask.click();
    SingletonWaitingItem.waitElementVisibly(labelNote);
    return new TypicalTask();
  }

  /**
   * Select tab "Frequencies" of window "creating a monitoring job"
   *
   * @return Open tab "Frequencies"
   */
  public Frequencies selectFrequencies() {
    headerFrequencies.click();
    SingletonWaitingItem.waitElementVisibly(labelSpectroscope);
    return new Frequencies();
  }

  /**
   * Select tab "Equipment" of window "creating a monitoring job"
   *
   * @return Open tab "Equipment"
   */
  public Equipment selectEquipment() {
    headerEquipment.click();
    SingletonWaitingItem.waitElementVisibly(labelFactoryNumber);
    return new Equipment();
  }

}
