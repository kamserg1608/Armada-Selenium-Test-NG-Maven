package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n01_creatingAndEditingMonitoringTask.n02_frequincies.n02_bookmarkFrequencies;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TextField;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

public class AddFrequency {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

  @FindBy(xpath = "//input[@name='frequency.value']")
  private TextField frequencySet;

  @FindBy(xpath = "//input[@name='frequency.band']")
  private TextField bandSet;

  @FindBy(xpath = "//label[text()='Полоса, кГц*:']/ancestor::div[@class='x-windowBookmarks-bwrap']//button[text()='Сохранить']")
  private Button save;

///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
  public AddFrequency() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
  }
///////////////////////////////////////////////////////////////////////
//endregion

  public void setFrequencyParameters(String frequencyValue, String bandValue) {
    frequencySet.setText(frequencyValue);
    bandSet.setText(bandValue);
    save.click();
  }
}

