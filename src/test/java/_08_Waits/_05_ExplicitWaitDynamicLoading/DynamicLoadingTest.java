package _08_Waits._05_ExplicitWaitDynamicLoading;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class DynamicLoadingTest extends BaseDriver {

    /**
     * Task: Waiting for Dynamic Content with Explicit Wait
     */
    @Test
    public void explicitWaitButtonTask() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start button")));
        startButton.click();

        // The page adds this heading after loading, so wait for it to become visible.
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        System.out.println("helloWorldText.getText() = " + helloWorldText.getText());
        Assert.assertTrue("'Hello World!' text is not visible!", helloWorldText.isDisplayed());
        Assert.assertEquals("Unexpected text appeared", "Hello World!", helloWorldText.getText());

        waitAndClose();
    }
}
