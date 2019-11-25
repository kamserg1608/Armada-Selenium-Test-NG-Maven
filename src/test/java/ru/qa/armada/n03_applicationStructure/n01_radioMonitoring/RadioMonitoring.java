package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;

import static io.qameta.allure.Allure.step;


/**
 *
 * <h1>This class work with SubMenu "RadioMonitoring"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/RadioMonitoring.png" alt="RadioMonitoring.png">
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
  private LabelElement labelTask;

///////////////////////////////////////////////////////////////////

  /**
   * Locator - Submenu " Result " in the tree in the radio control section
   */
  @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Результаты']")
  private TabElement tabResult;

  /**
   * Locator - label of the selected submenu of the " Result " from the tree
   */
  @FindBy(xpath = "//label[text()='Результаты']")
  private LabelElement labelResult;

  /**
   * Locator - node RadioMonitoring
   */
  @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Радиоконтроль']")
  private TabElement tabRadioMonitoring;

  /**
   * Locator - node RadioMonitoring
   */
  @FindBy(xpath = "//div[@class='x-tree3-node-ct x-tree3 x-component x-unselectable']//td/div[1]/div[2]")
  private TabElement StateOFViewTaskAndResult;

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
   * Wait of label 'Result'
   */
  @Step("Wait of label 'Result'")
  public void labelResultWait(){
//    Assert.assertTrue(SingletonWaitingItem.waitElementVisibly(labelResult));
    assert  SingletonWaitingItem.waitElementVisibly(labelResult);
  }
  /**
   * Wait of label 'Task'
   */
  @Step("Wait of label 'Task'")
  public void labelTaskWait(){
    assert SingletonWaitingItem.waitElementVisibly(labelTask);
//    Assert.assertTrue(SingletonWaitingItem.waitElementVisibly(labelTask));
  }
  /**
   * Wait of tab 'Result'
   */
  @Step("Wait of tab 'Result'")
  public void tabResultWait(){
//    Assert.assertTrue(SingletonWaitingItem.waitElementVisibly(tabResult));
   assert SingletonWaitingItem.waitElementVisibly(tabResult);
  }
  /**
   * Wait of tab 'Task'
   */
  @Step("Wait of tab 'Task'")
  public void tabTaskWait(){
    assert SingletonWaitingItem.waitElementVisibly(tabTask);
  }

  /**
   * Select Tab "tasks" of SubMenu "RadioMonitoring"
   * @return Main window for editing job parameters Tasks
   */
  @Step("Select page task")
  public Tasks selectPageTask(){
    tabTask.click();
    labelTaskWait();
    WorkWithAttachment.getScreenWebdriver("selectPage");
    return new Tasks();
  }

    /**
     * Select Tab "tasks" of SubMenu "RadioMonitoring"
     * @return Main window for editing job parameters Tasks
     */
    @Step("Select page result")
    public Tasks selectPageResult(){
//      step("selectPageResult");
      tabResult.click();
      labelResultWait();
//      WorkWithAttachment.getScreenWebdriver("open task result");
//      WorkWithAttachment.getScreenWebdriver("resultPage");
      WorkWithAttachment.getScreenWebdriver("resultPage");
      return new Tasks();
    }

    /**
     * Select Tab "RadioMonitoring"
     * @return Main window for editing job parameters Tasks
     */
    @Step("Open Tab RadioMonitoring")
    public Tasks openTabRadioMonitoring(){
      String str1 = StateOFViewTaskAndResult.getWebElement().getAttribute("style");
      String str2 = "display: none";

      boolean result = str1.contains(str2);
      if(result){
          tabRadioMonitoring.dbclick();
      }

      tabTaskWait();
      tabResultWait();
//      Assert.assertTrue(SingletonWaitingItem.waitElementVisibly(tabResult));

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
