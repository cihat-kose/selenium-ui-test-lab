package _08_Waits._01_ImplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.time.Duration;

public class ImplicitWaitTest extends BaseDriver {

    /** Waits up to ten seconds for elements found through WebDriver. */
    @Test
    public void implicitWaitTask() {
        driver.get("https://www.saucedemo.com/");

        // Implicit wait applies to element lookups made after this setting.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // findElement waits up to ten seconds for the inventory to appear.
        WebElement firstProduct = driver.findElement(By.cssSelector(".inventory_item"));
        String productName = firstProduct.findElement(By.cssSelector(".inventory_item_name")).getText();
        System.out.println("First Product: " + productName);

        Assert.assertTrue("First product is not visible!", firstProduct.isDisplayed());
        Assert.assertFalse("First product name should not be empty!", productName.isBlank());

        waitAndClose();
    }
}
