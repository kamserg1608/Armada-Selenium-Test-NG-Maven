package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import static io.qameta.allure.Allure.step;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




/**
 * <h1>Used for stop "Armada" services</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/ServicesArmada.png" alt="Picture 'Stop services'">
 * </p>
 */
public class StopServices {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
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
    private Logger logger;
/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public StopServices(String useServices){
        this.useServices = useServices;
        this.commandQuery = "sc query ";
        this.codeError = "1060";
        this.fullCommandQueryExistProcess = commandQuery + useServices;
        this.stopProcess = "runas /profile /user:Администратор /savecred \"cmd.exe /c sc stop ";
        this.fullCommandStopProcess = stopProcess + useServices + "\"";
        this.line = "";
        this.logger = LoggerFactory.getLogger(StopServices.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * Used to stop services through the manipulation of the command "sc query"
     * for check process
     *
     *  @throws IOException if something went wrong
     *  @throws InterruptedException if something went wrong
     * <h3>Uses the following functions.</h3>
     * <div>
     *   <ul>
     *     <li> Use the {@link #waitProcess() } method.</li>
     *   </ul>
     * </div>
     */
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

    /**
     * Used to wait for the process to complete
     */
    @Step("Wait and check process stop")
    public void waitProcess(){
        long start = System.currentTimeMillis();
        logger.debug("Start of service launch");

        do {
            try {
                Thread.sleep(1000);
                Process queryServices = Runtime.getRuntime().exec(fullCommandQueryExistProcess);
                BufferedReader reader = new BufferedReader(new InputStreamReader(queryServices.getInputStream()));
                line = reader.readLine();
                reader.close();

            } catch (InterruptedException | IOException e) {
                Assert.fail("error in determining the existence of a service");
                logger.error("error in determining the existence of a service");
                e.printStackTrace();
            }
        } while( !line.contains(codeError) && processFreeze(start) );
        Allure.step("Services don't exist", Status.PASSED);
        step(fullCommandQueryExistProcess);
        logger.debug("Finish of service launch");
    }


    private boolean processFreeze(long start){
        if( (System.currentTimeMillis() - start) > 20000){
            Assert.fail("very long time stop service Armada");
            logger.error("very long time stop service Armada");
            return  false;
        } else {
            return true;
        }
    }


}
