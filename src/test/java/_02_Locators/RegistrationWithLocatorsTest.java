package _02_Locators;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestData;

public class RegistrationWithLocatorsTest extends BaseDriver {

    @Test
    public void testRegistration() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.name("customer.firstName"));
        firstName.sendKeys("Cihat");

        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Kose");

        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("Munkegata 1");

        WebElement city = driver.findElement(By.name("customer.address.city"));
        city.sendKeys("Trondheim");

        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("Trondelag");

        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("7013");

        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("5551234567");

        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("123456789");

        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys(TestData.uniqueUsername());

        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("Password123");

        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("Password123");

        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("title")));
        String actualMessage = successMessage.getText();
        System.out.println("Message: " + actualMessage);

        Assert.assertTrue("Registration failed – success message not found!", actualMessage.contains("Welcome"));

        waitAndClose();
    }
}
