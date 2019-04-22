package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;
import java.io.FilenameFilter;

public class FindExtFile {
    private File folderDownload;
    private String passFolder;
    private FilenameFilter filter;

    public FindExtFile (String folderDownload, String filter){
        this.passFolder = folderDownload;
        this.folderDownload = new File(folderDownload);
        this.filter = new OnlyExt(filter);
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
            System.out.println("It is not possible to view the file list folder");
            System.out.println(e);
        }
        String firstExeFile = "";
        if (arrayFiles.length != 0) {
            firstExeFile = arrayFiles[0];
        }
        return firstExeFile;
    }
    public void checkFilesInDirectory(String dirname, File folderDownload) {
        if(folderDownload.isDirectory()) {
            System.out.println("Directory " + dirname);
            String s[] = folderDownload.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is it Directory");
                } else {
                    System.out.println(s[i] + " is it File");
                }
            }
        } else {
            System.out.println("Не является каталогом");
        }
    }
}
