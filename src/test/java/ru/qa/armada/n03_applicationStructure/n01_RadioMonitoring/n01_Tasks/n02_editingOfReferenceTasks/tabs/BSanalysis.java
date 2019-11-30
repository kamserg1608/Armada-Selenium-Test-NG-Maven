package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks.tabs;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.AccordionElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.SingleTypicalTaskComboBox;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

public class BSanalysis {
    private Logger logger;

    private final String BS_GSM   = "Анализ сигналов БС GSM";
    private final String BS_UMTS  = "Анализ сигналов БС UMTS";
    private final String BS_LTE   = "Анализ сигналов БС LTE";
    private final String BS_TETRA = "Анализ сигналов БС TETRA";
    private final String BS_CDMA  = "Анализ сигналов БС CDMA";
    private final String BS_DECT  = "Анализ сигналов БС DECT";
    private final String BS_WiFi  = "Анализ сигналов БС WiFi";
    private final String BS_WiMax = "Анализ сигналов БС WiMax";
    private final String BS_DTV   = "Анализ сигналов цифрового ТВ";
    private final String BS_APCO  = "Анализ сигналов APCO";
    private final String BS_DMR   = "Анализ сигналов DMR";
    private final String BS_dPMR  = "Анализ сигналов dPMR";
    private final String BS_NXDN  = "Анализ сигналов NXDN";

    @FindBy(xpath = "//label[contains(text(),'Метод')]")
    SingleTypicalTaskComboBox methodDTV;

    @FindBy(xpath = "//span[contains(text(),'Анализ БС')]")
    AccordionElement tabAnalysisBS;

//    @FindBy(xpath = "//span[contains(text(),'Анализ БС')]/./ancestor::div[contains(@class,'x-panel-noborder')]//table[@class='x-grid3-row-table']/.//div[contains(@class,'x-grid3-col-name')]")
//    WebElement el2;

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */
    public BSanalysis() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
        this.logger = LoggerFactory.getLogger(BSanalysis.class);
    }

/////////////////////////////////////////////////////////////////
//endregion

    public void opentabs(){
        tabAnalysisBS.openTab();
//        el1.closeTab();
//        el1.getValueNameRows();
//        el1.getStatusOfLinesWithName();
//        el1.getValueCheckBoxRows();
//        el1.activateRow("Анализ сигналов БС GSM");
//        el1.deactivateRow("Анализ сигналов БС WiFi");

    }

    public void clickBSanalys(){
        String selectValue = "DTMB 6 МГц";
        methodDTV.selectElement(selectValue);
        String ttyy = "";
        ttyy = methodDTV.getValueOfSelectedItem();
    }

//region activateCheckBox
///////////////////////////////////////////////////////////////////

    public void activateGSM(){
        tabAnalysisBS.activateRow(BS_GSM);
    }
    public void activateUMTS(){
        tabAnalysisBS.activateRow(BS_UMTS);
    }
    public void activateLTE(){
        tabAnalysisBS.activateRow(BS_LTE);
    }
    public void activateTETRA(){
        tabAnalysisBS.activateRow(BS_TETRA);
    }
    public void activateCDMA(){
        tabAnalysisBS.activateRow(BS_CDMA);
    }
    public void activateDECT(){
        tabAnalysisBS.activateRow(BS_DECT);
    }
    public void activateWiFi(){
        tabAnalysisBS.activateRow(BS_WiFi);
    }
    public void activateWiMax(){
        tabAnalysisBS.activateRow(BS_WiMax);
    }
    public void activateDTV(){
        tabAnalysisBS.activateRow(BS_DTV);
    }
    public void activateAPCO(){
        tabAnalysisBS.activateRow(BS_APCO);
    }
    public void activateDMR(){
        tabAnalysisBS.activateRow(BS_DMR);
    }
    public void activatedPMR(){
        tabAnalysisBS.activateRow(BS_dPMR);
    }
    public void activateNXDN(){
        tabAnalysisBS.activateRow(BS_NXDN);
    }
/////////////////////////////////////////////////////////////////
//endregion

//region deactivateCheckBox
///////////////////////////////////////////////////////////////////

    public void deactivateGSM(){
        tabAnalysisBS.deactivateRow(BS_GSM);
    }
    public void deactivateUMTS(){
        tabAnalysisBS.deactivateRow(BS_UMTS);
    }
    public void deactivateLTE(){
        tabAnalysisBS.deactivateRow(BS_LTE);
    }
    public void deactivateTETRA(){
        tabAnalysisBS.deactivateRow(BS_TETRA);
    }
    public void deactivateCDMA(){
        tabAnalysisBS.deactivateRow(BS_CDMA);
    }
    public void deactivateDECT(){
        tabAnalysisBS.deactivateRow(BS_DECT);
    }
    public void deactivateWiFi(){
        tabAnalysisBS.deactivateRow(BS_WiFi);
    }
    public void deactivateWiMax(){
        tabAnalysisBS.deactivateRow(BS_WiMax);
    }
    public void deactivateDTV(){
        tabAnalysisBS.deactivateRow(BS_DTV);
    }
    public void deactivateAPCO(){
        tabAnalysisBS.deactivateRow(BS_APCO);
    }
    public void deactivateDMR(){
        tabAnalysisBS.deactivateRow(BS_DMR);
    }
    public void deactivatedPMR(){
        tabAnalysisBS.deactivateRow(BS_dPMR);
    }
    public void deactivateNXDN(){
        tabAnalysisBS.deactivateRow(BS_NXDN);
    }
/////////////////////////////////////////////////////////////////
//endregion

}
