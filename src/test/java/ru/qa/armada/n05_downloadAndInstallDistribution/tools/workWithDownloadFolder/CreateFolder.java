package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;

/**
 * <h1>Use for create a "Armada" download directory</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class CreateFolder {
    private final String passFolder;
    public long start, end;
    private File folderDownload;
    private Logger logger;

    public CreateFolder(String passFolder) {
        this.passFolder = passFolder;
        this.folderDownload= new File(this.passFolder);
        this.logger = LoggerFactory.getLogger(CreateFolder.class);
    }

    /**
     * Create directory
     */
    @Step("create directory")
    public void createDirectory() {
        boolean statusOfCreate = folderDownload.mkdirs();
        checkCreateDirectory(statusOfCreate);
    }

    private void checkCreateDirectory(boolean statusOfCreate) {
        if (statusOfCreate) {
            Allure.step("Correct create directory: " + passFolder);
            logger.debug("Correct create directory: {}", passFolder);
        } else {
            Assert.fail("Don't correct create directory");
            logger.error("Don't correct create directory: {}", passFolder);
        }
    }
}
