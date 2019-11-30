package ru.qa.armada.n03_applicationStructure.n02_Database;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n03_applicationStructure.n02_Database.n01_Clients.Clients;
import ru.qa.armada.n03_applicationStructure.n02_Database.n02_Documentation.Documentation;
import ru.qa.armada.n03_applicationStructure.n02_Database.n03_RadioMonitoringMeans.RadioMonitoringMeans;
import ru.qa.armada.n03_applicationStructure.n02_Database.n04_SourcesOfRadioEmissions.SourcesOfRadioEmissions;

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
public class Database {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////

    //region elementDefinitionTabs
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Submenu " Customers " in the tree in the Database section
     */
    @FindBy(xpath = "//span[text()='Клиенты']")
    private TabElement tabCustomers;

    /**
     * Locator - Submenu " Documentation " in the tree in the Database section
     */
    @FindBy(xpath = "//span[text()='Документы']")
    private TabElement tabDocumentation;

    /**
     * Locator - Submenu " RadioMonitoringMeans " in the tree in the Database section
     */
    @FindBy(xpath = "//span[text()='Радиоэлектронные средства']")
    private TabElement tabRadioMonitoringMeans;

    /**
     * Locator - Submenu " SourcesOfRadioEmissions " in the tree in the Database section
     */
    @FindBy(xpath = "//span[text()='Источники радиоизлучений']")
    private TabElement tabSourcesOfRadioEmissions;
/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " Customers " from the tree
     */
    @FindBy(xpath = "//label[text()='Клиенты']")
    private LabelElement labelCustomers;

    /**
     * Locator - Central label of the selected submenu of the " Documentation " from the tree
     */
    @FindBy(xpath = "//label[text()='Документы']")
    private LabelElement labelDocumentation;

    /**
     * Locator - Central label of the selected submenu of the " RadioMonitoringMeans " from the tree
     */
    @FindBy(xpath = "//label[text()='Радиоэлектронные средства']")
    private LabelElement labelRadioMonitoringMeans;

    /**
     * Locator - Central label of the selected submenu of the " SourcesOfRadioEmissions " from the tree
     */
    @FindBy(xpath = "//label[text()='Источники радиоизлучений']")
    private LabelElement labelSourcesOfRadioEmissions;
/////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node RadioMonitoring
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='База данных']")
    private TabElement tabDatabase;

    /**
     * Locator - node Database
     */
    @FindBy(xpath = "//div[@class='x-tree3-node-ct x-tree3 x-component x-unselectable']//td/div[2]/div[2]")
    private TabElement StateOFViewAllTabDatabase;
/////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public Database() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label ' Customers'
     */
    @Step("Wait of label ' Customers'")
    public void labelCustomersWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelCustomers);
    }
    /**
     * Wait of label 'Documentation'
     */
    @Step("Wait of label 'Documentation'")
    public void labelDocumentationWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelDocumentation);
    }
    /**
     * Wait of label 'RadioMonitoringMeans'
     */
    @Step("Wait of label 'RadioMonitoringMeans'")
    public void labelRadioMonitoringMeansWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelRadioMonitoringMeans);
    }
    /**
     * Wait of label 'SourcesOfRadioEmissions'
     */
    @Step("Wait of label 'SourcesOfRadioEmissions'")
    public void labelSourcesOfRadioEmissionsWait(){
        assert SingletonWaitingItem.waitElementVisibly(labelSourcesOfRadioEmissions);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'Customers'
     */
    @Step("Wait of tab 'Customers'")
    public void tabCustomersWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabCustomers);
    }
    /**
     * Wait of tab 'Documentation'
     */
    @Step("Wait of tab 'Documentation'")
    public void tabDocumentationWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabDocumentation);
    }
    /**
     * Wait of tab 'Documentation'
     */
    @Step("Wait of tab 'RadioMonitoringMeans'")
    public void tabRadioMonitoringMeansWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabRadioMonitoringMeans);
    }
    /**
     * Wait of tab 'Documentation'
     */
    @Step("Wait of tab 'SourcesOfRadioEmissions'")
    public void tabSourcesOfRadioEmissionsWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabSourcesOfRadioEmissions);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "customers" of SubMenu "Database"
     * @return Main window for editing job parameters Customers
     */
    @Step("Select page customers")
    public Clients selectPageCustomers(){
        tabCustomers.click();
        labelCustomersWait();
        WorkWithAttachment.getScreenWebdriver("customersPage");
        return new Clients();
    }

    /**
     * Select Tab "documentation" of SubMenu "Database"
     * @return Main window for editing job parameters Documentation
     */
    @Step("Select page documentation")
    public Documentation selectPageDocumentation(){
        tabDocumentation.click();
        labelDocumentationWait();
        WorkWithAttachment.getScreenWebdriver("documentationPage");
        return new Documentation();
    }

    /**
     * Select Tab "radioMonitoringMeans" of SubMenu "Database"
     * @return Main window for editing job parameters RadioMonitoringMeans
     */
    @Step("Select page radioMonitoringMeans")
    public RadioMonitoringMeans selectPageRadioMonitoringMeans(){
        tabRadioMonitoringMeans.click();
        labelRadioMonitoringMeansWait();
        WorkWithAttachment.getScreenWebdriver("radioMonitoringMeansPage");
        return new RadioMonitoringMeans();
    }

    /**
     * Select Tab "radioMonitoringMeans" of SubMenu "Database"
     * @return Main window for editing job parameters SourcesOfRadioEmissions
     */
    @Step("Select page sourcesOfRadioEmissions")
    public SourcesOfRadioEmissions selectPageSourcesOfRadioEmissions(){
        tabSourcesOfRadioEmissions.click();
        labelSourcesOfRadioEmissionsWait();
        WorkWithAttachment.getScreenWebdriver("sourcesOfRadioEmissions");
        return new SourcesOfRadioEmissions();
    }
////////////////////////////////////////////////////////////////////////
//endregion

    /**
     * Select Tab Database
     * @return Main window for editing job parameters Tasks
     */
    @Step("Open Tab Database")
    public Database openTabDatabase(){
        String str1 = StateOFViewAllTabDatabase.getWebElement().getAttribute("style");
        String str2 = "display: none";

        boolean result = str1.contains(str2);
        if(result){
            tabDatabase.dbclick();
        }

        tabCustomersWait();
        tabDocumentationWait();
        tabRadioMonitoringMeansWait();
        tabSourcesOfRadioEmissionsWait();

        return new Database();
    }

}
