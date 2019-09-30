package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;

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
/////////////////////////////////////////////////////////////////
//endregion

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public RunApplication(String passInstaller) {
        this.passInstaller = passInstaller;
        this.installationProcess = null;
        this.logger = LoggerFactory.getLogger(RunApplication.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * launch installation file
     * @return installation application startup process
     */
    @Step(value = "launch installation file")
    public TestProcess applicationLaunch(){
        try {
            logger.debug("Run install distribution");
            installationProcess = DriverTestLeft.driver.getApplications().run(passInstaller);
        } catch (ApiException | HttpException e) {
            Assert.fail("failed to start the application");
            logger.error("failed to start the application");
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
            logger.debug("Start waiting for the installation process");
            long start = System.currentTimeMillis();
            while ( processFreeze(start) ) {
                if (checkExistTestProcess() != null) {
                    Allure.step("Stop waiting for the installation process", Status.PASSED);
                    logger.debug("Stop waiting for the installation process");
                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            logger.error("Failed to wait for the installation process");
            Assert.fail("Failed to wait for the installation process");
            e.printStackTrace();
        }
    }
    private boolean processFreeze(long start){
        if( (System.currentTimeMillis() - start) > 1200000){
            Assert.fail("don't appearance current node configuration window");
            logger.error("don't appearance current node configuration window");
            return  false;
        } else {
            return true;
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
