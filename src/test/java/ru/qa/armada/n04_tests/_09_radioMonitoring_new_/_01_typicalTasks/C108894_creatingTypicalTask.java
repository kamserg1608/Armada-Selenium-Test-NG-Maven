package ru.qa.armada.n04_tests._09_radioMonitoring_new_._01_typicalTasks;

import org.testng.annotations.Test;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_radioMonitoring.n01_tasks.n02_editingOfReferenceTasks.ReferenceTask;

public class C108894_creatingTypicalTask {

  @Test
  public void testC108894() {
    RadioMonitoring radioMonitoring = new RadioMonitoring();
    Tasks tasks = radioMonitoring.selectPageTask();
    ReferenceTask referenceTask = tasks.addTypicalTask();






  }
}
