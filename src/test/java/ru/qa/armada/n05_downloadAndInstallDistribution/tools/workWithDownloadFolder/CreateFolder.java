package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;

public class CreateFolder {
    public long start, end;
    File folderDownload;
    String passFolder;

    public CreateFolder(String passFolder) {
        this.passFolder = passFolder;
        folderDownload= new File(passFolder);
    }

    public void createDirectory() {
        folderDownload.mkdirs();
    }
}
