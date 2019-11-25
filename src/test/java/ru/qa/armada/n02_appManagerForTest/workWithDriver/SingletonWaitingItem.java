package ru.qa.armada.n02_appManagerForTest.workWithDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

/**
 * This class is used as a singleton to work with the WaitWebDriver
 */
public class SingletonWaitingItem{
  public static WebDriverWait wait;
  private int time = 20;
  private static final Object sync = new Object();
  private Logger logger = LoggerFactory.getLogger(SingletonWaitingItem.class);

  private static volatile SingletonWaitingItem instance = null;

  private SingletonWaitingItem(){
    wait = new WebDriverWait(SingletonWebDriver.driver, time);
    logger.debug("Create new WebDriverWait");
  }

  /**
   * Creating an instance of the selected driver
   * @return WaitWebDriver created
   */
  public static SingletonWaitingItem getInstance(){
    if(instance == null){
      synchronized(sync){
        if(instance == null)
          instance = new SingletonWaitingItem();
      }
    }
    return instance;
  }

  /**
   * Waiting for an item is Visibly
   * @param element locator
   */
  public static boolean waitElementVisiblyOrError(Element element) {
      try {
        wait.until( ExpectedConditions.visibilityOf(element.getWebElement()) );
        return true;
      } catch (Exception e) {
        Assert.fail("No such element : " + element.getWebElement().toString());
        return false;
      }
  }
  /**
   * Waiting for an item is Visibly
   * @param element locator
   */
  public static boolean waitElementVisibly(Element element) {
    try {
      wait.until( ExpectedConditions.visibilityOf(element.getWebElement()) );
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Waiting for an attribute to be set to a specific value
   * @param element locator
   * @param nameAttribute attribute name
   * @param ValueAttribute value name
   */
  public static void waitElementAttributeContain(Element element, String nameAttribute, String ValueAttribute){
    wait.until( ExpectedConditions.attributeContains(element.getWebElement(), nameAttribute, ValueAttribute) );
  }

  /**
   * Waiting for item selection
   * @param element locator
   * @param select turned on or turned off
   */
  public static void waitElementSelected(Element element, Boolean select){
    wait.until( ExpectedConditions.elementSelectionStateToBe(element.getWebElement(), select) );
  }

  /**
   * Wait until the item disappears
   * @param element locator
   */
  public static boolean waitElementInvisiblyOrError(Element element){
    try {
      wait.until( ExpectedConditions.visibilityOf(element.getWebElement()) );
      return false;
    } catch (NoSuchElementException | TimeoutException e) {
      return true;
    } catch (Exception e) {
      Assert.fail("No such element : " + element.getWebElement().toString());
      return false;
    }
  }
  /**
   * Wait until the item disappears
   * @param element locator
   */
  public static boolean waitElementInvisibly(Element element){
    try {
      wait.until( ExpectedConditions.invisibilityOf((WebElement)element) );
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  /**
   * Wait until the item is clickable
   * @param element locator
   */
  public static void waitElementClickable(Element element){
    wait.until( ExpectedConditions. elementToBeClickable(element.getWebElement()) );
  }

  /**
   * Waiting for an item to appear
   * @param locator
   */
  public static boolean presenceOfElementLocated(By locator){
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
      return true;
    } catch (Exception e) {
      return false;
    }

  }


  /**
   * Stop program execution
   * @param timeoutInMilliSeconds number of seconds
   */
  public static void sleep(int timeoutInMilliSeconds) {
    try {
      Thread.sleep(timeoutInMilliSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
