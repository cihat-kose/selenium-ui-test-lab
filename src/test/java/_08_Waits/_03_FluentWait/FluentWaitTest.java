package _08_Waits._03_FluentWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utility.BaseDriver;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitTest extends BaseDriver {

    /**
     * Wait for dynamic text using Fluent Wait
     */
    @Test
    public void fluentWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start button")));
        startButton.click();

        // FluentWait controls both the total timeout and how often the condition is checked.
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // The message is added dynamically, so retry lookup until it is present and visible.
        WebElement helloWorldText = fluentWait.until(currentDriver -> {
            WebElement element = currentDriver.findElement(By.cssSelector("#finish h4"));
            return element.isDisplayed() ? element : null;
        });

        Assert.assertTrue("'Hello World!' is not visible!", helloWorldText.isDisplayed());
        Assert.assertEquals("Unexpected text appeared", "Hello World!", helloWorldText.getText());

        System.out.println("Test Passed: 'Hello World!' appeared on the page.");

        waitAndClose();
    }
}
