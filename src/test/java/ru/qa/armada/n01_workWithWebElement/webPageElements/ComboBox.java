package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class ComboBox extends Element {
  public ComboBox(WebElement webElement) {
    super(webElement);
  }
  public void open() {
    webElement.click();
  }
}
