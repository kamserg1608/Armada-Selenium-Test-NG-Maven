package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

/**
 * <h1>This class work with WaitElement in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalWaitElement.png">
 * </p>
 */
public class WaitElement extends Element {

  public WaitElement(WebElement webElement) {
    super(webElement);

  }

}
