package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n02_frequincies.n02_bookmarkFrequencies;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n02_frequincies.n02_bookmarkFrequencies.windows.AddFrequency;


/**
 * <h1>This class work with SubTab "Frequency" of tab "Frequency"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/BookmarkFrequencies.png" alt="альтернативный текст">
 * </p>
 */
public class BookmarkFrequencies {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Locator - Button add new frequency, IRI, RES etc.
   */
  @FindBy(xpath = "//em[@class='x-btn-arrow']//button[@class='x-btn-text ' and text()='Добавить']")
  private Button add;

  /**
   * Locator - Button add new frequency in button "Add"
   */
  @FindBy(xpath = "//span[contains(@id, 'ADD_FREQ-RcTaskDialogPresenter')]")
  private Button addFrequency;

  /**
   * Locator - Label windows "add frequency"
   */
  @FindBy(xpath = "//span[text()='Добавление частоты']")
  private WaitElement windowsAddFrequency;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public BookmarkFrequencies() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

///////////////////////////////////////////////////////////////////////
//endregion

  /**
   * Click add new Frequency
   */
  public void clickAddFrequency(){
    add.click();
    SingletonWaitingItem.waitElementVisibly(addFrequency);
    addFrequency.click();
    SingletonWaitingItem.waitElementVisibly(windowsAddFrequency);
  }
  /**
   * Set frequency in window "add frequency"
   *
   * @param frequency Set Frequency
   * @param band Set Band
   */
  public void setFrequency(String frequency, String band){
    AddFrequency addFrequency = new AddFrequency();
    addFrequency.setFrequencyParameters(frequency,band);
  }

}
