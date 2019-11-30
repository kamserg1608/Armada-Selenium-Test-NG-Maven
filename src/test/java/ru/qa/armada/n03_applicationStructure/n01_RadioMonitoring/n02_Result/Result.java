package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n02_Result;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with tab Result of SubMenu "RadioMonitoring"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabMainMenu/tabResult.png" alt="tabResult.png">
 * </p>
 */
public class Result {


    ///////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

    /**
     * Initializes webElement Use Annotation @FindBy
     */
    public Result() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver), this);
    }

////////////////////////////////////////////////////////////////////////
//endregion


}
