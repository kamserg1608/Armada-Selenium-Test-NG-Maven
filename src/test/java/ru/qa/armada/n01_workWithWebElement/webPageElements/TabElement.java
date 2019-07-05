package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

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
  public TabElement(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }
}
