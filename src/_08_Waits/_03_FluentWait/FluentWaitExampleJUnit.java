package _08_Waits._03_FluentWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import utility.BaseDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitExampleJUnit extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading: Wait for dynamic text using Fluent Wait
     */
    @Test
    public void fluentWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement helloWorldText = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
                if (element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });

        Assert.assertNotNull("Element was not found!", helloWorldText);
        Assert.assertTrue("'Hello World!' is not visible!", helloWorldText.isDisplayed());

        System.out.println("Test Passed: 'Hello World!' appeared on the page.");

        waitAndClose();
    }
}
