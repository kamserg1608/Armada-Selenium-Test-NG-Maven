package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

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
