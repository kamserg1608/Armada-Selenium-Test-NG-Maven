package ru.qa.armada.n05_downloadAndInstallDistribution;

import ru.qa.armada.n05_downloadAndInstallDistribution.tools.ArmadaDeployment;

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

    public void formAnArmada() {
        ArmadaDeployment armadaDeployment = new ArmadaDeployment(armadaFolder, uninstall, mainFolder, URL);
        armadaDeployment.deleteArmada();

        armadaDeployment.downloadAndUnzip();

        armadaDeployment.workWithUI();
    }

}
