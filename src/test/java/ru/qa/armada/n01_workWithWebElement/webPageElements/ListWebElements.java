package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class ListWebElements extends Element {
  public ListWebElements(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }
}

