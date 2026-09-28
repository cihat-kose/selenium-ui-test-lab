package _04_XPath._01_Registration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestData;

public class RegistrationWithXPathTest extends BaseDriver {

    // Fictional information keeps this public demo account separate from real personal data.
    private static final String FIRST_NAME = "Kerem";
    private static final String LAST_NAME = "Said";
    private static final String STREET = "123 Demo Street";
    private static final String CITY = "Trondheim";
    private static final String REGION = "Trondelag";
    private static final String POSTAL_CODE = "7013";
    private static final String PHONE = "2025550143"; // Reserved fictional 555-01xx number.
    private static final String SSN = "999999999"; // Clearly synthetic; used only to satisfy the demo form.
    private static final String PASSWORD = "ParaBankDemo!2026"; // Demo-only; never use for a real account.

    @Test
    public void testRegisterWithXPathOnly() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement registerLink = driver.findElement(By.xpath("//a[contains(@href, 'register.htm')]"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lastName.sendKeys(LAST_NAME);

        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys(STREET);

        WebElement city = driver.findElement(By.xpath("//input[@name='customer.address.city']"));
        city.sendKeys(CITY);

        WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        state.sendKeys(REGION);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys(POSTAL_CODE);

        WebElement phone = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phone.sendKeys(PHONE);

        WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys(SSN);

        WebElement username = driver.findElement(By.xpath("//input[@id='customer.username']"));
        // ParaBank requires a new username on every registration attempt.
        username.sendKeys(TestData.uniqueUsername(FIRST_NAME + LAST_NAME));

        WebElement password = driver.findElement(By.xpath("//input[@id='customer.password']"));
        password.sendKeys(PASSWORD);

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirmPassword.sendKeys(PASSWORD);

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
        registerButton.click();

        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[@class='title']"))).getText();
        Assert.assertTrue("Registration failed; expected a welcome message but saw: " + actualMessage,
                actualMessage.contains("Welcome"));

        // Intentional observation pause for this lesson; README explains why it is not synchronization.
        waitAndClose();
    }
}
