package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.qa.armada.n02_appManagerForTest.allure.Steps;

/**
 * <h1>singleton driver work "TestLeft" </h1>
 *
 * @author KamyninSA
 * @version 1.0
 */

public class DriverTestLeft {

    private static final Object sync = new Object();
    private static volatile DriverTestLeft instance = null;
    public static Driver driver;

    private Logger logger;

    private DriverTestLeft() {
        this.logger = LoggerFactory.getLogger(DriverTestLeft.class);
        try {
            this.driver = new LocalDriver();
        } catch (HttpException | TestAgentRunException | RestConnectionRefused e) {
            e.printStackTrace();
        }
    }

    /**
     * Creating a driver object
     */
    public static void getInstance(){
        try {
            if(instance == null){
                synchronized(sync){
                    if(instance == null){
                        instance = new DriverTestLeft();
                        Steps.logToAllure("Create Driver Test Left");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
