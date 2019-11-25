package ru.qa.armada.n02_appManagerForTest.testNG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.SkipException;

/**
 * This class is used as a interceptor of error state and cleaning system
 */
public class RunSkipAndErrorInterceptor implements IHookable {
    private int numberOfReset = 0;
    public static int countOfError = 0;
    public static int countOfErrorMaxCount = 3;
    private Logger logger = LoggerFactory.getLogger(RunSkipAndErrorInterceptor.class);
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult res) {
        logger.debug("StartSearch_RunSkipAndErrorInterceptor: test - {}",res);
//        System.out.println("Starting " + res.getName());
        iHookCallBack.runTestMethod(res);

        if (res.getThrowable() != null) {
            String classOfError = res.getThrowable().getCause().getClass().toString();
            logger.debug("FindFail_RunSkipAndErrorInterceptor: test - {}",classOfError);
//            res.getThrowable().getCause().getClass();
            countOfError++;
            if (countOfError >= countOfErrorMaxCount) {
//            if (countOfError >= countOfErrorMaxCount) {
                logger.debug("Skip test because countOfError = {}",countOfError);
                System.out.println("Skip test because countOfError = " + countOfError);
                throw new SkipException("Skipping the test3 test method!");
            } else {
//                while (true) {
                    numberOfReset++;
//                    try {
//                        System.out.println("Start cleaning system");
//                        test1();
//                        break;
//                    } catch (Exception e) {
//                        System.out.println("Reset don't successful. numberOfReset = " + numberOfReset);
//                        System.out.println(e);
//                        continue;
//                    }
//                }
            }
            //don't work in standard TestNG framework
            res.setThrowable(null);
            System.out.println("Cleaning system to the initial state");
        }
//        countOfError = 0;
    }

//    public void test1() throws Exception {
//        System.out.println("I am in test1 test method and it will pass.");
//        if(numberOfReset == 1){
//            throw new Exception("Dog " + " doesn't go to the walk! Please check state of the rope!");
//        }
//    }
}
