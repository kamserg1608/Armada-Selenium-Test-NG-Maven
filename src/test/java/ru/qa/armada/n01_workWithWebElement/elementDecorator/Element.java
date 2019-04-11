package ru.qa.armada.n01_workWithWebElement.elementDecorator;

import org.openqa.selenium.WebElement;

public class Element implements IElement {
  protected WebElement webElement;

  public Element(WebElement webElement) {
    this.webElement = webElement;
  }
  // универсальные методы для всех элементов
  public WebElement getWebElement(){
    return webElement;
  }
}
