package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n01_typicalTask;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;

/**
 * <h1>This class work with SubWindows "selection of typical tasks" of window "creating a monitoring job"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/TypicalTaskSelection.png" alt="альтернативный текст">
 * </p>
 */

public class TypicalTaskSelection {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Locator -  table row typical job measurement "measurement of signal parameters"
   */
  @FindBy(xpath = "//  @FindBy(xpath = \"//div[contains(text(),'змерение па') and contains(@class, 'x-grid3-col-name')]/ancestor::div[1]\")")
  private Button measurementSignalParameters;

  /**
   * Locator - Button choose of windowBookmarks "typical task selection"
   */
  @FindBy(xpath = "//button[@class='x-btn-text ' and contains(text(),'Выбрать')]")
  private Button applyTypicalTaskSelection;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public TypicalTaskSelection() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }
///////////////////////////////////////////////////////////////////////
//endregion


// TODO: Need update, because it is only local case
  /**
   * Use to select typical task"measurement of signal parameters"
   * @deprecated
   */
  @Deprecated
  public void selectTask() {
    SingletonWaitingItem.waitElementVisibly(measurementSignalParameters);
    measurementSignalParameters.click();
    try {
      SingletonWaitingItem.waitElementAttributeContain(measurementSignalParameters,"class", "x-grid3-highlightrow");
    } catch (Exception e) {
      System.out.println(e);
    }
    applyTypicalTaskSelection.click();
  }

}
