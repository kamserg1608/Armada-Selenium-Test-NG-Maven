package ru.qa.armada.n03_applicationStructure.n09_AboutTheProgram;

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
 * <h1>This class work with SubMenu "AboutTheProgram"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/AboutTheProgram.png.png" alt="AboutTheProgram.png.png">
 * </p>
 * */
public class AboutTheProgram {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////


    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " AboutTheProgram " from the tree
     */
    @FindBy(xpath = "//label[text()='Информация о программе и системе']")
    private LabelElement labelAboutTheProgram;

    /////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node AboutTheProgram
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='О программе']")
    private TabElement tabAboutTheProgram;
    /**
     * Locator - node AboutTheProgramInnerTab
     */
    @FindBy(xpath = "//span[contains(@class, 'x-tab-strip-text') and text()='Общая информация']")
    private TabElement tabCommonInformation;
    /////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public AboutTheProgram() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label 'AboutTheProgram'
     */
    @Step("Wait of label 'AboutTheProgram'")
    public void labelAboutTheProgramWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelAboutTheProgram);
    }
    ////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'AboutTheProgram'
     */
    @Step("Wait of tab 'AboutTheProgram'")
    public void tabAboutTheProgramWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabAboutTheProgram);
    }
    /**
     * Wait of tab 'Common Information'
     */
    @Step("Wait of tab 'Common Information'")
    public void tabCommonInformationWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabCommonInformation);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "AboutTheProgram" of SubMenu "AboutTheProgram"
     * @return Main window for editing job parameters AboutTheProgram
     */
    @Step("Select page AboutTheProgram")
    public AboutTheProgram selectPageAboutTheProgram(){
        tabAboutTheProgram.click();
        labelAboutTheProgramWait();
        tabCommonInformationWait();
        WorkWithAttachment.getScreenWebdriver("AboutTheProgramPage");
        return new AboutTheProgram();
    }
////////////////////////////////////////////////////////////////////////
//endregion

}