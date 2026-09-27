package _07_Alerts._01_DemoQAAlertWait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DemoQAAlertWaitTest extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading: Timely Alert Capture with Explicit Wait
     */
    @Test
    public void waitForAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        waitAndClose();
    }
}
