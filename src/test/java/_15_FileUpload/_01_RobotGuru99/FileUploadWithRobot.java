package _15_FileUpload._01_RobotGuru99;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.nio.file.Paths;

/**
 * Demonstrates how to upload a file using Java's Robot class.
 * It simulates keyboard actions such as TAB, ENTER, and CTRL+V
 * to interact with the file picker and form elements.
 */

public class FileUploadWithRobot extends BaseDriver {

    @Test
    public void uploadFileUsingRobotTest() throws AWTException {
        driver.get("http://demo.guru99.com/test/upload/");
        // Allow dynamic elements such as the consent prompt to appear after the page loads.
        MyFunction.wait(1);

        // Accept the consent prompt if it appears.
        List<WebElement> acceptAllFrame = driver.findElements(By.id("gdpr-consent-notice"));
        if (!acceptAllFrame.isEmpty()) {
            driver.switchTo().frame(acceptAllFrame.get(0));

            List<WebElement> acceptAll =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Accept All']")));

            if (!acceptAll.isEmpty())
                acceptAll.get(0).click();

            // Selenium does not return to the main page automatically; the file input is there.
            driver.switchTo().defaultContent();
        }

        // This page hides the actual file input, so use the tab order to focus the native button.
        // The WebDriver sendKeys alternative is shown in FileUploadWithWebDriverLetcode.
        Robot robot = new Robot();
        robot.setAutoDelay(100);
        for (int i = 0; i < 15; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait briefly because Selenium cannot observe the native file picker opening.
        MyFunction.wait(1);

        // Copy the absolute path of the shared test file to the clipboard.
        // The fixture is in the repository, so students do not need to change the path for their computer.
        StringSelection filePath = new StringSelection(
                Paths.get("src", "test", "resources", "upload-sample.txt").toAbsolutePath().toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        // Wait for the file name field to be ready for the pasted path.
        MyFunction.wait(1);

        // Paste the file path with CTRL+V.
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Wait for the file picker to close and the selected file to appear in the page input.
        MyFunction.wait(1);

        for (int i = 0; i < 1; i++) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        MyFunction.wait(1);

        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        WebElement termsCheckbox = driver.findElement(By.id("terms"));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }

        // Demonstrate moving keyboard focus with Robot, then submit using a Selenium locator.
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        // Click the Submit File button to complete the form.
        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        // After submission, the success message appears in a center element.
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//center[contains(normalize-space(.), 'has been successfully uploaded.')]")));
        Assert.assertTrue("File upload failed", successMessage.isDisplayed());

        // Keep the browser open briefly so the result can be reviewed, then close it.
        waitAndClose();
    }
}
