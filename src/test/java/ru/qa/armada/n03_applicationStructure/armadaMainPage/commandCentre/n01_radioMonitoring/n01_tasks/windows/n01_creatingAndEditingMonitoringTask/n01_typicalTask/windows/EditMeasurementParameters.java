package ru.qa.armada.n03_applicationStructure.armadaMainPage.commandCentre.n01_radioMonitoring.n01_tasks.windows.n01_creatingAndEditingMonitoringTask.n01_typicalTask.windows;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;

public class EditMeasurementParameters {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
//endregion


//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public EditMeasurementParameters() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }
///////////////////////////////////////////////////////////////////////
//endregion

}
