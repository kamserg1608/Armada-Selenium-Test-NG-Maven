package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.*;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            driver = new LocalDriver();
            try {
                BufferedImage bufferedImage = driver.getDesktop().picture();
                ImageIO.write(bufferedImage, "PNG", new File("C:\\PrintScreen.png"));
            } catch (InvocationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Allure.step("Create Driver Test Left", Status.PASSED);
            logger.debug("Create Driver Test Left");
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
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
