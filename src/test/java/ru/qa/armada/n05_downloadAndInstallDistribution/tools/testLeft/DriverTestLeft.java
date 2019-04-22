package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.*;

public class DriverTestLeft {

    private static final Object sync = new Object();
    private static volatile DriverTestLeft instance = null;
    public static Driver driver;

    private DriverTestLeft() {
        try {
            this.driver = new LocalDriver();
        } catch (HttpException | TestAgentRunException | RestConnectionRefused e) {
            e.printStackTrace();
        }
    }

    public static void getInstance(){
        try {
            if(instance == null){
                synchronized(sync){
                    if(instance == null){
                        instance = new DriverTestLeft();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
