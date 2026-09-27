package _09_IFrames._02_IframeText;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IframeTextCheckTest extends BaseDriver {

    @Test
    public void printIframeContent() {
        driver.get("https://www.selenium.dev/selenium/web/iframes.html");

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframe1")));
        driver.switchTo().frame(iframe);

        assertTrue("Expected iframe content was not loaded.",
                driver.getPageSource().contains("We Leave From Here"));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("student@example.com");
        assertEquals("student@example.com", email.getAttribute("value"));

        driver.switchTo().defaultContent();
        assertTrue("Expected main-page content was not restored.",
                driver.getPageSource().contains("This page has iframes"));

        waitAndClose();
    }
}
