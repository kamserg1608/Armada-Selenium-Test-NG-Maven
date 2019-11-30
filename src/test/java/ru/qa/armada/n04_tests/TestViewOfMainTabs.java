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
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n01_creatingAndEditingMonitoringTask.MonitoringTask;
import ru.qa.armada.n03_applicationStructure.n02_Database.Database;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.Catalogs;

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
  public void testCheckRadioMonitoring() {
    logger.debug("Start testCheckRadioMonitoring");
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    radioMonitoring.openTabRadioMonitoring();
    radioMonitoring.selectPageTask();
    radioMonitoring.selectPageResult();
    logger.debug("Stop testCheckRadioMonitoring");
  }

  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test
  @Description("check correct restart")
  public void testCreateNewTask1() {
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    Assert.fail("Check correct restart clean system");
    Tasks tasks = radioMonitoring.selectPageTask();
    MonitoringTask monitoringTask = tasks.addTask();
  }

  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test
  @Description("check correct state of view tab Database")
  public void testCheckDatabase() {
    logger.debug("Start testCheckDatabase");
      Database database = new Database();
      database.openTabDatabase();
      database.selectPageCustomers();
      database.selectPageDocumentation();
      database.selectPageSourcesOfRadioEmissions();
      database.selectPageRadioMonitoringMeans();
    logger.debug("Stop testCheckDatabase");
  }

  @Epic(value = "View of main window")
  @Feature(value = "Normal tab view")
  @Test
  @Description("check correct state of view tab Catalogs")
  public void testCheckCatalogs() {
    logger.debug("Start testCheckCatalogs");
    Catalogs catalogs = new Catalogs();
    catalogs.openTabCatalogs();
    catalogs.selectPageManagementObjects();
    catalogs.selectPageRadioMonitoringEquipment();
    catalogs.selectPageAntennas();
    catalogs.selectPageStaff();
    catalogs.selectPageBandNorms();
    catalogs.selectPageFrequencyNorms();
    catalogs.selectPageChannelNumbers();
    catalogs.selectPageTVAndRVChannels();
    catalogs.selectPageProtectedObjects();
    logger.debug("Stop testCheckCatalogs");
  }
}
