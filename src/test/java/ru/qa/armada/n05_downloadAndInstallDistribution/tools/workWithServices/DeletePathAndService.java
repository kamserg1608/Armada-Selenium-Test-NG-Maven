package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;

import static ru.qa.armada.n02_appManagerForTest.allure.Steps.logToAllure;
import static ru.qa.armada.n02_appManagerForTest.allure.Steps.logToAllureWithValue;


/**
 * <h1>Use for delete "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class DeletePathAndService {
    private String uninstallPass;
    private Logger logger;
    private static final int STOP_SUCCESSFUL_SERVICES = 0;

    public DeletePathAndService(String uninstallPass) {
        this.uninstallPass = uninstallPass;
        this.logger = LoggerFactory.getLogger(DeletePathAndService.class);
    }

    /**
     * Use to stop "Armada" services
     *
     * Use this article to help execute more than one commands in "cmd"
     * @see <a href="https://stackoverflow.com/questions/18866381/how-can-i-run-multiple-commands-in-just-one-cmd-windows-in-java">stackoverflow</a>
     */
    @Step(value = "Check delete Armada from standard uninstall tools ")
    public void  deleteArmada(){
        logger.debug("Start stopping armada services");

        String commandRemovalService = "cmd /c \"cd /d C:\\armada && " + uninstallPass + " \"";

        try {
            Process queryServices = Runtime.getRuntime().exec(commandRemovalService);
            int stateOfServiceArmada = queryServices.waitFor();
            Assert.assertEquals(stateOfServiceArmada, STOP_SUCCESSFUL_SERVICES);
        } catch (IOException | InterruptedException e) {
            Assert.fail("An error occurred while stopping the service");
            logger.error("An error occurred while stopping the service" );
            e.printStackTrace();
        }
        logger.debug("Finish stopping armada services");
    }


}
