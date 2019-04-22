package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeletePathAndService {
    private String uninstallPass;

    public DeletePathAndService(String unistallPass) {
        this.uninstallPass = unistallPass;
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
            System.out.println("Удалены сервисы");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
