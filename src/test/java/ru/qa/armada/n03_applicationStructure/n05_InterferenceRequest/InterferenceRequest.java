package ru.qa.armada.n03_applicationStructure.n05_InterferenceRequest;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.LabelElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TabElement;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 *
 * <h1>This class work with SubMenu "InterferenceRequest"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/InterferenceRequest.png" alt="InterferenceRequest.png">
 * </p>
 * */
public class InterferenceRequest {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////


    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " InterferenceRequest " from the tree
     */
    @FindBy(xpath = "//label[text()='Заявки на поиск помех']")
    private LabelElement labelInterferenceRequest;

    /////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node InterferenceRequest
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Заявки на поиск помех']")
    private TabElement tabInterferenceRequest;
    /////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public InterferenceRequest() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label 'InterferenceRequest'
     */
    @Step("Wait of label 'InterferenceRequest'")
    public void labelInterferenceRequestWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelInterferenceRequest);
    }
    ////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'InterferenceRequest'
     */
    @Step("Wait of tab 'InterferenceRequest'")
    public void tabInterferenceRequestWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabInterferenceRequest);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "InterferenceRequest" of SubMenu "InterferenceRequest"
     * @return Main window for editing job parameters InterferenceRequest
     */
    @Step("Select page task")
    public InterferenceRequest selectPageInterferenceRequest(){
        tabInterferenceRequest.click();
        labelInterferenceRequestWait();
        WorkWithAttachment.getScreenWebdriver("InterferenceRequestPage");
        return new InterferenceRequest();
    }
////////////////////////////////////////////////////////////////////////
//endregion

}


