package ru.qa.armada.n04_tests.allure;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Steps {
//    private static final Logger logger = LogManager.getLogger(Steps.class);
    static final Logger logger = LoggerFactory.getLogger(Steps.class);

    @Step
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue( num1 + num2 == expectedSum,"Сумма слагаемых не соответствует ожидаемому значению");
    }

    @Step(value = "Проверка суммы числа {num1} и числа {num2}")
    public static void checkSummationStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue( num1 + num2 == expectedSum, "Сумма слагаемых не соответствует ожидаемому значению");
    }

    @Step(value = "Проверка разности числа {num1} и числа {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {
        Assert.assertTrue( num1 - num2 == expectedResult,"Результат вычитания не соответствует ожидаемому значению");
    }

    @Step(value = "Проверка синуса числа {num}")
    public static void checkSinStep(int num, double expectedResult) {
        Assert.assertTrue( Math.sin(num) == expectedResult,"Результат выражения не соответствует ожидаемому значению");
    }


    @Step("{log}")
    public static void logToAllure(String log) {
        logger.debug("Logged to allure: " + log);
        logger.debug("Logged to allure: "  +  log);
    }
}
