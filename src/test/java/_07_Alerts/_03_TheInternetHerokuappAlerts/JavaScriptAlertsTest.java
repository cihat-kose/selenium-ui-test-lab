package _07_Alerts._03_TheInternetHerokuappAlerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class JavaScriptAlertsTest extends BaseDriver {

    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @Test
    public void acceptSimpleAlert() {
        openJavaScriptAlertsPage();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("I am a JS Alert", alert.getText());
        alert.accept();

        Assert.assertEquals("You successfully clicked an alert", driver.findElement(By.id("result")).getText());
        waitAndClose(); // Intentional pause to inspect the result during this lesson.
    }

    @Test
    public void dismissConfirmationAlert() {
        openJavaScriptAlertsPage();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("I am a JS Confirm", alert.getText());
        alert.dismiss();

        Assert.assertEquals("You clicked: Cancel", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void enterTextInPromptAlert() {
        openJavaScriptAlertsPage();
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("I am a JS prompt", alert.getText());
        alert.sendKeys("Hello, Selenium");
        alert.accept();

        Assert.assertEquals("You entered: Hello, Selenium", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void acceptContextMenuAlert() {
        driver.get(BASE_URL + "context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        new Actions(driver).contextClick(hotSpot).perform();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("You selected a context menu", alert.getText());
        alert.accept();
    }

    private void openJavaScriptAlertsPage() {
        driver.get(BASE_URL);
        driver.findElement(By.linkText("JavaScript Alerts")).click();
    }
}
