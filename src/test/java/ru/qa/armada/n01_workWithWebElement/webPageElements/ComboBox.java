package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

/**
 * <h1>This class work with ComboBox in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalComboBox.png">
 * </p>
 */
public class ComboBox extends Element {
  public ComboBox(WebElement webElement) {
    super(webElement);
  }
  public void open() {
    webElement.click();
  }
}
