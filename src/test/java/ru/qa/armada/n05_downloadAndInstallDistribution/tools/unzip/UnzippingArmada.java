package ru.qa.armada.n05_downloadAndInstallDistribution.tools.unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnzippingArmada {
    private String fullPathtoUnzip;
    private String fullPassToZip;
    private Logger logger;

    public UnzippingArmada(String fullPassToZip, String fullPathtoUnzip){
        this.fullPassToZip = fullPassToZip;
        this.fullPathtoUnzip = fullPathtoUnzip;
        this.logger = LoggerFactory.getLogger(UnzippingArmada.class);
    }

    public boolean unzippind(){
        File destDir = null;
        try {
            destDir = new File(fullPathtoUnzip);
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fullPassToZip));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            logger.info("file unzip error");
            logger.info(e.toString());
        }
        return (Objects.requireNonNull(destDir.list()).length != 0);
    }

    public File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}

