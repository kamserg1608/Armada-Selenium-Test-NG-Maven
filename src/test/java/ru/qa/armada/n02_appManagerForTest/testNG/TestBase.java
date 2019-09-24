package ru.qa.armada.n02_appManagerForTest.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qa.armada.n02_appManagerForTest.managerTest.ApplicationManager;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;


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
