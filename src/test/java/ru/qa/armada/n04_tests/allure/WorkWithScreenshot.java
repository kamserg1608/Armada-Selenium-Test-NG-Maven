package ru.qa.armada.n04_tests.allure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkWithScreenshot {
    private Rectangle virtualBounds;
    private GraphicsEnvironment ge;
    private String mainPath;
    private String screenshotName;
    private File folderDownload;


    public WorkWithScreenshot() {
        this.virtualBounds = new Rectangle();
        this.ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss__a");
        this.screenshotName = formatter.format(now.getTime()) + ".jpg";

        String relativePath = "\\target\\screenshots\\";
        this.mainPath = System.getProperty("user.dir");
        this.mainPath = mainPath.concat(relativePath).replace("\\","\\\\");

        this.folderDownload= new File(mainPath);

    }

    private void takeDimensions(){
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (GraphicsDevice gd : gs) {
            GraphicsConfiguration[] gc = gd.getConfigurations();
            for (GraphicsConfiguration graphicsConfiguration : gc) {
                virtualBounds = virtualBounds.union(graphicsConfiguration.getBounds());
            }
        }
    }

    private void getScreenshot(){
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(virtualBounds);
            folderDownload.mkdirs();
            String wayToScreenshots = mainPath + screenshotName;
            ImageIO.write(screenShot, "JPG", new File(wayToScreenshots));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addScreenshotToAllure(String allureName){

        takeDimensions();
        getScreenshot();

        try {
            WorkWithAttachment.getBytesScreenshot(this.screenshotName, allureName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






