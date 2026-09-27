package _08_Waits._04_ExplicitWaitAlert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class AlertHandlingTest extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading: Handling Timed Alert with Explicit Wait
     */
    @Test
    public void waitForAlert() {
        driver.get("https://demoqa.com/alerts");

        // Click the button that triggers an alert after 5 seconds
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        waitAndClose();
    }
}
