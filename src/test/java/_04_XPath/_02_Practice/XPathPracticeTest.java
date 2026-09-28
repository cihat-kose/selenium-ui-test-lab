package _04_XPath._02_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class XPathPracticeTest extends BaseDriver {

    @Test
    public void verifyTextBoxInputValues() {
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("automation@example.com");
        driver.findElement(By.xpath("//*[@placeholder='Current Address']")).sendKeys("123 Demo Street");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("123 Demo Street");

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        WebElement submittedName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='output']//*[@id='name']")));
        Assert.assertTrue(submittedName.getText().contains("Automation"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='output']//*[@id='email']")).getText()
                .contains("automation@example.com"));
    }

    @Test
    public void signInToApplitoolsDemo() {
        driver.get("https://demo.applitools.com/");

        // These are sample credentials for the public demo application, not personal credentials.
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ttechno@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("techno123.");
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();

        WebElement countdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[@id='time']")));
        Assert.assertTrue("Dashboard should show the branch closing countdown",
                countdown.getText().startsWith("Your nearest branch closes in:"));
    }
}
