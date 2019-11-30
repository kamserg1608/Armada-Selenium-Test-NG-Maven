package ru.qa.armada.n03_applicationStructure.n02_Database.n04_SourcesOfRadioEmissions;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;


/**
 * <h1>This class work with tab SourcesOfRadioEmissions of SubMenu "Database"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabMainMenu/tabSourcesOfRadioEmissions.png" alt="tabTasks.png">
 * </p>
 */
public class SourcesOfRadioEmissions {
    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public SourcesOfRadioEmissions() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion
}
