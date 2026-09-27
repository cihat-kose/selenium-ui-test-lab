package _12_RobotClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.nio.file.Paths;

/**
 * Selects the same shared file by sending its path directly to input[type=file].
 * Unlike the Robot lesson, this approach does not open an operating-system dialog.
 */
public class FileUploadWithWebDriver extends BaseDriver {

    @Test
    public void selectsAFileWithWebDriver() {
        driver.get(Paths.get("src/test/resources/robot-file-upload.html")
                .toAbsolutePath().toUri().toString());

        String filePath = Paths.get("src/test/resources/upload-sample.txt")
                .toAbsolutePath().toString();
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(filePath);

        WebElement selectedFile = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("selected-file")));
        Assert.assertEquals("upload-sample.txt", selectedFile.getText());
        waitAndClose();
    }
}
