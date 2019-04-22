package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithDownloadFolder;

import java.io.File;
import java.io.FilenameFilter;

public class OnlyExt implements FilenameFilter {
    private String nameOfFormat;

    public OnlyExt(String nameOfFormat) {
        this.nameOfFormat = "." + nameOfFormat;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(nameOfFormat);
    }
}
