package ru.qa.armada.n04_tests;

import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.TestBase;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n01_creatingAndEditingMonitoringTask.MonitoringTask;

public class CreateNewTask extends TestBase {

  @Test
  public void testCreateNewTask() {
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    Tasks tasks = radioMonitoring.selectPageTask();
    MonitoringTask monitoringTask = tasks.addTask();

//    TypicalTask typicalTask = monitoringTask.selectTypicalTask();
//    typicalTask.chooseTypicalTask();
//    Frequencies frequencies = monitoringTask.selectFrequencies();
//    frequencies.selectBookmarkFrequency();
//    frequencies.addFrequency("200","200");
//    Equipment equipment = monitoringTask.selectEquipment();
//    equipment.addEquipment();
  }
}
