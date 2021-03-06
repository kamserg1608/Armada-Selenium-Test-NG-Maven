package ru.qa.armada.n02_appManagerForTest.allure;

import io.qameta.allure.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Steps {
//    private static final Logger logger = LogManager.getLogger(Steps.class);
    private static final Logger logger = LoggerFactory.getLogger(Steps.class);

    //region setOfStandardChecks
///////////////////////////////////////////////////////////////////
    @Step(value = "Checking the sum of a number {num1} and numbers {num2}")
    public static void checkSummationStep123(int num1, int num2, int expectedSum) {
        int practicalResult = num1 + num2;
        Assert.assertEquals(expectedSum, practicalResult, "The sum of the terms does not match the expected value");
    }
    @Step
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        int practicalResult = num1 + num2;
        Assert.assertEquals(expectedSum, practicalResult, "The sum of the terms does not match the expected value");
    }

    @Step(value = "Checking the sum of a number {num1} and numbers {num2}")
    public static void checkSummationStep(int num1, int num2, int expectedSum) {
        int practicalResult = num1 + num2;
        Assert.assertEquals(expectedSum, practicalResult, "The sum of the terms does not match the expected value");
    }

    @Step(value = "Checking the difference of a number {num1} and numbers {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {
        int practicalResult = num1 - num2;
        Assert.assertEquals(expectedResult, practicalResult, "The result of the subtraction does not match the expected value");
        checkSummationStep(num1,num2,expectedResult);
    }

    @Step(value = "Checking the sine of a number {num}")
    public static void checkSinStep(int num, double expectedResult) {
        double actual = Math.sin(num);
        double delta = 0.1;
//        Assert.assertEquals(expectedResult, actual, delta, "The result of the subtraction does not match the expected value");
        Assert.assertEquals(expectedResult, actual, delta);
    }
////////////////////////////////////////////////////////////////
    //endregion

    //region LogOutWithRemoteClassLogger
///////////////////////////////////////////////////////////////////
    @Step(value = "{message}")
    public static void debugLogToAllure(String message, Logger log) {
        log.debug(message);
//        logger.debug("Logged to allure: "  +  log);
    }
    @Step(value = "{message}")
    public static void infoLogToAllure(String message, Logger log) {
        log.info(message);
    }
    @Step(value = "{message}: {method}")
    public static void infoLogToAllureAndMethod(String message, String method, Logger log) {
        log.info(message + " method: " + method);
    }
    @Step(value = "{message}")
    public static void warnLogToAllure(String message, Logger log) {
        log.warn(message);
    }
////////////////////////////////////////////////////////////////
    //endregion

    //region simpleLogOutToReport
///////////////////////////////////////////////////////////////////
    @Step(value = "{log}")
    public static void logToAllure(String log) {
        logger.debug("Logged to allure: " + log);
//        logger.debug("Logged to allure: "  +  log);
    }
    @Step(value = "{log}")
    public static  void logToAllureWithValue(String log, long value) {
        logger.debug(log + " " + value);
    }
    @Step(value = "{log}")
    public static  void logToAllureWithValue(String log, String value) {
        logger.debug(log + " " + value);
    }
    @Step(value = "{log}")
    public static void logToAllureWithValue(String log, boolean value) {
        logger.debug(log + " " + value);
    }
////////////////////////////////////////////////////////////////
    //endregion
}
