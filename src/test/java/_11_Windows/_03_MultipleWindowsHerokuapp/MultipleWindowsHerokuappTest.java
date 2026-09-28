package _11_Windows._03_MultipleWindowsHerokuapp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MultipleWindowsHerokuappTest extends BaseDriver {

    /**
     * Example: Switching between multiple windows on Herokuapp
     */
    @Test
    public void switchBetweenWindows() {
        useExplicitWaitsOnly();
        driver.get("https://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = allWindows.stream()
                .filter(window -> !window.equals(originalWindow))
                .findFirst()
                .orElseThrow(() -> new AssertionError("The new window was not opened."));
        driver.switchTo().window(newWindow);

        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        assertEquals("New Window", heading.getText());

        // Switch back to the original window and verify its title.
        driver.switchTo().window(originalWindow);
        assertEquals("The Internet", driver.getTitle());

        waitAndClose();
    }
}
