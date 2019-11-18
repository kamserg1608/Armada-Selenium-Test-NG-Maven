package ru.qa.armada.n04_tests.allure;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import com.google.common.io.Files;
import io.qameta.allure.*;
import static io.qameta.allure.Allure.step;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;

import org.slf4j.LoggerFactory;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithEnvironmentProperties;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.TC.AllParamatersForRunPostTC;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.TC.WorkWithRunTC;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * USERESRESRESR
 */
@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class TestClass {
    private static final org.slf4j.Logger logger1 = LoggerFactory.getLogger(TestClass.class);

    @BeforeSuite(enabled = false)
    public void addEnvironment(){
        WorkWithEnvironmentProperties workWithEnvironmentProperties = new WorkWithEnvironmentProperties();
        workWithEnvironmentProperties.creatingFileEnvironmentXml();
    }

    @BeforeMethod
    public void beforeTest(Method m) {
        Steps.infoLogToAllureAndMethod("Begin test", m.getName(), logger1);
//        logger1.info("Тест начат!");
    }

    @AfterMethod
    public void afterTest(Method m) throws IOException {
//        Steps.infoLogToAllureAndMethod("Finish test", m.getName(), logger1);
        WorkWithAttachment.getBytesLog("testFile.log");
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        ContextInitializer ci = new ContextInitializer(lc);
        lc.reset();
        try {
            ci.autoConfig();
        } catch (JoranException e) {
            e.printStackTrace();
        }
//        logger1.info("Тест завершен!");
    }

    @Step("set parameters for Team City")
    private void setParametersforTeamCity(){
        String architecture = "w64";
        String db_project = "empty_ru";
        String newMap = "world_contour_map";
        Boolean skipTests = true;
        String xmlFilePath = "setUpForTC.xml";
        AllParamatersForRunPostTC allParamatersForRunPostTC = new AllParamatersForRunPostTC(architecture, db_project, newMap, skipTests);
        allParamatersForRunPostTC.createParametersFile(xmlFilePath);
    }

    @Epic(value = "All Installation")
    @Feature(value = "Installation")
    @Story(value = "building a project using RestAPI")
    @Test(priority = 1)
    @Description("building a project using RestAPI")
    public void buildTeamCityArmadaProject() {
        setParametersforTeamCity();
        String xmlFilePath = "setUpForTC.xml";
        WorkWithRunTC workWithRunTC = new WorkWithRunTC(xmlFilePath);
        workWithRunTC.fullRunCode();
    }


    @Epic(value = "All Installation")
    @Feature(value = "Installation")
    @Story(value = "download and installation")
    @Test(priority = 2)
    @Description("Armada software download and installation")
    public void fullSoftwareInstall() {
        LetsGo letsGo = new LetsGo();
        letsGo.completeInstallationOfArmada();
        SingletonWebDriver.getInstance();
        SingletonWaitingItem.getInstance();
    }

}