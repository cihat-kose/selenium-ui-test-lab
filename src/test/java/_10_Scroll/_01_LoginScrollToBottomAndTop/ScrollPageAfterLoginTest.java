package _10_Scroll._01_LoginScrollToBottomAndTop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScrollPageAfterLoginTest extends BaseDriver {

    /**
     * Task: Scroll to Bottom and Top after Login
     */
    @Test
    public void scrollPageAfterLogin() {
        useExplicitWaitsOnly();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));

        user.sendKeys("Admin");
        pass.sendKeys("admin123");
        login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar")));
        assertTrue("A successful login should open the dashboard.", driver.getCurrentUrl().contains("/dashboard"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
        assertTrue("The browser should reach the bottom of the page.", wait.until(d -> (Boolean)
                js.executeScript("return Math.ceil(window.scrollY + window.innerHeight) >= "
                        + "document.documentElement.scrollHeight")));

        js.executeScript("window.scrollTo(0, 0)");
        wait.until(d -> ((Number) js.executeScript("return window.scrollY")).longValue() == 0L);
        assertEquals("The browser should return to the top of the page.", 0L,
                ((Number) js.executeScript("return window.scrollY")).longValue());

        waitAndClose();
    }
}
