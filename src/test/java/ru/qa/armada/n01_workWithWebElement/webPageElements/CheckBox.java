package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class CheckBox extends Element {

  public CheckBox(WebElement webElement) {
    super(webElement);
  }

  /**
   * Установить значение чекбокса
   * @param value значение чекбокса
   */
  public void setChecked(boolean value) {
    if (value != getStatus()) {
      webElement.click();
    }
  }

  /**
   * вернуть значение чекбокса
   * @return статус чекбокса
   */
  public boolean getStatus() {
    return webElement.isSelected();
  }
}
