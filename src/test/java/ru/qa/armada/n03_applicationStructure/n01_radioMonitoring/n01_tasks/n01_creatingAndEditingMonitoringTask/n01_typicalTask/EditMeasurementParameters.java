package ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.n01_typicalTask;

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
