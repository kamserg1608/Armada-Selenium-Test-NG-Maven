package ru.qa.armada.n04_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.managerTest.ApplicationManager;
import ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor;
import ru.qa.armada.n02_appManagerForTest.testNG.TestBase;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.MonitoringTask;

@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class TestViewOfMainTabs extends TestBase {
  private Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  @BeforeTest
  public void checkSkipTestProject(){
    if(RunSkipAndErrorInterceptor.countOfError > RunSkipAndErrorInterceptor.countOfErrorMaxCount){
      logger.debug("Many of countOfError: {}", RunSkipAndErrorInterceptor.countOfError);
      throw new SkipException("Skipping test");
    }
  }
  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test
  @Description("check correct state of view tab RadioMonitoring")
  public void testCreateNewTask() {
    logger.debug("Start testCreateNewTask");
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    radioMonitoring.openTabRadioMonitoring();
    radioMonitoring.selectPageTask();
    radioMonitoring.selectPageResult();
    logger.debug("Stop testCreateNewTask");
  }

  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test(enabled = false)
  @Description("check correct rest")
  public void testCreateNewTask1() {
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    Assert.fail("Check correct restart clean system");
    Tasks tasks = radioMonitoring.selectPageTask();
    MonitoringTask monitoringTask = tasks.addTask();
  }

  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test(enabled = false)
  @Description("check correct state of view tab RadioMonitoring")
  public void testCreateNewTask2() {
    logger.debug("Start testCreateNewTask");
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    radioMonitoring.openTabRadioMonitoring();
    radioMonitoring.selectPageTask();
    radioMonitoring.selectPageResult();
    logger.debug("Stop testCreateNewTask");
  }
}
