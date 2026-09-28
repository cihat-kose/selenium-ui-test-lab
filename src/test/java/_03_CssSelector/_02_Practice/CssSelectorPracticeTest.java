package _03_CssSelector._02_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class CssSelectorPracticeTest extends BaseDriver {

    @Test
    public void verifyTextBoxInputValues() {
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.cssSelector("[placeholder='Full Name']")).sendKeys("Automation");
        driver.findElement(By.cssSelector("[placeholder='name@example.com']")).sendKeys("automation@example.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("123 Demo Street");
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("123 Demo Street");

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector("#submit")).click();

        WebElement submittedName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#output #name")));
        Assert.assertTrue(submittedName.getText().contains("Automation"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#output #email")).getText()
                .contains("automation@example.com"));
    }

    @Test
    public void signInToApplitoolsDemo() {
        driver.get("https://demo.applitools.com/");

        // These are sample credentials for the public demo application, not personal credentials.
        driver.findElement(By.cssSelector("#username")).sendKeys("ttechno@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("techno123.");
        driver.findElement(By.cssSelector("#log-in")).click();

        WebElement countdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h6#time")));
        Assert.assertTrue("Dashboard should show the branch closing countdown",
                countdown.getText().startsWith("Your nearest branch closes in:"));
    }

}
