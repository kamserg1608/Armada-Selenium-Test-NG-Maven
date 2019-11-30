package ru.qa.armada.n03_applicationStructure.n03_Catalogs.n07_ChannelNumbers;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with tab ChannelNumbers of SubMenu "Catalogs"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabMainMenu/tabChannelNumbers.png" alt="tabChannelNumbers.png">
 * </p>
 */
public class ChannelNumbers {
    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public ChannelNumbers() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion
}
