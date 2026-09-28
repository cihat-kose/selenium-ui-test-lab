package _01_SeleniumIntro;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestData;

public class NinjaRegisterTest extends BaseDriver {

    // Use fictional contact details; only the email needs to be unique for repeatable registrations.
    private static final String FIRST_NAME = "Kerem";
    private static final String LAST_NAME = "Said";
    private static final String TELEPHONE = "2025550143"; // Reserved fictional 555-01xx number.
    private static final String PASSWORD = "NinjaDemo!2026"; // Demo-only credential; never use for a real account.

    @Test
    public void registerTest() {
        driver.get("https://tutorialsninja.com/demo/");

        // Open the registration form from the account menu.
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys(LAST_NAME);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(TestData.uniqueExampleEmail(FIRST_NAME + "." + LAST_NAME));

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys(TELEPHONE);

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys(PASSWORD);

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys(PASSWORD);

        // The demo site requires explicit privacy-policy consent before account creation.
        WebElement privacyPolicy = driver.findElement(By.name("agree"));
        privacyPolicy.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))).getText();
        Assert.assertEquals("Your Account Has Been Created!", successMessage);

        waitAndClose();
    }
}
