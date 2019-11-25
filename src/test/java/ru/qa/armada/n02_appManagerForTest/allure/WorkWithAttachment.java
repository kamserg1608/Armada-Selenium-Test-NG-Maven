package ru.qa.armada.n02_appManagerForTest.allure;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithAttachment {
    private static final String RESOURCES = "src/test/resources/attachments";
    private static final String JAVADOC = "src/test/resources/doc-files";
    private static final String SCREENSHOT = "target/screenshots";
    private static final String TEAMCITY = "";
    private static final String LOGTEXT = "target/logsSlf4j";
    private WorkWithAttachment() {
        throw new IllegalAccessError("Utility class");
    }

    @Attachment
    public static byte[] getBytesJavaDoc(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(JAVADOC, resourceName));
    }
    @Attachment
    public static byte[] getBytesTC(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(TEAMCITY, resourceName));
    }
    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(RESOURCES, resourceName));
    }
    @Attachment
    public static byte[] getBytesLog(String logName) throws IOException {
        return Files.readAllBytes(Paths.get(LOGTEXT, logName));
    }
    @Attachment(value = "{allureName}")
    public static byte[] getBytesScreenshot(String resourceName, String allureName) throws IOException {
        return Files.readAllBytes(Paths.get(SCREENSHOT, resourceName));
    }

    @Attachment(value = "Вложение", type = "text/plain", fileExtension = ".doc")
    public static byte[] getBytesAnnotationWithArgs(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(RESOURCES, resourceName));
    }
    public static void getScreen(String allureName) {
//        Steps.logToAllureWithValue("The screenshot below is attached: ", allureName);
        WorkWithScreenshot workWithScreenshot = new WorkWithScreenshot();
        workWithScreenshot.addScreenshotToAllure(allureName);
    }
    public static void getScreenWebdriver(String allureName) {
//        Steps.logToAllureWithValue("The screenshot below is attached: ", allureName);
        WorkWithScreenshot workWithScreenshot = new WorkWithScreenshot();
        workWithScreenshot.addScreenshotToAllureWebdriver(allureName);
    }
    public static void getScreenTestLeft(String allureName) {
        WorkWithScreenshot workWithScreenshot = new WorkWithScreenshot();
        workWithScreenshot.addScreenshotToAllureTestLeft(allureName);
    }
}
