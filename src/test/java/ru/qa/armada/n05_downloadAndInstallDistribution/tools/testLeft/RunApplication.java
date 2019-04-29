package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunApplication {
    private String passInstaller;
    private TestProcess installationProcess;
    private TestProcess armadaProcesssInstallation;
    private Logger logger;
    private long start, end;

    public RunApplication(String passInstaller) {
        this.passInstaller = passInstaller;
        this.installationProcess = null;
        this.start = -1;
        this.end = -1;
        this.logger = LoggerFactory.getLogger(RunApplication.class);
    }

    public TestProcess applicationLaunch(){
        try {
            installationProcess = DriverTestLeft.driver.getApplications().run(passInstaller);
        } catch (ApiException | HttpException e) {
           e.printStackTrace();
        }
        waitingForProcessInstallation();
        return installationProcess;
    }

    private void waitingForProcessInstallation(){
        try {
            start = System.currentTimeMillis();
            while (true) {
                if (checkExistTestProcess() != null) {
                    end = System.currentTimeMillis();
                    logger.info("Процесс запуска процесса {}",(end - start));
                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public TestProcess checkExistTestProcess(){
        try {
            armadaProcesssInstallation = (TestProcess) DriverTestLeft.driver.tryFind(TestProcess.class, new ProcessPattern() {{
                ProcessName = "javaw";
            }}).get();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return armadaProcesssInstallation;
    }
}
