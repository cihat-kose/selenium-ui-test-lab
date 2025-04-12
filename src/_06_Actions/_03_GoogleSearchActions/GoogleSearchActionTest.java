package _06_Actions._03_GoogleSearchActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class GoogleSearchActionTest extends BaseDriver {

    @Test
    public void searchAndVerifySeleniumResult() {
        driver.get("https://google.com");

        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        WebElement searchInput = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(searchInput)
                .click()
                .sendKeys("selenium" + Keys.ENTER)
                .build();
        action.perform();

        WebElement firstResult = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));

        String resultText = firstResult.getText();
        Assert.assertEquals("Selenium", resultText);
        Assert.assertTrue(resultText.toLowerCase().contains("selenium"));

        waitAndClose();
    }
}
