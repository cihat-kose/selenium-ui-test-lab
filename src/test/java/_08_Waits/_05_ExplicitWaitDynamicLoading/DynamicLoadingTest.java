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

        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        System.out.println("helloWorldText.getText() = " + helloWorldText.getText());
        Assert.assertTrue("'Hello World!' text is not visible!", helloWorldText.isDisplayed());

        waitAndClose();
    }
}
