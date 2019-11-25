package ru.qa.armada.n04_tests.allure;

import io.qameta.allure.Description;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.qa.armada.n02_appManagerForTest.testNG.TestBase;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * USERESRESRESR
 */
@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class TestClass3 extends TestBase {
    private static final org.slf4j.Logger logger1 = LoggerFactory.getLogger(TestClass3.class);

    @BeforeSuite(enabled = false)
    public void addEnvironment(){
        logger1.info("Suite begin!");
    }

    @BeforeMethod(enabled = false)
    public void beforeTest(Method m) {
        logger1.info("Test Begin!");
    }

    @AfterMethod(enabled = false)
    public void afterTest(Method m) throws IOException {
        logger1.info("Test Finish!");
    }

    @Test(priority = 1)
    @Description("building a project using RestAPI")
    public void loginChecked() {
        LetsGo letsGo = new LetsGo();
        letsGo.takeCleanArmada();
        System.out.println("login");
        System.out.println("aaaa!!");
    }


    @Test(enabled = false, priority = 2)
    public void nextFunction() {
        System.out.println("next");
        System.out.println("ouuu!!");
    }

    
}