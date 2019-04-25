package ru.qa.armada.n02_appManagerForTest;

import ru.qa.armada.n03_applicationStructure.ArmadaMainPage;
import ru.qa.armada.n03_applicationStructure.loginPage.LoginPage;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private LoginPage loginPage;
  private ArmadaMainPage armadaMainPage;

  public void init() {
    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    SingletonWebDriver.driver.manage().window().maximize();
    SingletonWebDriver.driver.navigate().to("http://localhost:8080/armada");
    SingletonWebDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    loginPage = new LoginPage();
    loginPage.submitAutorization("admin", "admin");
  }

  public void stop() {
    SingletonWebDriver.driver.quit();
  }

}
