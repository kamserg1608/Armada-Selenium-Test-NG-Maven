package ru.qa.armada.n02_appManagerForTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

  protected ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() {
    SingletonWebDriver.getInstance();
    SingletonWaitingItem.getInstance();
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
