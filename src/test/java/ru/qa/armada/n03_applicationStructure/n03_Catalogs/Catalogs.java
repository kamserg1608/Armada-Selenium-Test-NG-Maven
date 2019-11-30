package ru.qa.armada.n03_applicationStructure.n03_Catalogs;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n01_ManagementObjects.ManagementObjects;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n02_RadioMonitoringEquipment.RadioMonitoringEquipment;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n03_Antennas.Antennas;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n04_Staff.Staff;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n05_BandNorms.BandNorms;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n06_FrequencyNorms.FrequencyNorms;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n07_ChannelNumbers.ChannelNumbers;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n08_TVAndRVChannels.TVAndRVChannels;
import ru.qa.armada.n03_applicationStructure.n03_Catalogs.n09_ProtectedObjects.ProtectedObjects;

/**
 *
 * <h1>This class work with SubMenu "Database"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/Database.png" alt="Database.png">
 * </p>
 * */
public class Catalogs {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

    //region elementDefinitionTabs
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Submenu " Management Objects " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Объекты управления']")
    private TabElement tabManagementObjects;

    /**
     * Locator - Submenu " Radio monitoring equipment " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Радиоконтрольное оборудование']")
    private TabElement tabRadioMonitoringEquipment;

    /**
     * Locator - Submenu " Antennas " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Антенны']")
    private TabElement tabAntennas;

    /**
     * Locator - Submenu " Staff " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Сотрудники']")
    private TabElement tabStaff;

    /**
     * Locator - Submenu " Band norms " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Нормы по полосе']")
    private TabElement tabBandNorms;

    /**
     * Locator - Submenu " Frequency norms " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Нормы по частоте']")
    private TabElement tabFrequencyNorms;

    /**
     * Locator - Submenu " Channel numbers " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Номера каналов']")
    private TabElement tabChannelNumbers;

    /**
     * Locator - Submenu " TV and RV channels " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Каналы ТВ и РВ']")
    private TabElement tabTVAndRVChannels;

    /**
     * Locator - Submenu " Protected Objects " in the tree in the Catalogs section
     */
    @FindBy(xpath = "//span[text()='Охраняемые объекты']")
    private TabElement tabProtectedObjects;
/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " Management Objects " from the tree
     */
    @FindBy(xpath = "//label[text()='Объекты управления']")
    private LabelElement labelManagementObjects;

    /**
     * Locator - Central label of the selected submenu of the "  Radio monitoring equipment  " from the tree
     */
    @FindBy(xpath = "//label[text()='Радиоконтрольное оборудование']")
    private LabelElement labelRadioMonitoringEquipment;

    /**
     * Locator - Central label of the selected submenu of the " Antennas " from the tree
     */
    @FindBy(xpath = "//label[text()='Антенны']")
    private LabelElement labelAntennas;

    /**
     * Locator - Central label of the selected submenu of the " Staff " from the tree
     */
    @FindBy(xpath = "//label[text()='Сотрудники']")
    private LabelElement labelStaff;

    /**
     * Locator - Central label of the selected submenu of the " Band norms " from the tree
     */
    @FindBy(xpath = "//label[text()='Нормы по полосе']")
    private LabelElement labelBandNorms;

    /**
     * Locator - Central label of the selected submenu of the " Frequency norms " from the tree
     */
    @FindBy(xpath = "//label[text()='Нормы по частоте']")
    private LabelElement labelFrequencyNorms;

    /**
     * Locator - Central label of the selected submenu of the " Channel numbers " from the tree
     */
    @FindBy(xpath = "//label[text()='Номера каналов']")
    private LabelElement labelChannelNumbers;

    /**
     * Locator - Central label of the selected submenu of the "  TV and RV channels  " from the tree
     */
    @FindBy(xpath = "//label[text()='Каналы ТВ и РВ']")
    private LabelElement labelTVAndRVChannels;

    /**
     * Locator - Central label of the selected submenu of the " Protected Objects " from the tree
     */
    @FindBy(xpath = "//label[text()='Охраняемые объекты']")
    private LabelElement labelProtectedObjects;
/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node Catalogs
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Справочники']")
    private TabElement tabCatalogs;

    /**
     * Locator - node Catalogs
     */
    @FindBy(xpath = "//div[@class='x-tree3-node-ct x-tree3 x-component x-unselectable']//td/div[3]/div[2]")
    private TabElement StateOFViewAllTabCatalogs;
/////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public Catalogs() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label ' Management Objects '
     */
    @Step("Wait of label ' Management Objects '")
    public void labelManagementObjectsWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelManagementObjects);
    }
    /**
     * Wait of label '  Radio monitoring equipment  '
     */
    @Step("Wait of label '  Radio monitoring equipment  '")
    public void labelRadioMonitoringEquipmentWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelRadioMonitoringEquipment);
    }
    /**
     * Wait of label 'Antennas'
     */
    @Step("Wait of label 'Antennas'")
    public void labelAntennasWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelAntennas);
    }
    /**
     * Wait of label 'Staff'
     */
    @Step("Wait of label 'Staff'")
    public void labelStaffWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelStaff);
    }
    /**
     * Wait of label 'Staff'
     */
    @Step("Wait of label ' Band norms '")
    public void labelBandNormsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelBandNorms);
    }
    /**
     * Wait of label ' Frequency norms '
     */
    @Step("Wait of label ' Frequency norms '")
    public void labelFrequencyNormsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelFrequencyNorms);
    }
    /**
     * Wait of label ' Channel numbers '
     */
    @Step("Wait of label ' Channel numbers '")
    public void labelChannelNumbersWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelChannelNumbers);
    }
    /**
     * Wait of label '  TV and RV channels  '
     */
    @Step("Wait of label '  TV and RV channels  '")
    public void labelTVAndRVChannelsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelTVAndRVChannels);
    }
    /**
     * Wait of label ' Protected Objects '
     */
    @Step("Wait of label ' Protected Objects '")
    public void labelProtectedObjectsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelProtectedObjects);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab ' Management Objects '
     */
    @Step("Wait of tab ' Management Objects '")
    public void tabManagementObjectsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabManagementObjects);
    }
    /**
     * Wait of tab ' Radio monitoring equipment '
     */
    @Step("Wait of tab ' Radio monitoring equipment '")
    public void tabRadioMonitoringEquipmentWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabRadioMonitoringEquipment);
    }
    /**
     * Wait of tab 'Antennas'
     */
    @Step("Wait of tab 'Antennas'")
    public void tabAntennasWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabAntennas);
    }
    /**
     * Wait of tab 'Staff'
     */
    @Step("Wait of tab 'Staff'")
    public void tabStaffWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabStaff);
    }
    /**
     * Wait of tab ' Band norms '
     */
    @Step("Wait of tab ' Band norms '")
    public void tabBandNormsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabBandNorms);
    }
    /**
     * Wait of tab ' Frequency norms '
     */
    @Step("Wait of tab ' Frequency norms '")
    public void tabFrequencyNormsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabFrequencyNorms);
    }
    /**
     * Wait of tab ' Channel numbers '
     */
    @Step("Wait of tab ' Channel numbers '")
    public void tabChannelNumbersWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabChannelNumbers);
    }
    /**
     * Wait of tab ' TV and RV channels '
     */
    @Step("Wait of tab ' TV and RV channels '")
    public void tabTVAndRVChannelsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabTVAndRVChannels);
    }
    /**
     * Wait of tab ' Protected Objects '
     */
    @Step("Wait of tab ' Protected Objects '")
    public void tabProtectedObjectsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabProtectedObjects);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab " Management Objects " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Management Objects
     */
    @Step("Select page  Management Objects ")
    public ManagementObjects selectPageManagementObjects(){
        tabManagementObjects.click();
        labelManagementObjectsWait();
        WorkWithAttachment.getScreenWebdriver("ManagementObjectsPage");
        return new ManagementObjects();
    }

    /**
     * Select Tab " Radio monitoring equipment " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Radio monitoring equipment
     */
    @Step("Select page Radio monitoring equipment ")
    public RadioMonitoringEquipment selectPageRadioMonitoringEquipment(){
        tabRadioMonitoringEquipment.click();
        labelRadioMonitoringEquipmentWait();
        WorkWithAttachment.getScreenWebdriver("RadioMonitoringEquipmentPage");
        return new RadioMonitoringEquipment();
    }

    /**
     * Select Tab "Antennas" of SubMenu "Catalogs"
     * @return Main window for editing job parameters Antennas
     */
    @Step("Select page Antennas")
    public Antennas selectPageAntennas(){
        tabAntennas.click();
        labelAntennasWait();
        WorkWithAttachment.getScreenWebdriver("AntennasPage");
        return new Antennas();
    }

    /**
     * Select Tab "Staff" of SubMenu "Catalogs"
     * @return Main window for editing job parameters Staff
     */
    @Step("Select page Staff")
    public Staff selectPageStaff(){
        tabStaff.click();
        labelStaffWait();
        WorkWithAttachment.getScreenWebdriver("StaffPage");
        return new Staff();
    }

    /**
     * Select Tab " Band norms " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Band norms
     */
    @Step("Select page  Band norms ")
    public BandNorms selectPageBandNorms(){
        tabBandNorms.click();
        labelBandNormsWait();
        WorkWithAttachment.getScreenWebdriver("BandNormsPage");
        return new BandNorms();
    }

    /**
     * Select Tab " Frequency norms " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Frequency norms
     */
    @Step("Select page  Frequency norms ")
    public FrequencyNorms selectPageFrequencyNorms(){
        tabFrequencyNorms.click();
        labelFrequencyNormsWait();
        WorkWithAttachment.getScreenWebdriver("FrequencyNormsPage");
        return new FrequencyNorms();
    }

    /**
     * Select Tab " Channel numbers " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Channel numbers
     */
    @Step("Select page Channel numbers ")
    public ChannelNumbers selectPageChannelNumbers(){
        tabChannelNumbers.click();
        labelChannelNumbersWait();
        WorkWithAttachment.getScreenWebdriver("ChannelNumbersPage");
        return new ChannelNumbers();
    }

    /**
     * Select Tab " TV and RV channels " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  TV and RV channels
     */
    @Step("Select page  TV and RV channels ")
    public TVAndRVChannels selectPageTVAndRVChannels(){
        tabTVAndRVChannels.click();
        labelTVAndRVChannelsWait();
        WorkWithAttachment.getScreenWebdriver("TVAndRVChannelsPage");
        return new TVAndRVChannels();
    }

    /**
     * Select Tab " Protected Objects " of SubMenu "Catalogs"
     * @return Main window for editing job parameters  Protected Objects
     */
    @Step("Select page  Protected Objects ")
    public ProtectedObjects selectPageProtectedObjects(){
        tabProtectedObjects.click();
        labelProtectedObjectsWait();
        WorkWithAttachment.getScreenWebdriver("ProtectedObjectsPage");
        return new ProtectedObjects();
    }
////////////////////////////////////////////////////////////////////////
//endregion

    /**
     * Select Tab Catalogs
     * @return Main window for editing job parameters Catalogs
     */
    @Step("Open Tab Catalogs")
    public Catalogs openTabCatalogs(){
        String str1 = StateOFViewAllTabCatalogs.getWebElement().getAttribute("style");
        String str2 = "display: none";

        boolean result = str1.contains(str2);
        if(result){
            tabCatalogs.dbclick();
        }

        tabManagementObjectsWait();
        tabRadioMonitoringEquipmentWait();
        tabAntennasWait();
        tabStaffWait();
        tabBandNormsWait();
        tabFrequencyNormsWait();
        tabChannelNumbersWait();
        tabTVAndRVChannelsWait();
        tabProtectedObjectsWait();

        return new Catalogs();
    }

}
