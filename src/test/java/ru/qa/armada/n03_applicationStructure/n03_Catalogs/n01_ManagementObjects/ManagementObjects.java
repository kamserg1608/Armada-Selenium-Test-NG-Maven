package ru.qa.armada.n03_applicationStructure.n03_Catalogs.n01_ManagementObjects;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with tab ManagementObjects of SubMenu "Catalogs"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabMainMenu/tabManagementObject.png" alt="tabManagementObject.png">
 * </p>
 */
public class ManagementObjects {

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public ManagementObjects() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion
}
