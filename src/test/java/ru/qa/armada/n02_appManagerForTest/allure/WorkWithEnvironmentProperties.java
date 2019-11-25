package ru.qa.armada.n02_appManagerForTest.allure;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

import java.io.File;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class WorkWithEnvironmentProperties {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WorkWithEnvironmentProperties.class);
    private String browserName;
    private String browserVersion;

    public WorkWithEnvironmentProperties() {
        browserName = "";
        browserVersion = "";
    }

    private void outputLoggingNecessaryVariables(){
        logger.info("---------------");
        logger.info("user.dir = " + System.getProperty("user.dir"));
        logger.info("JDK.version = " + System.getProperty("java.version"));
        logger.info("OS.name = " + System.getProperty("os.name"));
        logger.info("OS.version = " + System.getProperty("os.version"));
        logger.info("OS.arch = " + System.getProperty("os.arch"));
        logger.info("testNG.version = " + System.getProperty("testNG.version"));
        logger.info("allure.testNG.version = " + System.getProperty("allure.testNG.version"));
        logger.info("maven-surefire-plugin.version = " + System.getProperty("maven-surefire-plugin.version"));
        logger.info("maven-resources-plugin.version = " + System.getProperty("maven-resources-plugin.version"));
        logger.info("suiteXmlFile = " + System.getProperty("suiteXmlFile"));
        logger.info("---------------");
    }
    private void addAllureEnvironment(){
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("JDK_version"                 , System.getProperty("java.version"))
                        .put("OperatingSystem_Name"        , System.getProperty("os.name"))
                        .put("OperatingSystem_Version"     , System.getProperty("os.version"))
                        .put("OperatingSystem_Architecture", System.getProperty("os.arch"))
                        .put("testNG_version"              , System.getProperty("testNG.version"))
                        .put("allureTestNG_version"        , System.getProperty("allure.testNG.version"))
                        .put("mavenSurefirePlugin_Version" , System.getProperty("maven-surefire-plugin.version"))
                        .put("mavenResourcesPlugin_Version", System.getProperty("maven-resources-plugin.version"))
                        .put("suiteXmlFile"                , System.getProperty("suiteXmlFile"))
                        .put("browser_Name"                , browserName)
                        .put("browser_Version"             , browserVersion)
                        .build(), System.getProperty("user.dir") + "/target/allure-results/");
    }
    private void gettingBrowserReferenceData(){
        SingletonWebDriver.getInstance(true);
        Capabilities cap = ((RemoteWebDriver) SingletonWebDriver.driver).getCapabilities();
        browserName = cap.getBrowserName();
        browserVersion = cap.getVersion();
        logger.info("---------------");
        logger.info("browser_Name = " + browserName);
        logger.info("browser_Version = " + browserVersion);
        logger.info("---------------");
        SingletonWebDriver.driver.navigate().to("http://gserver.ircoc.vrn.ru/ircosweb/?p=507");
//        File screenshot = ((TakesScreenshot) SingletonWebDriver.driver).getScreenshotAs(OutputType.FILE);
//        try {
//            Files.copy(screenshot, new File("C:\\screen.png"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        SingletonWebDriver.driver.quit();
    }

    public void creatingFileEnvironmentXml(){
        outputLoggingNecessaryVariables();
        gettingBrowserReferenceData();
        addAllureEnvironment();
    }
}
