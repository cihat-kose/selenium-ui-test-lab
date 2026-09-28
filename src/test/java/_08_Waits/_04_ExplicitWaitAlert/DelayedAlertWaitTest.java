package _08_Waits._04_ExplicitWaitAlert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DelayedAlertWaitTest extends BaseDriver {

    /**
     * Handling Timed Alert with Explicit Wait
     */
    @Test
    public void waitForAlert() {
        driver.get("https://demoqa.com/alerts");

        // This button opens a browser alert after a five-second delay.
        WebElement timerAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerAlertButton")));
        timerAlertButton.click();

        // Wait for the browser alert before reading its text and accepting it.
        var alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Unexpected alert text",
                alert.getText().contains("This alert appeared after 5 seconds"));
        alert.accept();

        waitAndClose();
    }
}
