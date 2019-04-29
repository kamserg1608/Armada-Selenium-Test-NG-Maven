package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeletePathAndService {
    private String uninstallPass;
    private Logger logger;

    public DeletePathAndService(String unistallPass) {
        this.uninstallPass = unistallPass;
        this.logger = LoggerFactory.getLogger(DeletePathAndService.class);
    }

    /**
    *   use this article to help execute more than one commands
    *   https://stackoverflow.com/questions/18866381/how-can-i-run-multiple-commands-in-just-one-cmd-windows-in-java
    *
    */
    public void  deleteArmada(){
        try {
            String commandRemovalService = "cmd /c \"cd /d C:\\armada && " + uninstallPass + " \"";
            Process queryServices = Runtime.getRuntime().exec(commandRemovalService);
            queryServices.waitFor();
            logger.debug("Delete Services");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
