package ru.qa.armada.n04_tests.allure;

import io.qameta.allure.*;
import static io.qameta.allure.Allure.step;
import org.testng.Assert;
import org.testng.annotations.*;

import org.slf4j.LoggerFactory;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithEnvironmentProperties;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

/**
 * USERESRESRESR
 */
@Listeners({ ru.qa.armada.n02_appManagerForTest.testNG.ListenerTestNG.class, ru.qa.armada.n02_appManagerForTest.testNG.RunSkipAndErrorInterceptor.class })
public class TestClass {
    private static final org.slf4j.Logger logger1 = LoggerFactory.getLogger(TestClass.class);

    @BeforeSuite
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
    public void afterTest(Method m) {
        Steps.infoLogToAllureAndMethod("Finish test", m.getName(), logger1);
//        logger1.info("Тест завершен!");
    }


    @Test(enabled = false)
    public void testLetsGo() {
//        step("Start installing the armada program");
        Steps.infoLogToAllure("Start installing the armada program", logger1);
        LetsGo letsGo = new LetsGo();
        letsGo.completeInstallationOfArmada();
        SingletonWebDriver.getInstance();
        SingletonWaitingItem.getInstance();
        Steps.infoLogToAllure("Finish installing the armada program", logger1);
//        step("Finish installing the armada program");
    }

    @Test
    public void testDemoConnectionSuccess() {
        Steps.checkSumStep(3, 2, 5);
        Steps.infoLogToAllure("ARTEM", logger1);
//        logger1.info("ARTEM");
//        step("ARTEM");
        Steps.checkSummationStep123(1,2,3);
        Steps.warnLogToAllure("DADADADA2", logger1);
//        logger1.warn("DADADADA2");
//        Steps.logToAllure("BUGAGA");
        Assert.assertEquals(1 + 3, 4, "Сумма слагаемых не соответствует ожидаемому значению");
        Steps.infoLogToAllure("BUGAGA", logger1);
//        Steps.logToAllure("BUGAGA");
        Steps.infoLogToAllure("Logged to allure: AZAZA", logger1);
//        logger1.info("Logged to allure: " + "AZAZA");
        Assert.assertTrue(true);

    }

    @Test
    public void testDemoSteps1() {
        Steps.checkSumStep(3, 2, 5);
        Steps.checkSumStep(5, 4, 9);
    }

    @Test
    public void testDemoSteps2() {
        Steps.checkSubtractionStep(10, 8, 2);
    }

    @Test
    public void testDemoAttachments1() throws IOException {
        WorkWithAttachment.getBytes("picture.jpg");
        WorkWithAttachment.getBytes("text.txt");
        WorkWithAttachment.getBytesLog("testFile.log");
        WorkWithAttachment.getScreen("CatDogAndDuck1");
        Assert.assertTrue(true);
    }

    @Test
    public void testDemoAttachments2() throws IOException {
        WorkWithAttachment.getBytesAnnotationWithArgs("json.json");
        WorkWithAttachment.getScreen("CatDogAndDuck2");
        Assert.assertTrue(true);
    }

    @Test
    public void testDemoAttachments3() {
        Allure.addAttachment("Ссылка", "text/plain", "http://sberbank.ru");
        Assert.assertTrue(true);
    }

    /**
     * Simple test for @Description illustration
     */
    @Test
    @Description(useJavaDoc = true)
    public void testDemoDescriptionAnnotation1() {
        Assert.assertEquals(1, 1);
    }

    @Test
    @Description(value = "Тест проверяет эквивалентность единицы единице")
    public void testDemoDescriptionAnnotation2() {
        Assert.assertEquals(1, 1);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Сложение")
    @Test
    public void testDemoFunctionalAnnotations1() {
        Steps.checkSummationStep(5, 4, 9);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Вычитание")
    @Test
    public void testDemoFunctionalAnnotations2() {
        Steps.checkSubtractionStep(8, 2, 6);
    }

    @Epics(value = {@Epic(value = "Математика"), @Epic(value = "Геометрия")})
    @Features(value = {@Feature(value = "Тригонометрия"), @Feature(value = "Простые математические операции")})
    @Stories(value = {@Story(value = "Синус"), @Story(value = "Синусоида")})
    @Test
    public void testDemoFunctionalAnnotations3() {
        Steps.checkSinStep(0, 0.0);
    }

    @Test
    @Flaky
    public void testDemoFlakyAnnotation() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    @Issue(value = "CQ-17197")
    public void testDemoIssueAnnotation() {
        Assert.assertEquals(1 + 2, 4);
    }

    @Test
//    @TmsLink(value = "TL-678")
    @TmsLink(value = "1798")
    public void testDemoTmsLinkAnnotation() {
        Assert.assertEquals(1, 1);
    }

    @Test
    @Link(name = "Ссылка", url = "http://yandex.ru")
    public void testDemoLinkAnnotation() {
        Steps.checkSubtractionStep(15, 5, 10);
    }

    @Test
    @Links(value = {@Link(name = "Ссылка1", url = "http://sberbank.ru"),
            @Link(name = "Ссылка2", url = "http://yandex.ru")})
    public void testDemoLinksAnnotation() {
        Steps.checkSubtractionStep(14, 5, 9);
    }

    //Демонстрация работы категорий. Product defects
    @Test
    public void testDemoCategories1() {
        //какие-то проверки, в результате которых тест может упасть
        Steps.checkSumStep(5, 6, 4);
    }

    //Демонстрация работы категорий. Test defects. traceRegex
    @Test
    public void testDemoCategories2() {
        //какие-то проверки, которые могут вызывать NullPointerException
        throw new NullPointerException();
    }

    //Демонстрация работы категорий. Test defects. messageRegex
    @Test
    public void testDemoCategories3() throws Exception {
        //какие-то проверки, которые могут вызывать Exception
        Steps.checkSumStep(1, 2, 3);
        throw new Exception("что-то пошло не так");
    }

    @Test
    @Owner(value = "VAsilu")
    public void testDemoOwnerAnnotation() {
        Steps.checkSumStep(1, 2, 3);
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void testDemoSeverityAnnotation() {
        Steps.checkSubtractionStep(6, 1, 5);
    }
}