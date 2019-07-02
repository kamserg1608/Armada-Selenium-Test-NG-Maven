package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

/**
 * <h1>This class work with Button in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalButton.png">
 * </p>
 */
public class Button extends Element {

  public Button(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }
}
