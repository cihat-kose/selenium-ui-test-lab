package _04_XPath;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class RegisterUsingXPath extends BaseDriver {

    @Test
    public void testRegisterWithXPathOnly() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement registerLink = driver.findElement(By.xpath("//a[contains(@href, 'register.htm')]"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
        firstName.sendKeys("Ahmet");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lastName.sendKeys("Yilmaz");

        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("123 Main Street");

        WebElement city = driver.findElement(By.xpath("//input[@name='customer.address.city']"));
        city.sendKeys("Istanbul");

        WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        state.sendKeys("Istanbul");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys("34000");

        WebElement phone = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phone.sendKeys("5551234567");

        WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys("123456789");

        WebElement username = driver.findElement(By.xpath("//input[@id='customer.username']"));
        username.sendKeys("user" + (int) (Math.random() * 10000));

        WebElement password = driver.findElement(By.xpath("//input[@id='customer.password']"));
        password.sendKeys("Password123");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirmPassword.sendKeys("Password123");

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
        registerButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = successMessage.getText();
        System.out.println("Message: " + actualMessage);

        Assert.assertTrue("Registration failed – success message not found!", actualMessage.contains("Welcome"));

        waitAndClose();
    }
}
