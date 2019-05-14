package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;

/**
 * <h1>Use for create a "Armada" download directory</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class CreateFolder {
    public long start, end;
    File folderDownload;
    String passFolder;

    public CreateFolder(String passFolder) {
        this.passFolder = passFolder;
        folderDownload= new File(passFolder);
    }

    /**
     * Create directory
     */
    public void createDirectory() {
        folderDownload.mkdirs();
    }
}
