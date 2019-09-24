package ru.qa.armada.n04_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.testNG.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class CheckLogin extends TestBase {

  @Test
  public void testCheckLogin() {
    Logger logger = LoggerFactory.getLogger(CheckLogin.class);
    logger.debug("Hello World");
  }

}
