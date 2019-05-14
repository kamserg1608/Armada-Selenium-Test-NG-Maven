package ru.qa.armada.n05_downloadAndInstallDistribution.tools.download;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//
///**
// * <h1>Use to download distribution "Armada"</h1>
// * @see <a href="http://teamcity.ircoc.vrn.ru:8080/viewType.html?buildTypeId=Armada2_Armada2distribution_Armada2distributionBuild>
// *     Armada2distributionBuild</a>
// *
// * @author KamyninSA
// * @version 1.0
// */

public class DownloadDistribution extends AuthenticatorTeamCity {

    //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    private URL website;
    private String passFolder;
    private String nameFile;
    private String fullPathToFile;
    private Logger logger;
/////////////////////////////////////////////////////////////////
//endregion

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public DownloadDistribution(URL website, String passFolder, String nameFile) {
        this.website = website;
        this.passFolder = passFolder;
        this.nameFile = nameFile;
        this.fullPathToFile = passFolder + "\\" + nameFile;
        this.logger = LoggerFactory.getLogger(DownloadDistribution.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * Use to download the latest version is used "Armada2" default branch
     *
     * @return Boolean result of exist folder
     */
    public boolean downloadArmada() {
        setDefault(new AuthenticatorTeamCity());
        File folderDownload = new File(fullPathToFile);
        try {
            FileUtils.copyURLToFile(website, folderDownload);
        } catch (IOException e) {
            logger.debug("Don't download file from server");
            logger.debug(e.toString());
        }
        return folderDownload.exists();
    }
}
