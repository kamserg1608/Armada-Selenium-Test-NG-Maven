package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * <h1>This class deleting folder using various checks</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class DeleteFolder {
    private File folderDownload;
    private String passFolder;
    private Logger logger;

    public DeleteFolder(String folderDownload) {
        this.passFolder = folderDownload;
        this.folderDownload = new File(folderDownload);
        this.logger = LoggerFactory.getLogger(DeleteFolder.class);
    }

    /**
     * Main function deleting folder
     */
    @Step(value = "delete folder")
    public void deleteFolder(){

        if (folderDownload.isDirectory()) {
            logger.debug("start delete folder");
            if(folderDownload.list().length != 0 ){
                try {
                    FileUtils.deleteDirectory(folderDownload );
                } catch (IOException e) {
                    Assert.fail("directory cannot be deleted");
                    logger.error("directory cannot be deleted");
                }
                checkDeleteFolder(folderDownload);
                logger.debug("finish delete folder: {}", passFolder);
            }
        }
    }

    private void checkDeleteFolder(File folderDownload) {
        if(folderDownload.exists()){
            Assert.fail("don't delete folder Armada");
            logger.warn("don't delete folder Armada");
        } else {
            Allure.step("correct delete folder Armada: " + folderDownload);
            logger.debug("correct delete folder Armada");
        }
    }
}
