package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class Button extends Element {

  public Button(WebElement webElement) {
    super(webElement);
  }

  public void click() {
    webElement.click();
  }
}
