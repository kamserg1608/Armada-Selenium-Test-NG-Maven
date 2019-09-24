package ru.qa.armada.n02_appManagerForTest.managerTest;

import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.ArmadaMainPage;
import ru.qa.armada.n03_applicationStructure.loginPage.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * This class is used for entering the main menu "Armada"
 */
public class ApplicationManager {

  private LoginPage loginPage;
  private ArmadaMainPage armadaMainPage;

  /**
   * Turning on the driver, Entering the login password and switching to the main menu "Armada"
   */
  public void init() {
    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    SingletonWebDriver.driver.manage().window().maximize();
    SingletonWebDriver.driver.navigate().to("http://localhost:8080/armada");

    loginPage = new LoginPage();
    loginPage.submitAutorization("admin", "admin");
    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  /**
   * turn off the Webdriver
   */
  public void stop() {
    SingletonWebDriver.driver.quit();
  }

}
