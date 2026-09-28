package _07_Alerts._01_DemoQAAlertWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DemoQAAlertWaitTest extends BaseDriver {

    @Test
    public void acceptDelayedDemoQaAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();

        // The site shows this browser alert after a delay, so wait for the alert itself.
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Expected the delayed alert message", alert.getText().contains("This alert appeared after 5 seconds"));
        alert.accept();

        // Intentional observation pause for this lesson; see the README wait guidance.
        waitAndClose();
    }
}
