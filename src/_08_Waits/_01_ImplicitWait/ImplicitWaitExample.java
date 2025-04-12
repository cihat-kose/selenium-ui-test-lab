package _08_Waits._01_ImplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utility.BaseDriver.driver;
import static utility.BaseDriver.waitAndClose;

public class ImplicitWaitExample {

    /**
     * _05_ExplicitWaitDynamicLoading: Wait for first product to load using Implicit Wait
     */
    @Test
    public void implicitWaitTask() {
        driver.get("https://www.saucedemo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));
        System.out.println("First Product: " + firstProduct.getText());

        Assert.assertTrue("First product is not visible!", firstProduct.isDisplayed());

        waitAndClose();
    }
}
