package _08_Waits._02_ExplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DuckDuckGoExplicitWaitExample extends BaseDriver {

    /**
     * Validate a DuckDuckGo result using an explicit wait.
     */
    @Test
    public void searchAndVerifySeleniumResult() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium WebDriver" + Keys.ENTER);

        WebElement firstResultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div//h3)[1]")));

        String firstResultUrl = firstResultTitle.findElement(By.xpath("./ancestor::a[1]")).getAttribute("href");
        System.out.println("First result URL: " + firstResultUrl);

        Assert.assertTrue("First result should refer to Selenium: " + firstResultUrl,
                firstResultUrl.toLowerCase().contains("selenium"));

        waitAndClose();
    }
}
