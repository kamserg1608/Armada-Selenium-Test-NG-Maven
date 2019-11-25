package ru.qa.armada.n05_downloadAndInstallDistribution.tools;

import com.smartbear.testleft.testobjects.TestProcess;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.download.DownloadDistribution;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft.*;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.unzip.UnzippingArmada;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder.CreateFolder;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder.DeleteFolder;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder.FindExtFile;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithIPv4.WorkWithLocalIP;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices.DeletePathAndService;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithServices.StopServices;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <h1>Use for download, unzip and install "Armada" distribution</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class ArmadaDeployment {

//region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    private String armadaFolder;
    private File armadaDirectory;
    private String uninstall;
    private String mainFolder;
    private File armadaDownloadDirectory;
    private String distributionFolder;
    private String extractFolder;
    private String nameFile;
    private String URL;
    private String filter;
    private String useExeDistrib;
    private Logger logger;
    private long start, end, processTestRunTime;
/////////////////////////////////////////////////////////////////
//endregion

//region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public ArmadaDeployment(String armadaFolder, String uninstall, String mainFolder,String URL) {
        this.armadaFolder = armadaFolder;
        this.armadaDirectory = new File(armadaFolder);
        this.uninstall = armadaFolder + "\\" + uninstall;
        this.mainFolder = mainFolder;
        this.armadaDownloadDirectory = new File(mainFolder);
        this.distributionFolder = mainFolder + "\\TeamCity";
        this.extractFolder = mainFolder + "\\setupFiles";
        this.nameFile = "Armada.zip";
        this.URL = URL;
        this.filter = "exe";
        this.useExeDistrib = null;
        this.logger = LoggerFactory.getLogger(ArmadaDeployment.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * Use to remove old version of "Armada",
     * including stopping services and completely removing the installation folder
     */
    @Step(value = "Remove old version of 'Armada'")
    public void deleteArmada(){
        if( armadaDirectory.exists() ) {
            DeletePathAndService deletePathAndService = new DeletePathAndService(uninstall);
            deletePathAndService.deleteArmada();

//            String processName = "ArmadaSU";
//            StopServices stopServices = new StopServices(processName);
//            stopServices.waitProcess();
            waitStopProcessArmada();

            DeleteFolder deleteFolderArmada = new DeleteFolder(armadaFolder);
            deleteFolderArmada.deleteFolder();
        }
    }
    @Step(value = "stop process of Armada")
    public void waitStopProcessArmada(){
        String processName = "ArmadaSU";
        StopServices stopServices = new StopServices(processName);
        stopServices.waitProcess();
    }

    @Step(value = "stop process of Armada")
    public void killServiceArmadaSU(){
        try {
            String currentDir = System.getProperty("user.dir");
            String pathToKill = "\\src\\test\\resources\\pws\\ArmadaSUKill.ps1";
            String fullPath = currentDir.concat(pathToKill);
//        String command = "powershell.exe  \"C:\\Users\\Cont\\Desktop\\ArmadaSUKill Force.ps1\" ";
            String command = "powershell.exe  \"".concat(fullPath).concat("\" ");
            logger.debug("Start Kill service Armada SU {}", command);
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            waitOfCorrectKill();
            powerShellProcess.getOutputStream().close();
            logger.debug("Stop Kill service Armada SU {}", command);
        } catch (Exception e) {
            Assert.fail("Don't kill service armada");
        }
    }


    @Step(value = "stop process of postgress")
    public void killPostgress(){
        try {
            String currentDir = System.getProperty("user.dir");
            String pathToKill = "\\src\\test\\resources\\pws\\PostgresSUKill.ps1";
            String fullPath = currentDir.concat(pathToKill);
//        String command = "powershell.exe  \"C:\\Users\\Cont\\Desktop\\ArmadaSUKill Force.ps1\" ";
            String command = "powershell.exe  \"".concat(fullPath).concat("\" ");
            logger.debug("Start Kill Postgress process {}", command);
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            waitOfCorrectKill();
            powerShellProcess.getOutputStream().close();
            logger.debug("Stop Kill Postgress process {}", command);
        } catch (Exception e) {
            Assert.fail("Don't kill postgress");
        }
    }
    @Step(value = "Clean dataBase")
    public void copyCleanDataBase(){
        try {
            File sourceLocation= new File("c:\\armada\\dbClean");
            File targetLocation = new File("c:\\armada\\db");
            logger.debug("Start copy clean database {}", "c:\\armada\\dbClean");
            FileUtils.copyDirectory(sourceLocation, targetLocation);
            logger.debug("Stop copy clean database {}", "c:\\armada\\dbClean");
        } catch (Exception e) {
            Assert.fail("Don't copy clean database");
        }
    }
    @Step(value = "Delete old dataBase")
    public void deleteDataBase(){
        try {
            logger.debug("Start delete database {}", "c:\\armada\\db");
            FileUtils.deleteDirectory(new File("c:\\armada\\db"));
            logger.debug("Stop delete database {}", "c:\\armada\\db");
        } catch (Exception e) {
            Assert.fail("Don't copy clean database");
        }
    }
    @Step(value = "Clean dataBase")
    public void backUpDatabase(){
        try {
            File sourceLocation= new File("c:\\armada\\db");
            File targetLocation = new File("c:\\armada\\dbClean");
            logger.debug("Start backup database {}", "c:\\armada\\db");
            FileUtils.copyDirectory(sourceLocation, targetLocation);
            logger.debug("Stop backup database {}", "c:\\armada\\db");
        } catch (Exception e) {
            Assert.fail("Don't create clean database");
        }
    }



    @Step(value = "start process of Armada")
    public void startServiceArmadaSU() {
        try {
            String currentDir = System.getProperty("user.dir");
            String pathToKill = "\\src\\test\\resources\\pws\\ArmadaSUStart.ps1";
            String fullPath = currentDir.concat(pathToKill);
//        String command = "powershell.exe  \"C:\\Users\\Cont\\Desktop\\ArmadaSUStartForce.ps1\" ";
            String command = "powershell.exe  \"".concat(fullPath).concat("\" ");
            logger.debug("Start service armada SU process {}", command);
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            waitOfCorrectKill();
            powerShellProcess.getOutputStream().close();
            logger.debug("Stop service armada SU process {}", command);
        } catch (Exception e) {
            Assert.fail("Don't start service armada");
        }
    }

    private void waitOfCorrectKill() throws InterruptedException {
        Thread.sleep(20000);
    }

    /**
     * Used to download the latest successful version from the TC
     * and unpack the packaged distribution
     */
    @Step(value = "download and unzip application Armada from TC")
    public void downloadAndUnzip(){
        URL website = null;
        try {
            website = new URL(URL);
        } catch (MalformedURLException e) {
            Assert.fail("no correct uml");
            logger.error("no correct uml: ");
        }

        if( armadaDownloadDirectory.exists() ) {
            DeleteFolder deleteFolder = new DeleteFolder(mainFolder);
            deleteFolder.deleteFolder();
        }

        CreateFolder createFolderTeamCity = new CreateFolder(distributionFolder);
        createFolderTeamCity.createDirectory();

        CreateFolder createFolderSetupFiles = new CreateFolder(extractFolder);
        createFolderSetupFiles.createDirectory();

        DownloadDistribution downloadDistribution = new DownloadDistribution(website, distributionFolder, nameFile);
        downloadDistribution.downloadArmada();

        String fullPassToZip = distributionFolder + "\\" + nameFile;
        UnzippingArmada unzippingArmada = new UnzippingArmada(fullPassToZip, extractFolder);
        unzippingArmada.unzippind();

//        FindExtFile findExtFile = new FindExtFile(extractFolder,filter);
//
//        useExeDistrib = findExtFile.passToInstaller();
    }

    @Step(value = "get pass from system for Armada.exe file")
    public void gettingInstallationPathOfArmada(){
        FindExtFile findExtFile = new FindExtFile(extractFolder,filter);
        useExeDistrib = findExtFile.passToInstaller();
        logger.debug("Pass to distribution Armada application: {}",useExeDistrib);
        Allure.step("Pass to distribution Armada application: " + useExeDistrib, Status.PASSED);
    }

    /**
     * Used to install "Armada" on a new OS
     */
    public void workWithUI(){
        DriverTestLeft.getInstance();
        TestProcess armadaProcessInstallation = null;

        RunApplication runApplication = new RunApplication(useExeDistrib);
        runApplication.applicationLaunch();
        armadaProcessInstallation = runApplication.checkExistTestProcess();


        SelectLanguage selectLanguage = new SelectLanguage(armadaProcessInstallation);
        selectLanguage.selectLanguage();

        MainViewInstaller mainViewInstaller = new MainViewInstaller(armadaProcessInstallation);
        mainViewInstaller.startInstall(true, false, true);

//        String ipNode = "172.16.68.154";
        WorkWithLocalIP workWithLocalIP = new WorkWithLocalIP();
        String ipNode = workWithLocalIP.takeLocalIP();
        WindowCurrentNodeSetting windowCurrentNodeSetting = new WindowCurrentNodeSetting(armadaProcessInstallation ,ipNode,ipNode);
        windowCurrentNodeSetting.setIPCurrentNode();

        mainViewInstaller.waitLabelReadyInstall();
        mainViewInstaller.clickCloseButton();

    }
}
