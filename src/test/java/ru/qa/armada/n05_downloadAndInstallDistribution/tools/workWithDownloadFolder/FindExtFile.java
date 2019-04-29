package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;
import java.io.FilenameFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindExtFile {
    private File folderDownload;
    private String passFolder;
    private FilenameFilter filter;
    private Logger logger;

    public FindExtFile (String folderDownload, String filter){
        this.passFolder = folderDownload;
        this.folderDownload = new File(folderDownload);
        this.filter = new OnlyExt(filter);
        this.logger = LoggerFactory.getLogger(FindExtFile.class);
    }

    public String passToInstaller(){
        String fullPassInstaller = passFolder + "\\" + takeFirstExeDistribution();
        return fullPassInstaller;
    }

    public String takeFirstExeDistribution(){
        String arrayFiles[] = new String[0];
        try {
            if(folderDownload.isDirectory()){
                arrayFiles = folderDownload.list(filter);
            }
        } catch (Exception e) {
            logger.info("It is not possible to view the file list folder");
            logger.info(e.toString());
        }
        String firstExeFile = "";
        if (arrayFiles.length != 0) {
            firstExeFile = arrayFiles[0];
        }
        return firstExeFile;
    }
    public void checkFilesInDirectory(String dirname, File folderDownload) {
        if(folderDownload.isDirectory()) {
            logger.info("Directory {}",dirname);
            String s[] = folderDownload.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    logger.info("{} is it Directory", s[i]);
                } else {
                    logger.info("{} is it File", s[i]);
                }
            }
        } else {
            logger.debug("Не является каталогом");
        }
    }
}
