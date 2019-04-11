package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n02_frequincies;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n02_frequincies.n02_bookmarkFrequencies.BookmarkFrequencies;

/**
 * <h1>This class work with tab "Typical task" of window "creating a monitoring job"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/Frequencies.png" alt="альтернативный текст">
 * </p>
 */

public class Frequencies {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Locator - bookmark frequency next to bookmark range
   */
  @FindBy(xpath = "//span[@class='x-tab-strip-inner']//span[text()='Частоты']")
  private Button bookmarkFrequency;

  /**
   * Locator - Label frequency of bookmark frequency
   */
  @FindBy(xpath = "//span[contains(text(),'Частота, МГц')]")
  private WaitElement labelFrequency;

///////////////////////////////////////////////////////////////////

  /**
   * Locator - bookmark ranges next to bookmark range
   */
  @FindBy(xpath = "//span[@class='x-tab-strip-inner']//span[text()='Диапазоны']")
  private Button bookmarkRanges;

  /**
   * Locator - Label range of bookmark Ranges
   */
  @FindBy(xpath = "//span[contains(text(),'Диапазон, МГц')")
  private WaitElement labelRanges;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public Frequencies() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

///////////////////////////////////////////////////////////////////////
//endregion

  /**
   * Click SubTab Frequency of tab Frequency
   */
  public void selectBookmarkFrequency(){
    bookmarkFrequency.click();
    SingletonWaitingItem.waitElementVisibly(labelFrequency);
  }
  /**
   * Click SubTab Ranges of tab Frequency
   */
  public void selectBookmarkRanges(){
    bookmarkRanges.click();
    SingletonWaitingItem.waitElementVisibly(labelRanges);
  }

  /**
   * Add new Frequency.
   *
   * <h3>Uses the following functions</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #selectBookmarkFrequency() } method.</li>
   *     <li> Use the {@link BookmarkFrequencies#setFrequency(String frequency, String band)} method. </li>
   *   </ul>
   * </div>
   *
   * @param frequency Sets the transmitted frequency
   * @param band Sets the transmitted band
   */
  public void addFrequency(String frequency, String band) {
    selectBookmarkFrequency();
    BookmarkFrequencies bookmarkFrequencies = new BookmarkFrequencies();
    bookmarkFrequencies.setFrequency(frequency, band);
  }

}
