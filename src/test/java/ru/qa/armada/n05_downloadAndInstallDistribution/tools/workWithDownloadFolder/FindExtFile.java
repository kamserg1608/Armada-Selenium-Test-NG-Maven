package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;
import java.io.FilenameFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * <h1>Searches for the first "distributionArmada.exe" file in the extracted folder</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
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

    /**
     * Returns the full path to the file
     * @return returns the full path to the file
     */
    public String passToInstaller(){
        String fullPassInstaller = passFolder + "\\" + takeFirstExeDistribution();
        return fullPassInstaller;
    }

    /**
     * Searches for the first "exe" file in the extracted folder
     *
     * @return path to the first "exe" file
     */
    public String takeFirstExeDistribution(){
        String arrayFiles[] = new String[0];
        try {
            if(folderDownload.isDirectory()){
                arrayFiles = folderDownload.list(filter);
            }
        } catch (Exception e) {
            Assert.fail("It is not possible to view the file list folder");
            logger.error("It is not possible to view the file list folder");
            logger.error(e.toString());
        }
        String firstExeFile = "";
        if (arrayFiles.length != 0) {
            firstExeFile = arrayFiles[0];
        }
        return firstExeFile;
    }

    /**
     * Checks for what this file is it
     *
     * @param dirname folder or file name
     * @param folderDownload location of file or folder
     */
    public void checkFilesInDirectory(String dirname, File folderDownload) {
        if(folderDownload.isDirectory()) {
            logger.debug("Directory {}",dirname);
            String s[] = folderDownload.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    logger.debug("{} is it Directory", s[i]);
                } else {
                    logger.debug("{} is it File", s[i]);
                }
            }
        } else {
            logger.debug("Not a directory");
        }
    }
}
