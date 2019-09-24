package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n03_equipment.windowBookmarks;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n03_equipment.windowsParameters.CreationReceptAndDetectParameters;

/**
 * <h1>This class work with SubTab "Equipment" of tab "Equipment"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/BookmarkEquipment.png" alt="BookmarkEquipment.png">
 * </p>
 */
public class BookmarkEquipment {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Locator - Button first equipment factory number in SubTab Equipment
   */
  @FindBy(xpath = "//span[text()='Заводской номер']/ancestor::tbody//td[1]/div")
  private Button nameOfEquipment;

///////////////////////////////////////////////////////////////////
  /**
   * Locator - Button add new parameters of subWindow "Parameters range"
   */
  @FindBy(xpath = "//table[@id='ADD_EQ_RANGE-RcTaskDialogPresenter']//button[text()='Добавить']")
  private Button addParameters;

  /**
   * Locator - Label of windowBookmarks "Creation parameters reception and detected"
   */
  @FindBy(xpath = "//span[@class='x-windowBookmarks-header-text' and contains( text(),'параметров приёма и обнаружения')]")
  private WaitElement labelCreateParametrov;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
//////////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public BookmarkEquipment() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

///////////////////////////////////////////////////////////////////
//endregion
  /**
   * Check in first equipment
   */
  public void selectEquipment(){
    nameOfEquipment.click();
  }

  /**
   * Click add new range
   */
  public void addRange(){
    addParameters.click();
    SingletonWaitingItem.waitElementVisibly(labelCreateParametrov);
  }

  /**
   * integrated function establishing standard parameters for window
   * "receive and detect a signal from tab Equipment".
   *
   * <h3>Uses the following functions.</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #selectEquipment() } method.</li>
   *     <li> Use the {@link #addRange() } method.</li>
   *     <li> Use the {@link CreationReceptAndDetectParameters#addComplexRange()} method. </li>
   *   </ul>
   * </div>
   */
  public void addParamatersRange(){
    selectEquipment();
    addRange();
    CreationReceptAndDetectParameters create = new CreationReceptAndDetectParameters();
    create.addComplexRange();
  }

}
