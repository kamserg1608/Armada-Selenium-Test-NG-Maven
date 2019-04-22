package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DeleteFolder {
    private File folderDownload;
    private String passFolder;

    public DeleteFolder(String folderDownload) {
        this.passFolder = folderDownload;
        this.folderDownload = new File(folderDownload);
    }

    public void deleteFolder(){
        if (folderDownload.isDirectory()) {
            if(folderDownload.list().length != 0 ){
                long start = System.currentTimeMillis();
                try {
                    FileUtils.deleteDirectory(folderDownload );
                } catch (IOException e) {
                    System.out.println("directory cannot be deleted");
                    System.out.println(e);
                }
                if(folderDownload.exists()){
                    System.out.println("delay work not correct");
                }
                long end = System.currentTimeMillis();
                System.out.println("Время затраченное на удаление папки " + passFolder + "= " + (end - start));
            }
        }
    }
}
