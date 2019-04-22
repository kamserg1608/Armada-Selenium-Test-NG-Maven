package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StopServices {
    private String useServices;
//    use services to debug
//    private String useServices = "KeysightCommunicationsFabric";
    private String commandQuery;
    private String codeError;
    private String fullCommandQueryExistProcess;
//    private String servicesRunOrNot = fullCommandQueryExistProcess + " | find \"RUN\"";
    private String stopProcess;
    private String fullCommandStopProcess;
    private String line;
    private long start, end;

    public StopServices(String useServices){
        this.useServices = useServices;
        this.commandQuery = "sc query ";
        this.codeError = "1060";
        this.fullCommandQueryExistProcess = commandQuery + useServices;
        this.stopProcess = "runas /profile /user:Администратор /savecred \"cmd.exe /c sc stop ";
        this.fullCommandStopProcess = stopProcess + useServices + "\"";
        this.start = -1;
        this.end = -1;
        this.line = "";
    }

    public void stopProcess() throws IOException, InterruptedException {
        Process queryServices = Runtime.getRuntime().exec(fullCommandQueryExistProcess);
        BufferedReader reader = new BufferedReader(new InputStreamReader(queryServices.getInputStream()));
        String line = reader.readLine();
        reader.close();

        if (!line.contains(codeError)) {
            Process queryServicesRunOrNot = Runtime.getRuntime().exec(fullCommandQueryExistProcess);
            BufferedReader readerRunOrNot = new BufferedReader(new InputStreamReader(queryServicesRunOrNot.getInputStream()));

            //region read until there is no status bar
            //////////////////////////////////////////////
            readerRunOrNot.readLine();
            readerRunOrNot.readLine();
            readerRunOrNot.readLine();
            String findRun = readerRunOrNot.readLine();
            //////////////////////////////////////////////
            //endregion

            readerRunOrNot.close();

            if (findRun.contains("RUN")) {
                Process stopArmada = Runtime.getRuntime().exec(fullCommandStopProcess);
                stopArmada.waitFor();
            }
        }
    }

    public void waitProcess(){
        start = System.currentTimeMillis();
        do {
            try {
                Thread.sleep(1000);
                Process queryServices = Runtime.getRuntime().exec(fullCommandQueryExistProcess);
                BufferedReader reader = new BufferedReader(new InputStreamReader(queryServices.getInputStream()));
                line = reader.readLine();
                reader.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } while(!line.contains(codeError));
        end = System.currentTimeMillis();
        System.out.println("Сервис не сущеуствует" + (end - start));
    }

}
