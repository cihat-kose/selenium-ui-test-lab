package _08_Waits._02_ExplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class GoogleExplicitWaitExample extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading: Validate first Google result using Explicit Wait
     */
    @Test
    public void searchAndVerifySeleniumResult() {
        driver.get("https://google.com/");

        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("selenium" + Keys.ENTER);

        WebElement theFirstLink = driver.findElement(By.xpath("(//h3)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(theFirstLink));

        String firstResultText = theFirstLink.getText().toLowerCase();
        System.out.println("First Result: " + firstResultText);

        Assert.assertTrue("Result does not contain 'selenium'", firstResultText.contains("selenium"));

        waitAndClose();
    }
}
