package ru.qa.armada.n05_downloadAndInstallDistribution;

import io.qameta.allure.Step;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n05_downloadAndInstallDistribution.tools.ArmadaDeployment;

/**
 * <h1>Use as a wrapper for installing "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class LetsGo {

    private String armadaFolder;
    private String uninstall;
    private String mainFolder;
    private String URL;


    public LetsGo() {
        this.armadaFolder = "C:\\armada";
        this.uninstall = "uninstall.cmd";
        this.mainFolder = "c:\\DownloadArmadaDistribution";
        this.URL = "http://teamcity.ircoc.vrn.ru:8080/repository/downloadAll/Armada2_Armada2distribution_Armada2distributionBuild/.lastSuccessful?branch=default";
    }

    /**
     * Main function for install distribution
     * installation from the unpacked distribution
     */
    @Step(value = "Main function for install distribution")
    public void completeInstallationOfArmada() {
        ArmadaDeployment armadaDeployment = new ArmadaDeployment(armadaFolder, uninstall, mainFolder, URL);
        armadaDeployment.deleteArmada();

        armadaDeployment.downloadAndUnzip();

        armadaDeployment.gettingInstallationPathOfArmada();
        armadaDeployment.workWithUI();

        armadaDeployment.killServiceArmadaSU();
        armadaDeployment.killPostgress();
        armadaDeployment.backUpDatabase();
        armadaDeployment.startServiceArmadaSU();
    }

    @Step(value = "small Main function for install distribution")
    public void smallInstallationOfArmada(){
        ArmadaDeployment armadaDeployment = new ArmadaDeployment(armadaFolder, uninstall, mainFolder, URL);
        armadaDeployment.deleteArmada();
        armadaDeployment.gettingInstallationPathOfArmada();
        armadaDeployment.workWithUI();
        armadaDeployment.backUpDatabase();
    }

    @Step(value = "take Clean Armada")
    public void takeCleanArmada(){
        ArmadaDeployment armadaDeployment = new ArmadaDeployment(armadaFolder, uninstall, mainFolder, URL);
        armadaDeployment.killServiceArmadaSU();
        armadaDeployment.killPostgress();
        armadaDeployment.deleteDataBase();
        SingletonWaitingItem.sleep(20000);
        armadaDeployment.copyCleanDataBase();
        armadaDeployment.startServiceArmadaSU();
    }





}
