package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class TabElement extends Element {
  public TabElement(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }
}
