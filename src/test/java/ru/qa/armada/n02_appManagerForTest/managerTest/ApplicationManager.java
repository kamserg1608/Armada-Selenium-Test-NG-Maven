package ru.qa.armada.n02_appManagerForTest.managerTest;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
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
  private Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  /**
   * Turning on the driver, Entering the login password and switching to the main menu "Armada"
   */
  public void init() {
//    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    SingletonWebDriver.driver.manage().window().maximize();
    SingletonWebDriver.driver.navigate().to("http://gserver.ircoc.vrn.ru/ircosweb/");
    SingletonWaitingItem.sleep(60000);
    SingletonWebDriver.driver.navigate().to("http://localhost:8080/armada");
    SingletonWebDriver.driver.navigate().refresh();
//    SingletonWebDriver.

    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    loginPage = new LoginPage();
    loginPage.checkSessionExpired();
    loginPage.submitAutorization("admin", "admin");
  }

  /**
   * turn off the Webdriver
   */
  @Step(value = "Close WebDriver and kill entities of driver")
  public void stop() {
    SingletonWebDriver.driver.close();
    logger.debug("Close WebDriver");
    killChromeDriver();
  }

  @Step(value = "kil process of Armada")
  private void killChromeDriver(){
    try {
      String currentDir = System.getProperty("user.dir");
      String pathToKill = "\\src\\test\\resources\\pws\\ChromedriverKill.ps1";
      String fullPath = currentDir.concat(pathToKill);
//        String command = "powershell.exe  \"C:\\Users\\Cont\\Desktop\\ArmadaSUKill Force.ps1\" ";
      String command = "powershell.exe  \"".concat(fullPath).concat("\" ");
      logger.debug("Start Kill chrome driver process {}", command);
      Process powerShellProcess = Runtime.getRuntime().exec(command);
      Thread.sleep(60000);
      powerShellProcess.getOutputStream().close();
      logger.debug("Stop Kill chrome driver process {}", command);
    } catch (Exception e) {
      Assert.fail("Don't kill service armada");
    }
  }
}
