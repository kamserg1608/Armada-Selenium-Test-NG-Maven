package ru.qa.armada.n04_tests;

import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.TestBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckLogin extends TestBase {

  @Test
  public void testCheckLogin() {
    Logger logger = LoggerFactory.getLogger(CheckLogin.class);
    logger.info("Hello World");
  }

}
