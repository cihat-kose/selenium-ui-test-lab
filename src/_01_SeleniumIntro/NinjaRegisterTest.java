package _01_SeleniumIntro;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class NinjaRegisterTest extends BaseDriver {

    @Test
    public void registerTest() {
        driver.get("http://tutorialsninja.com/demo/");

        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Kerem");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Said");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("test" + ((int) (Math.random() * 10000)) + "@test.com");

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("1234567890");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Password123");

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("Password123");

        WebElement privacyPolicy = driver.findElement(By.name("agree"));
        privacyPolicy.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMessage.isDisplayed());

        waitAndClose();
    }
}
