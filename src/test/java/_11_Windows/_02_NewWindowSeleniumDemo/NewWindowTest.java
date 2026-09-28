package _11_Windows._02_NewWindowSeleniumDemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NewWindowTest extends BaseDriver {

    @Test
    public void newWindowTest() {
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");

        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Open new window")).click();
        // Wait for the new browsing context before collecting its handle.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = allWindows.stream()
                .filter(window -> !window.equals(mainWindow))
                .findFirst()
                .orElseThrow(() -> new AssertionError("The new window was not opened."));
        // Switch explicitly so title checks run against the new window.
        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.titleIs("Simple Page"));
        assertEquals("Simple Page", driver.getTitle());

        driver.close();
        driver.switchTo().window(mainWindow);
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        assertEquals(1, driver.getWindowHandles().size());

        waitAndClose();
    }
}
