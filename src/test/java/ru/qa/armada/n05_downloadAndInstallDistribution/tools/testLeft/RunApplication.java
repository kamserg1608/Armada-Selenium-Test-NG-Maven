package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n04_tests.allure.Steps;

/**
 * <h1>Start and wait for the installation process "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */

public class RunApplication {

    //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    private String passInstaller;
    private TestProcess installationProcess;
    private TestProcess armadaProcesssInstallation;
    private Logger logger;
    private long start, end;
/////////////////////////////////////////////////////////////////
//endregion

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public RunApplication(String passInstaller) {
        this.passInstaller = passInstaller;
        this.installationProcess = null;
        this.start = -1;
        this.end = -1;
        this.logger = LoggerFactory.getLogger(RunApplication.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * launch installation file
     * @return installation application startup process
     */
    public TestProcess applicationLaunch(){
        try {
            installationProcess = DriverTestLeft.driver.getApplications().run(passInstaller);

            Steps.logToAllure("Run install distribution");
            logger.debug("Run install distribution");

        } catch (ApiException | HttpException e) {

            Steps.logToAllure("failed to start the application");
            logger.debug("failed to start the application");

            e.printStackTrace();
        }
        waitingForProcessInstallation();
        return installationProcess;
    }

    /**
     * Waiting for the installation process
     */
    private void waitingForProcessInstallation(){
        try {

            start = System.currentTimeMillis();
            Steps.logToAllure("Start waiting for the installation process");
            logger.debug("Start waiting for the installation process");

            while (true) {
                if (checkExistTestProcess() != null) {

                    end = System.currentTimeMillis();
                    logger.debug("Stop waiting for the installation process {}",(end - start));
                    Steps.logToAllureWithValue("Stop waiting for the installation process",(end - start));

                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {

            end = System.currentTimeMillis();
            logger.debug("Failed to wait for the installation process {}",(end - start));
            Steps.logToAllureWithValue("Failed to wait for the installation process",(end - start));

            e.printStackTrace();
        }

    }

    /**
     * Search for installation process
     * @return current installation process
     */
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
