package ru.qa.armada.n04_tests.allure;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonFunctions {
    private static final String RESOURCES = "src/test/resources/attachments";
    private static final String JAVADOC = "src/test/resources/doc-files";
    private static final String SCREENSHOT = "target/screenshots";

    private CommonFunctions() {
        throw new IllegalAccessError("Utility class");
    }

    @Attachment
    public static byte[] getBytesJavaDoc(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(JAVADOC, resourceName));
    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(RESOURCES, resourceName));
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
        Steps.logToAllureWithValue("The screenshot below is attached: ", allureName);
        WorkWithScreenshot workWithScreenshot = new WorkWithScreenshot();
        workWithScreenshot.addScreenshotToAllure(allureName);
    }
}
