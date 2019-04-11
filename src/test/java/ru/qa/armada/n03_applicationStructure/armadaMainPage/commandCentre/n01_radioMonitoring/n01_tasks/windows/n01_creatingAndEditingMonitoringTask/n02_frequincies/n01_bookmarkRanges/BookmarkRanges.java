package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n02_frequincies.n01_bookmarkRanges;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;

/**
 * <h1>This class work with SubTab "Ranges" of tab "Frequency"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/BookmarkRanges.png" alt="альтернативный текст">
 * </p>
 */
public class BookmarkRanges {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  ///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public BookmarkRanges() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }
///////////////////////////////////////////////////////////////////////
//endregion

}
