package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;


/**
 *
 * <h1>This class work with SubMenu "RadioMonitoring"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/RadioMonitoring.png" alt="альтернативный текст">
 * </p>
 * */


public class RadioMonitoring {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Locator - Submenu " Task " in the tree in the radio control section
   */
  @FindBy(xpath = "//span[text()='Задания']")
  private TabElement tabTask;

  /**
   * Locator - Central label of the selected submenu of the " Task " from the tree
   */
  @FindBy(xpath = "//label[text()='Задания']")
  private WaitElement labelTask;

///////////////////////////////////////////////////////////////////

  /**
   * Locator - Submenu " Result " in the tree in the radio control section
   */
  @FindBy(xpath = "//span[text()='Результаты']")
  private TabElement tabResult;

  /**
   * Locator - label of the selected submenu of the " Result " from the tree
   */
  @FindBy(xpath = "//label[text()='Результаты']")
  private WaitElement labelResult;

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public RadioMonitoring() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

////////////////////////////////////////////////////////////////////////
//endregion
  /**
   * Select Tab "tasks" of SubMenu "RadioMonitoring"
   * @return Main window for editing job parameters Tasks
   */
  public Tasks selectPageTask(){
    tabTask.click();
    SingletonWaitingItem.waitElementVisibly(labelTask);
    return new Tasks();
  }


  // TODO: Need realize class Result
//  /**
//   * Select Tab "results" of SubMenu "RadioMonitoring"
//   */
//  public Result selectPageResult(){
//    tabResult.click();
//    SingletonWaitingItem.waitElementVisibly(labelResult);
//    return new Tasks();
//  }

}
