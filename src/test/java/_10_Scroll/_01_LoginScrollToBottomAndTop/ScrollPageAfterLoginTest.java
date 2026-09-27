package _10_Scroll._01_LoginScrollToBottomAndTop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class ScrollPageAfterLoginTest extends BaseDriver {

    /**
     * Task: Scroll to Bottom and Top after Login
     */
    @Test
    public void scrollPageAfterLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement user = driver.findElement(By.cssSelector("[name='username']"));
        WebElement pass = driver.findElement(By.cssSelector("[name='password']"));
        WebElement login = driver.findElement(By.cssSelector("[type='submit']"));

        user.sendKeys("Admin");
        pass.sendKeys("admin123");
        login.click();

        WebElement topBar = driver.findElement(By.cssSelector("[class='oxd-topbar']"));
        wait.until(ExpectedConditions.visibilityOf(topBar));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        waitAndClose();
    }
}
