package _15_FileUpload._02_WebDriverLetcode;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.nio.file.Paths;

/**
 * Comparison example for native file-picker interaction with Robot.
 * The WebDriver sendKeys approach provides the full path to the HTML file input;
 * it does not open a desktop file picker and is generally more stable for browser automation.
 */
public class FileUploadWithWebDriverLetcode extends BaseDriver {

    @Test
    public void uploadFileUsingWebDriver() {
        driver.get("https://letcode.in/file");

        String filePath = Paths.get("src", "test", "resources", "upload-sample.txt")
                .toAbsolutePath().toString();
        // Selenium sends the local file path directly to the input[type=file] field.
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(filePath);

        Assert.assertTrue("File was not selected", fileInput.getAttribute("value").contains("upload-sample.txt"));
        waitAndClose();
    }
}
