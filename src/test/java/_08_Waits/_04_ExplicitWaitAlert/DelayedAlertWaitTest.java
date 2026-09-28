package _08_Waits._04_ExplicitWaitAlert;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertEquals;

public class DelayedAlertWaitTest extends BaseDriver {

    /**
     * Waits for a delayed native alert, checks its text, and verifies the page after accepting it.
     */
    @Test
    public void waitForAlert() {
        useExplicitWaitsOnly();
        openFixture("javascript-alerts.html");

        WebElement timerAlertButton = driver.findElement(By.id("timer-alert-button"));
        timerAlertButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after one second.", alert.getText());
        alert.accept();

        assertEquals("Delayed alert accepted.", wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result"))).getText());

        waitAndClose();
    }
}
