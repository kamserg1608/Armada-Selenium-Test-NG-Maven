package ru.qa.armada.n04_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.testNG.TestBase;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.MonitoringTask;

@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class CreateNewTask extends TestBase {

  @Test(enabled = false)
  public void testCreateNewTask() {
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    Tasks tasks = radioMonitoring.selectPageTask();
    MonitoringTask monitoringTask = tasks.addTask();


  }
}
