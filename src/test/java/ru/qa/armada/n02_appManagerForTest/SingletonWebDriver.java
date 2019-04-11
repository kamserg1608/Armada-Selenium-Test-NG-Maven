package ru.qa.armada.n02_appManagerForTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

public class SingletonWebDriver {
  private String browser = BrowserType.CHROME;
  private static final Object sync = new Object();

  public static WebDriver driver;

  private static volatile SingletonWebDriver instance = null;
  private SingletonWebDriver(){
//    If the path to .exe in the system variable not the specified, then is necessary uncomment this line
//    System.setProperty("webdriver.gecko.driver", "C:\\...\\ArmadaTests\\drivers\\\geckodriver.exe")
//    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//    driver = new ChromeDriver();
    switch (browser) {
      case BrowserType.FIREFOX:
        driver = new FirefoxDriver();
        break;
      case BrowserType.CHROME:
        driver = new ChromeDriver();
        break;
      case BrowserType.IE:
        driver = new InternetExplorerDriver();
        break;
    }
  }
  public static SingletonWebDriver getInstance(){
    if(instance == null){
      synchronized(sync){
        if(instance == null)
          instance = new SingletonWebDriver();
      }
    }

    return instance;

  }

}
