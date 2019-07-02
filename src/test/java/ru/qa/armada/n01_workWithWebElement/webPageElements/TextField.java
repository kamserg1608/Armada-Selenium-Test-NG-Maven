package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;


/**
 * <h1>This class work with TextField in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalTextField.png">
 * </p>
 */
public class TextField extends Element {
  public TextField(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }

  /**
   * Установить текст в элементе
   * @param text AZAZA
   */
  public void setText(String text) {
    click();
    if (text != null) {
      String existingText = webElement.getAttribute("value");
      if (! text.equals(existingText)) {
        webElement.clear();
        webElement.sendKeys(text);
      }
    }
  }
  /**
   * Очистить элемент
   */
  public void clear(){
  }
}
