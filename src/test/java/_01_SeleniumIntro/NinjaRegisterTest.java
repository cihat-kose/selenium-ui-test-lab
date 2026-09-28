package _01_SeleniumIntro;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestData;

public class NinjaRegisterTest extends BaseDriver {

    @Test
    public void registerTest() {
        useExplicitWaitsOnly();
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
        email.sendKeys(TestData.uniqueExampleEmail());

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

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Your Account Has Been Created!']")));
        Assert.assertTrue(successMessage.isDisplayed());

        waitAndClose();
    }
}
