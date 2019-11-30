package ru.qa.armada.n03_applicationStructure.n03_Catalogs.n02_RadioMonitoringEquipment;

import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with tab RadioMonitoringEquipment of SubMenu "Catalogs"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/tabMainMenu/tabRadioMonitoringEquipment.png" alt="tabRadioMonitoringEquipment.png">
 * </p>
 */
public class RadioMonitoringEquipment {

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */

    public RadioMonitoringEquipment() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
    }

////////////////////////////////////////////////////////////////////////
//endregion
}
