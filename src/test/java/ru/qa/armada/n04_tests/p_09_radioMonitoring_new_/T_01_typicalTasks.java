package ru.qa.armada.n04_tests.p_09_radioMonitoring_new_;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n02_appManagerForTest.testNG.TestBase;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.RadioMonitoring;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.Tasks;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks.CreatingTypicalMonitoringTask;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks.ReferenceTask;
import ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks.tabs.MeasurementOfSignalParameters;

@Epic(value = "p_09_radioMonitoring_new_")
@Feature(value = "Creating, editing, sending typical tasks")
public class T_01_typicalTasks extends TestBase {

    @TmsLink(value = "108894")
    @Test(enabled = false)
    @Description("creatingTypicalTask")
    public void C108894_test() {
        RadioMonitoring radioMonitoring = new RadioMonitoring();
        Tasks tasks = radioMonitoring.selectPageTask();
        ReferenceTask referenceTask = tasks.addTypicalTask();
        referenceTask.clickCreateTypicaTask();
        CreatingTypicalMonitoringTask creatingTypicalMonitoringTask = new CreatingTypicalMonitoringTask();
        creatingTypicalMonitoringTask.accordionDisclosure();
//        BSanalysis changeParametrsSignal = new BSanalysis();
//        changeParametrsSignal.opentabs();
//        WebElement ttt = SingletonWebDriver.driver.findElement(By.xpath("//input[@id='testid_nameField_Class-input']"));
        MeasurementOfSignalParameters measurementOfSignalParameters = new MeasurementOfSignalParameters();
        measurementOfSignalParameters.opentabs();
        measurementOfSignalParameters.activateFREQUENTLY();
        WebElement ttt = SingletonWebDriver.driver.findElement(By.xpath("//label[contains(text(),'Длительность измерения')]/./ancestor::div[contains(@class,'x-form-item')]//table//input"));
        String rrr = ttt.getAttribute("value");
        ttt.clear();
        ttt.sendKeys("123");

//        MeasurementOfSignalParameters measurementOfSignalParameters = new MeasurementOfSignalParameters();
//        measurementOfSignalParameters.opentabs();
//        measurementOfSignalParameters.activateFREQUENTLY();
//        measurementOfSignalParameters.probFunction();


//        changeParametrsSignal.clickBSanalys();

//        changeParametrsSignal.activateGSM  ();
//        changeParametrsSignal.activateUMTS ();
//        changeParametrsSignal.activateLTE  ();
//        changeParametrsSignal.activateTETRA();
//        changeParametrsSignal.activateCDMA ();
//        changeParametrsSignal.activateDECT ();
//        changeParametrsSignal.activateWiFi ();
//        changeParametrsSignal.activateWiMax();
//        changeParametrsSignal.activateDTV  ();
//        changeParametrsSignal.activateAPCO ();
//        changeParametrsSignal.activateDMR  ();
//        changeParametrsSignal.activatedPMR ();
//        changeParametrsSignal.activateNXDN ();
//
//        changeParametrsSignal.deactivateGSM  ();
//        changeParametrsSignal.deactivateUMTS ();
//        changeParametrsSignal.deactivateLTE  ();
//        changeParametrsSignal.deactivateTETRA();
//        changeParametrsSignal.deactivateCDMA ();
//        changeParametrsSignal.deactivateDECT ();
//        changeParametrsSignal.deactivateWiFi ();
//        changeParametrsSignal.deactivateWiMax();
//        changeParametrsSignal.deactivateDTV  ();
//        changeParametrsSignal.deactivateAPCO ();
//        changeParametrsSignal.deactivateDMR  ();
//        changeParametrsSignal.deactivatedPMR ();
//        changeParametrsSignal.deactivateNXDN ();


//        TypicalTask typicalTask = monitoringTask.selectTypicalTask();
        //    typicalTask.chooseTypicalTask();
        //    Frequencies frequencies = monitoringTask.selectFrequencies();
        //    frequencies.selectBookmarkFrequency();
        //    frequencies.addFrequency("200","200");
        //    Equipment equipment = monitoringTask.selectEquipment();
        //    equipment.addEquipment();
    }

//    @Test(enabled = false)
    @TmsLink(value = "108895")
    @Test(enabled = false)
    @Ignore
    @Description("repetitionTypicalTaskNames")
    public void C108895_test(){
        System.out.println("C108895");
    }
}
