package ru.qa.armada.n04_tests.allure;

import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

import java.util.concurrent.TimeUnit;

public class ASAS {
    public static void main(String[] args) {
        try {
            SingletonWebDriver.getInstance(false);
            SingletonWebDriver.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            SingletonWebDriver.driver.manage().window().maximize();
            SingletonWebDriver.driver.navigate().to("http://localhost:8080/armada");
            String winHandleBefore = SingletonWebDriver.driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
            for(String winHandle : SingletonWebDriver.driver.getWindowHandles()){
                SingletonWebDriver.driver.switchTo().window(winHandle);
            }

// Perform the actions on new window

// Close the new window, if that window no more required
            SingletonWebDriver.driver.close();

// Switch back to original browser (first window)
            SingletonWebDriver.driver.switchTo().window(winHandleBefore);
            SingletonWebDriver.driver.close();
            SingletonWebDriver.driver.quit();
            SingletonWebDriver.getInstance(false);
            SingletonWebDriver.driver.get("http://localhost:8080/armada");
            SingletonWebDriver.driver.close();
            SingletonWebDriver.driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
