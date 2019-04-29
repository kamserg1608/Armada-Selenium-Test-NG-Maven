package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteFolder {
    private File folderDownload;
    private String passFolder;
    private Logger logger;

    public DeleteFolder(String folderDownload) {
        this.passFolder = folderDownload;
        this.folderDownload = new File(folderDownload);
        this.logger = LoggerFactory.getLogger(DeleteFolder.class);
    }

    public void deleteFolder(){
        if (folderDownload.isDirectory()) {
            if(folderDownload.list().length != 0 ){
                long start = System.currentTimeMillis();
                try {
                    FileUtils.deleteDirectory(folderDownload );
                } catch (IOException e) {
                    logger.info("directory cannot be deleted");
                    logger.info(e.toString());
                }
                if(folderDownload.exists()){
                    logger.info("delay work not correct");
                }
                long end = System.currentTimeMillis();
                logger.info("Время затраченное на удаление папки {} {}", passFolder,(end - start));
            }
        }
    }
}
