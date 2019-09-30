package ru.qa.armada.n05_downloadAndInstallDistribution.tools.unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


/**
 * <h1>Used to extract the archive</h1>
 *
 * @author KamyninSA
 * @version 1.0
 */
public class UnzippingArmada {
    private String fullPathtoUnzip;
    private String fullPassToZip;
    private Logger logger;

    public UnzippingArmada(String fullPassToZip, String fullPathtoUnzip){
        this.fullPassToZip = fullPassToZip;
        this.fullPathtoUnzip = fullPathtoUnzip;
        this.logger = LoggerFactory.getLogger(UnzippingArmada.class);
    }

    /**
     * the code allowing unzip to subpacks is taken from "stackoverflow"
     *
     * <h3>Uses the following functions.</h3>
     * <div>
     *   <ul>
     *     <li> Use the {@link #unzippind() } method.</li>
     *   </ul>
     * </div>
     */
    @Step(value = "Unzip distribution")
    public void unzippind(){
        logger.debug("Start unzipping distribution");
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
            logger.error("file unzip error");
            Assert.fail("file unzip error");
            e.printStackTrace();
        }
        logger.debug("Stop unzipping distribution");
        checkUnzipApplicationFromTeamCity(destDir);

    }

    private File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    private void checkUnzipApplicationFromTeamCity(File destDir) {
        if(destDir.list().length != 0){
            Allure.step("correct unzip application: " + fullPathtoUnzip, Status.PASSED);
            logger.debug("Unzip {}", fullPathtoUnzip);
        } else {
            Assert.fail("No correct unzip application");
            logger.error("No Unzip {}", fullPathtoUnzip);
        }
    }
}

