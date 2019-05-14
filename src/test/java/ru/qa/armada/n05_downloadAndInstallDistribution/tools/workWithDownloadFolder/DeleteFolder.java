package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void deleteFolder(){
        if (folderDownload.isDirectory()) {
            if(folderDownload.list().length != 0 ){
                long start = System.currentTimeMillis();
                try {
                    FileUtils.deleteDirectory(folderDownload );
                } catch (IOException e) {
                    logger.debug("directory cannot be deleted");
                    logger.debug(e.toString());
                }
                if(folderDownload.exists()){
                    logger.debug("delay work not correct");
                }
                long end = System.currentTimeMillis();
                logger.debug("time spent deleting a folder {} {}", passFolder, (end - start));
            }
        }
    }
}
