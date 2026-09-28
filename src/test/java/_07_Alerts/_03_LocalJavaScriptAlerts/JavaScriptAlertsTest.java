package _07_Alerts._03_LocalJavaScriptAlerts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertEquals;

/** Handles native JavaScript alert, confirmation, prompt, and context-menu dialogs locally. */
public class JavaScriptAlertsTest extends BaseDriver {

    @Before
    public void configureExplicitWaits() {
        useExplicitWaitsOnly();
    }

    @Test
    public void handleSimpleJSAlertTest() {
        openFixture("javascript-alerts.html");
        driver.findElement(By.id("alert-button")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This is a JavaScript alert.", alert.getText());
        alert.accept();

        assertEquals("Alert accepted.", wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result"))).getText());
        waitAndClose();
    }

    @Test
    public void handleJSConfirmAlertTest() {
        openFixture("javascript-alerts.html");
        driver.findElement(By.id("confirm-button")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This is a JavaScript confirmation.", alert.getText());
        alert.dismiss();

        assertEquals("You clicked: Cancel", wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result"))).getText());
        waitAndClose();
    }

    @Test
    public void handleJSPromptAlertTest() {
        openFixture("javascript-alerts.html");
        driver.findElement(By.id("prompt-button")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Enter a short message.", alert.getText());
        alert.sendKeys("Hello, Selenium");
        alert.accept();

        assertEquals("You entered: Hello, Selenium", wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result"))).getText());
        waitAndClose();
    }

    @Test
    public void handleRightClickAlertTest() {
        openFixture("javascript-alerts.html");

        WebElement rightClickArea = driver.findElement(By.id("context-area"));
        new Actions(driver).contextClick(rightClickArea).perform();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("The context area was right-clicked.", alert.getText());
        alert.accept();

        assertEquals("Context alert accepted.", wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result"))).getText());
        waitAndClose();
    }
}
