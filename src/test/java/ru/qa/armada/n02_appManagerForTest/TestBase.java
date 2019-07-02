package ru.qa.armada.n02_appManagerForTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * <h1>This is the main test fixture for tests.</h1>
 *
 * @author KamyninSA
 * @version 1.0
 *
 */
public class TestBase {
  protected ApplicationManager app = new ApplicationManager();

  /**
   * Method running before all test methods
   */
  @BeforeMethod
  public void setUp() {
    SingletonWebDriver.getInstance();
    SingletonWaitingItem.getInstance();
    app.init();
  }

  /**
   * Method that runs after all test methods
   */
  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
