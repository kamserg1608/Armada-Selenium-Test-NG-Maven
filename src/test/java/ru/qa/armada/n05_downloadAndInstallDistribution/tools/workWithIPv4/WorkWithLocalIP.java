package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithIPv4;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Determines IP local machine of system</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */

public class WorkWithLocalIP {
    private String localIPv4;
    private InetAddress IP;
    private Logger logger;

    public WorkWithLocalIP() {
        this.localIPv4 = "127.0.0.1";
        this.logger = LoggerFactory.getLogger(WorkWithLocalIP.class);
    }

    /**
     * Getting IP
     * @return IPv4
     */
    @Step(value = "take current IP")
    public String takeLocalIP() {
        try {
            IP = InetAddress.getLocalHost();
            localIPv4 = IP.getHostAddress();

            Steps.logToAllureWithValue("Current IP of OS ",localIPv4);
            logger.debug("Current IP of OS {}",localIPv4);

        } catch (UnknownHostException e) {
            Assert.fail("Don't take current IP of OS");
            logger.error("Current IP of OS {}",localIPv4);
            e.printStackTrace();
        }

        return localIPv4;
    }
}
