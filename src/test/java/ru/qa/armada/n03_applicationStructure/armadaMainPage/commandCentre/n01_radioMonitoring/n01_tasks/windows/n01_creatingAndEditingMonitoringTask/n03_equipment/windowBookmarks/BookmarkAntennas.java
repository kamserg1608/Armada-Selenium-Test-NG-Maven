package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n03_equipment.windowBookmarks;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;

/**
 * <h1>This class work with SubTab "Antennas" of tab "Equipment"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/../src/test/resources/doc-files/BookmarkAntennas.png" alt="альтернативный текст">
 * </p>
 */

public class BookmarkAntennas  {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
//////////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */
  public BookmarkAntennas() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }


///////////////////////////////////////////////////////////////////
//endregion

}
