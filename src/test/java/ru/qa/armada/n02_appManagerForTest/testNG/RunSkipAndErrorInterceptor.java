package ru.qa.armada.n02_appManagerForTest.testNG;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.SkipException;

/**
 * This class is used as a interceptor of error state and cleaning system
 */
public class RunSkipAndErrorInterceptor implements IHookable {
    private int numberOfReset = 0;
    private static int countOfError = 0;
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult res) {
        System.out.println("Starting " + res.getName());
        iHookCallBack.runTestMethod(res);

        if (res.getThrowable() != null) {
            countOfError++;
            if (countOfError >= 3) {
                System.out.println("Skip test because countOfError = " + countOfError);
                throw new SkipException("Skipping the test3 test method!");
            } else {
                while (true) {
                    numberOfReset++;
                    try {
                        System.out.println("Start cleaning system");
                        test1();
                        break;
                    } catch (Exception e) {
                        System.out.println("Reset don't successful. numberOfReset = " + numberOfReset);
                        System.out.println(e);
                        continue;
                    }
                }
            }
            //don't work in standard TestNG framework
            res.setThrowable(null);
            System.out.println("Cleaning system to the initial state");
        }
    }

    public void test1() throws Exception {
        System.out.println("I am in test1 test method and it will pass.");
        if(numberOfReset == 1){
            throw new Exception("Dog " + " doesn't go to the walk! Please check state of the rope!");
        }
    }
}
