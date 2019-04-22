package ru.qa.armada.n05_downloadAndInstallDistribution.tools;

import com.smartbear.testleft.testobjects.TestProcess;
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

public class ArmadaDeployment {
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
    }

    public void deleteArmada(){
        if( armadaDirectory.exists() ) {
            DeletePathAndService deletePathAndService = new DeletePathAndService(uninstall);
            deletePathAndService.deleteArmada();

            String processName = "ArmadaSU";
            StopServices stopServices = new StopServices(processName);
            stopServices.waitProcess();

            DeleteFolder deleteFolderArmada = new DeleteFolder(armadaFolder);
            deleteFolderArmada.deleteFolder();
        }
    }
    public void downloadAndUnzip(){
        URL website = null;
        try {
            website = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
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

        FindExtFile findExtFile = new FindExtFile(extractFolder,filter);

        useExeDistrib = findExtFile.passToInstaller();
    }
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
