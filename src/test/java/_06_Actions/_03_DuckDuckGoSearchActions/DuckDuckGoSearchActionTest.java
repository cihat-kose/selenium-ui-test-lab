package _06_Actions._03_DuckDuckGoSearchActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DuckDuckGoSearchActionTest extends BaseDriver {

    @Test
    public void searchAndVerifySeleniumResult() {
        useExplicitWaitsOnly();
        driver.get("https://duckduckgo.com/");

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(searchInput)
                .click()
                .sendKeys("Selenium WebDriver" + Keys.ENTER)
                .build();
        action.perform();

        WebElement firstResultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div//h3)[1]")));
        String resultUrl = firstResultTitle.findElement(By.xpath("./ancestor::a[1]")).getAttribute("href");
        Assert.assertTrue("First result should refer to Selenium: " + resultUrl,
                resultUrl.toLowerCase().contains("selenium"));

        waitAndClose();
    }
}
