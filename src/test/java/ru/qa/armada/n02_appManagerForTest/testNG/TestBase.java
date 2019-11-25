package ru.qa.armada.n02_appManagerForTest.testNG;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.managerTest.ApplicationManager;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * <h1>This is the main test fixture for tests.</h1>
 *
 * @author KamyninSA
 * @version 1.0
 *
 */
@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class TestBase {
  private Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
  protected ApplicationManager app = new ApplicationManager();

  /**
   * Method running before all test methods
   */
  @BeforeTest
  public void setUp() {
    SingletonWebDriver.getInstance(true);
    SingletonWaitingItem.getInstance();
    app.init();
  }

  @BeforeMethod
  public void beforeTest(Method m) {
    Steps.infoLogToAllureAndMethod("Begin test", m.getName(), logger);
//        logger1.info("Тест начат!");
  }
  @AfterMethod
  public void afterTest(Method m) throws IOException {
//        Steps.infoLogToAllureAndMethod("Finish test", m.getName(), logger1);
    WorkWithAttachment.getBytesLog("testFile.log");
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    ContextInitializer ci = new ContextInitializer(lc);
    lc.reset();
    try {
      ci.autoConfig();
    } catch (JoranException e) {
      e.printStackTrace();
    }
//        logger1.info("Тест завершен!");
  }


  /**
   * Method that runs after all test methods
   */
  @AfterTest
  public void tearDown() {
    app.stop();
  }
}
