package ru.qa.armada.n03_applicationStructure.n04_FileStorage;

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
 * <h1>This class work with SubMenu "FileStorage"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 *   <img src="{@docRoot}/doc-files/tabMainMenu/FileStorage.png" alt="FileStorage.png">
 * </p>
 * */
public class FileStorage {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////


    //region elementDefinitionLabel
///////////////////////////////////////////////////////////////////
    /**
     * Locator - Central label of the selected submenu of the " FileStorage " from the tree
     */
    @FindBy(xpath = "//label[text()='Хранилище файлов']")
    private LabelElement labelFileStorage;

    /////////////////////////////////////////////////////////////////
//endregion

    //region elementDefinitionOthers
///////////////////////////////////////////////////////////////////
    /**
     * Locator - node FileStorage
     */
    @FindBy(xpath = "//span[@class='x-tree3-node-text' and text()='Хранилище файлов']")
    private TabElement tabFileStorage;
    /////////////////////////////////////////////////////////////////
//endregion

/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public FileStorage() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckLabel
///////////////////////////////////////////////////////////////////
    /**
     * Wait of label 'FileStorage'
     */
    @Step("Wait of label 'FileStorage'")
    public void labelFileStorageWait(){
        assert  SingletonWaitingItem.waitElementVisibly(labelFileStorage);
    }
    ////////////////////////////////////////////////////////////////////////
//endregion

    //region waitCheckTab
///////////////////////////////////////////////////////////////////
    /**
     * Wait of tab 'FileStorage'
     */
    @Step("Wait of tab 'FileStorage'")
    public void tabFileStorageWait(){
        assert SingletonWaitingItem.waitElementVisibly(tabFileStorage);
    }
////////////////////////////////////////////////////////////////////////
//endregion

    //region selectPage
///////////////////////////////////////////////////////////////////
    /**
     * Select Tab "FileStorage" of SubMenu "FileStorage"
     * @return Main window for editing job parameters FileStorage
     */
    @Step("Select page task")
    public FileStorage selectPageFileStorage(){
        tabFileStorage.click();
        labelFileStorageWait();
        WorkWithAttachment.getScreenWebdriver("FileStoragePage");
        return new FileStorage();
    }
////////////////////////////////////////////////////////////////////////
//endregion

}

