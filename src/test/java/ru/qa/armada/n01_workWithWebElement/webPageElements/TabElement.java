package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with Tab in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalTabElement.png">
 * </p>
 */
public class TabElement extends Element {
  private Actions actions;
  public TabElement(WebElement webElement) {
    super(webElement);
    this.actions = new Actions(SingletonWebDriver.driver);
  }

  public void click() {
    webElement.click();
  }
  public void dbclick() {
    actions.doubleClick(webElement).perform();
  }

}
