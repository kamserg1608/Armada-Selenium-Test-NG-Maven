package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static ru.qa.armada.n04_tests.allure.Steps.logToAllure;
import static ru.qa.armada.n04_tests.allure.Steps.logToAllureWithValue;


/**
 * <h1>Use for delete "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class DeletePathAndService {
    private String uninstallPass;
    private Logger logger;
    private long start, end;

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
    public void  deleteArmada(){
        try {
            start = System.currentTimeMillis();
            logToAllure("Start stopping armada services");

            String commandRemovalService = "cmd /c \"cd /d C:\\armada && " + uninstallPass + " \"";
            Process queryServices = Runtime.getRuntime().exec(commandRemovalService);
            queryServices.waitFor();

            end = System.currentTimeMillis();
            logToAllureWithValue("Stop stopping armada services",(start - end));
            logger.debug("Stop stopping armada services");
        } catch (IOException | InterruptedException e) {
            end = System.currentTimeMillis();
            logToAllureWithValue("An error occurred while stopping the service",(start - end));
            logger.debug("An error occurred while stopping the service");
            e.printStackTrace();
        }

    }


}
