package ru.qa.armada.n05_downloadAndInstallDistribution.tools.download;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloadDistribution extends AuthenticatorTeamCity {
    private URL website;
    private String passFolder;
    private String nameFile;
    private String fullPathToFile;
    private Logger logger;

    public DownloadDistribution(URL website, String passFolder, String nameFile) {
        this.website = website;
        this.passFolder = passFolder;
        this.nameFile = nameFile;
        this.fullPathToFile = passFolder + "\\" + nameFile;
        this.logger = LoggerFactory.getLogger(DownloadDistribution.class);
    }

    public boolean downloadArmada() {
        setDefault(new AuthenticatorTeamCity());
        File folderDownload = new File(fullPathToFile);
        try {
            FileUtils.copyURLToFile(website, folderDownload);
        } catch (IOException e) {
            logger.info("Don't download file from server");
            logger.debug(e.toString());
        }
        return folderDownload.exists();
    }
}
