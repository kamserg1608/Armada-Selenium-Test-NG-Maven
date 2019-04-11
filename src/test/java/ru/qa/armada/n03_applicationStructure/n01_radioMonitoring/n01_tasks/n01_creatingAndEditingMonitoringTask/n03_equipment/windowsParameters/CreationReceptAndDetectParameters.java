package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n03_equipment.windowsParameters;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.CheckBox;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TextField;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;



/**
 * <h1>This class work with window "receive and detect a signal"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/CreationReceptAndDetectParameters.png" alt="альтернативный текст">
 * </p>
 */

public class CreationReceptAndDetectParameters {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  @FindBy(xpath = "//input[@name='startValueUi']")
  private TextField leftRange;

  @FindBy(xpath = "//input[@name='endValueUi']")
  private TextField rightRange;

  @FindBy(xpath = "//input[@name='fixedThreshold']")
  private TextField fixedThreshold;

  @FindBy(xpath = "//input[@name='fixedThresholdUsed']")
  private CheckBox fixedThresholdUsed;

  @FindBy(xpath = "//input[@name='floatingThresholdUsed']")
  private CheckBox floatingThresholdUsed;

  @FindBy(xpath = "//input[@name='maskThresholdUsed']")
  private CheckBox maskThresholdUsed;

  @FindBy(xpath = "//table[@id='OK-RcTaskEquipmentRangeDialog']//button[text()='Сохранить']")
  private Button safeOfReceptionAndDetectionParametr;
///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
//////////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public CreationReceptAndDetectParameters() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }

///////////////////////////////////////////////////////////////////
//endregion

  /**
   * integrated function establishing standard parameters for window
   * "receive and detect a signal".
   *
   * <h3>Uses the following functions.</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #enteringRange() } method.</li>
   *     <li> Use the {@link #activateCheckBox() } method.</li>
   *     <li> Use the {@link #safe() } method.</li>
   *   </ul>
   * </div>
   */
  @Deprecated
  public void addComplexRange(){
    SingletonWaitingItem.waitElementVisibly(leftRange);
    enteringRange();
    SingletonWaitingItem.sleep(2000);
    activateCheckBox();
    safe();
  }
  /**
  * Entering {@link #leftRange }, {@link #rightRange },
  * {@link #fixedThreshold }
  */
  @Deprecated
  public void enteringRange(){
    String leftValueRange = "25";
    String rightValueRange = "3000";
    String fixedThresholdValue = "3000";
    leftRange.setText(leftValueRange);
    rightRange.setText(rightValueRange);
    fixedThreshold.setText(fixedThresholdValue);
  }
  /**
   * Work with checkbox {@link #fixedThresholdUsed },
   * {@link #floatingThresholdUsed }, {@link #maskThresholdUsed}
   */
  @Deprecated
  public void activateCheckBox() {
    fixedThresholdUsed.setChecked(true);
    floatingThresholdUsed.setChecked(false);
    maskThresholdUsed.setChecked(false);
  }

  /**
   * Safe all changes in windows "receive and detect a signal"
   */
  public void safe(){
    safeOfReceptionAndDetectionParametr.click();
  }



}
