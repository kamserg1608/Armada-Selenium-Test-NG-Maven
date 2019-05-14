package ru.qa.armada.n02_appManagerForTest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;


public class TestBase {

  protected ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() {
    LetsGo letsGo = new LetsGo();
    letsGo.formAnArmada();
    SingletonWebDriver.getInstance();
    SingletonWaitingItem.getInstance();

    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
