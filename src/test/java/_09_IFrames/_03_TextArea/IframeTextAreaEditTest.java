package _09_IFrames._03_TextArea;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.nio.file.Paths;

public class IframeTextAreaEditTest extends BaseDriver {

    /**
     * Open the local page, switch into its iframe, replace the textarea content,
     * verify the new value, and return to the main document.
     */
    @Test
    public void editTextareaInIframe() {
        driver.get(Paths.get("src/test/resources/iframe-textarea.html")
                .toAbsolutePath().toUri().toString());

        // Wait for the frame and switch into it before searching for the textarea.
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("textarea-frame")));

        // Alternative ways to switch to this frame:
        // driver.switchTo().frame(driver.findElement(By.id("textarea-frame")));
        // driver.switchTo().frame("textarea-frame");
        // driver.switchTo().frame(0);
        WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.id("review")));
        textArea.click();
        // Select the existing value before typing so the test replaces it instead of appending.
        textArea.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This text was changed with Selenium!");
        Assert.assertEquals("This text was changed with Selenium!", textArea.getAttribute("value"));

        driver.switchTo().parentFrame();
        Assert.assertEquals("Iframe and textarea practice", driver.getTitle());

        waitAndClose();
    }
}
