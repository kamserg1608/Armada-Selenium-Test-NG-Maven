package ru.qa.armada.n02_appManagerForTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class SingletonWaitingItem{
  private static WebDriverWait wait;
  private int time = 20;
  private static final Object sync = new Object();

  private static volatile SingletonWaitingItem instance = null;

  private SingletonWaitingItem(){
    wait = new WebDriverWait(SingletonWebDriver.driver, time);
  }

  public static SingletonWaitingItem getInstance(){
    if(instance == null){
      synchronized(sync){
        if(instance == null)
          instance = new SingletonWaitingItem();
      }
    }
    return instance;
  }

  public static void waitElementVisibly(Element element){
    wait.until( ExpectedConditions.visibilityOf(element.getWebElement()) );
  }

  public static void waitElementAttributeContain(Element element, String nameAttribute, String ValueAttribute){
    wait.until( ExpectedConditions.attributeContains(element.getWebElement(), nameAttribute, ValueAttribute) );
  }

  public static void waitElementSelected(Element element, Boolean select){
    wait.until( ExpectedConditions.elementSelectionStateToBe(element.getWebElement(), select) );
  }

  public static void waitElementInvisibly(Element element){
    wait.until( ExpectedConditions.invisibilityOf(element.getWebElement()) );
  }

  public static void waitElementClickable(Element element){
    wait.until( ExpectedConditions. elementToBeClickable(element.getWebElement()) );
  }

  public static void presenceOfElementLocated(By element){
    wait.until( ExpectedConditions.presenceOfElementLocated(element) );
  }


  public static void sleep(int timeoutInMilliSeconds) {
    try {
      Thread.sleep(timeoutInMilliSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
