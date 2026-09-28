package _15_FileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestResources;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Opens the native operating-system file picker and selects a shared project file with Robot.
 * This demonstrates OS-level input; it is intentionally separate from WebElement.sendKeys(path).
 */
public class FileSelectionWithRobotTest extends BaseDriver {

    @Test
    public void selectsAndSubmitsAFileUsingTheNativePicker() throws Exception {
        useExplicitWaitsOnly();
        openFixture("robot-file-upload.html");

        String filePath = TestResources.path("upload-sample.txt").toAbsolutePath().toString();
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new StringSelection(filePath), null);

        // Click the file control so we do not guess how many TAB presses reach it.
        driver.findElement(By.id("upload-file")).click();

        // The native dialog is outside WebDriver. Its default keyboard focus varies by OS.
        Robot robot = new Robot();
        robot.setAutoDelay(100);
        robot.waitForIdle();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement selectedFile = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("selected-file")));
        wait.until(d -> "upload-sample.txt".equals(selectedFile.getText()));

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit-upload")).click();
        Assert.assertEquals("File selected and form submitted.",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload-status"))).getText());

        waitAndClose();
    }
}
