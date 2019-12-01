package ru.qa.armada.n03_applicationStructure.n07_Marking;

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
 * <h1>This class work with SubMenu "Marking"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/Marking.png" alt="Marking.png">
 * </p>
 * */
public class Marking {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////


    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " Marking " from the tree
     */
    @FindBy(xpath = "//label[text()='Маркировка']")
    private LabelElement labelMarking;

    /////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node Marking
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Маркировка']")
    private TabElement tabMarking;
    /////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public Marking() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label 'Marking'
     */
    @Step("Wait of label 'Marking'")
    public void labelMarkingWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelMarking);
    }
    ////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'Marking'
     */
    @Step("Wait of tab 'Marking'")
    public void tabMarkingWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabMarking);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "Marking" of SubMenu "Marking"
     * @return Main window for editing job parameters Marking
     */
    @Step("Select page task")
    public Marking selectPageMarking(){
        tabMarking.click();
        labelMarkingWait();
        WorkWithAttachment.getScreenWebdriver("MarkingPage");
        return new Marking();
    }
////////////////////////////////////////////////////////////////////////
//endregion

}


