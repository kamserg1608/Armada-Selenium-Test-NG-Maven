package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n03_equipment;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n03_equipment.windowBookmarks.BookmarkEquipment;

/**
 * <h1>This class work with tab "Equipment" of window "creating a monitoring job"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/Equipment.png" alt="альтернативный текст">
 * </p>
 */

public class Equipment{

//region elementDefinitionBlock
/////////////////////////////////////////////////////////////////////

  /**
   * Locator - Bookmarks equipment of windowBookmarks tab equipment
   */
  @FindBy(xpath = "//span[@class='x-tab-strip-text  ' and text()='Оборудование']")
  private TabElement tabEquipment;

  /**
   * Locator - Label range parameters of bookmark equipment
   */
  @FindBy(xpath = "//span[contains(text(),'Параметры диапазонов ')]")
  private WaitElement labelRangePatameters;

/////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Locator - Bookmarks antennas of windowBookmarks tab equipment
   */
  @FindBy(xpath = "//span[@class='x-tab-strip-text  ' and text()='Оборудование']")
  private TabElement tabAntennas;

  /**
   * Locator - Label antenna of bookmark antennas
   */
  @FindBy(xpath = "//span[contains(text(),'Параметры диапазонов ант')]")
  private WaitElement labelAntennaRangePatameters;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public Equipment() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

///////////////////////////////////////////////////////////////////////
//endregion

  /**
   * Activate SubTab Equipment
   */
  public void activateTabEquipment(){
    tabEquipment.click();
    SingletonWaitingItem.waitElementVisibly(labelRangePatameters);
  }

  /**
   * Activate SubTab Antennas
   */
  public void activateTabAntennas(){
    tabAntennas.click();
    SingletonWaitingItem.waitElementVisibly(labelAntennaRangePatameters);
  }

  // TODO: Need use table of equipment
  /**
   * Click first standard equipment.
   *
   * <h3>Uses the following functions</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #activateTabEquipment() } method.</li>
   *     <li> Use the {@link BookmarkEquipment#addParamatersRange() } method. </li>
   *   </ul>
   * </div>
   * @deprecated
   */
  @Deprecated
  public void addEquipment(){
    activateTabEquipment();
    BookmarkEquipment bookmarkEquipment = new BookmarkEquipment();
    bookmarkEquipment.addParamatersRange();
  }

}
