package ru.qa.armada.n02_appManagerForTest.testNG;


import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;

import static io.qameta.allure.Allure.step;

/**
 * This class is used as a different listener of status test
 */
public class ListenerTestNG extends TestBase implements ITestListener {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ListenerTestNG.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.debug("I am in onTestStart method {} start", getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.debug("I am in onTestSuccess method {} succeed", getTestMethodName(iTestResult));
//        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.debug("I am in onTestFailure method {} failed", getTestMethodName(iTestResult));
//        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
        restoreArmadaToOriginalState();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.debug("I am in onTestSkipped method {} skipped", getTestMethodName(iTestResult));
//        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        String str1 = iTestResult.getThrowable().getMessage();
        String str2 = "No such element : Proxy element for: DefaultElementLocator";
        boolean result = str1.regionMatches(0, str2, 0, 57);
        if(result){
            RunSkipAndErrorInterceptor.countOfError++;
        }
        if(RunSkipAndErrorInterceptor.countOfError > RunSkipAndErrorInterceptor.countOfErrorMaxCount){
            logger.debug("I am in onTestSkipped method {} skipped Because Project FULL FAIL", getTestMethodName(iTestResult));
        } else {
            restoreArmadaToOriginalState();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.debug("I am in onTestFailedButWithinSuccessPercentage method {} defined success ratio ", getTestMethodName(iTestResult));
//        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        restoreArmadaToOriginalState();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.debug("I am in onStart method {}", iTestContext.getName());

//        System.out.println("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.debug("I am in onFinish method {}", iTestContext.getName());
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Step("restart clean Armada")
    private void restoreArmadaToOriginalState(){
        logger.debug("ListenerTestNG: onFinish");
        try {
            tearDown();
            LetsGo letsGo = new LetsGo();
            letsGo.takeCleanArmada();
            setUp();
        } catch (Exception e) {
            Assert.fail("don't restart clean Armada");
        }
    }


}
