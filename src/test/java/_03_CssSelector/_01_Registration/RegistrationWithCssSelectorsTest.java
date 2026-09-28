package _03_CssSelector._01_Registration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.TestData;

public class RegistrationWithCssSelectorsTest extends BaseDriver {

    // Use fictional values for the public demo site; only the username must be unique.
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
    public void testRegisterWithCssSelectorsOnly() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement registerLink = driver.findElement(By.cssSelector("a[href*='register.htm']"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.cssSelector("input[name='customer.firstName']"));
        firstName.sendKeys(FIRST_NAME);

        // Periods are special in CSS, so dots in ParaBank's IDs must be escaped.
        WebElement lastName = driver.findElement(By.cssSelector("#customer\\.lastName"));
        lastName.sendKeys(LAST_NAME);

        WebElement address = driver.findElement(By.cssSelector("#customer\\.address\\.street"));
        address.sendKeys(STREET);

        WebElement city = driver.findElement(By.cssSelector("input[name='customer.address.city']"));
        city.sendKeys(CITY);

        WebElement state = driver.findElement(By.cssSelector("#customer\\.address\\.state"));
        state.sendKeys(REGION);

        WebElement zipCode = driver.findElement(By.cssSelector("#customer\\.address\\.zipCode"));
        zipCode.sendKeys(POSTAL_CODE);

        WebElement phone = driver.findElement(By.cssSelector("#customer\\.phoneNumber"));
        phone.sendKeys(PHONE);

        WebElement ssn = driver.findElement(By.cssSelector("#customer\\.ssn"));
        ssn.sendKeys(SSN);

        WebElement username = driver.findElement(By.cssSelector("#customer\\.username"));
        // ParaBank requires a new username on every registration attempt.
        username.sendKeys(TestData.uniqueUsername(FIRST_NAME + LAST_NAME));

        WebElement password = driver.findElement(By.cssSelector("#customer\\.password"));
        password.sendKeys(PASSWORD);

        WebElement confirmPassword = driver.findElement(By.cssSelector("#repeatedPassword"));
        confirmPassword.sendKeys(PASSWORD);

        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        registerButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".title")));
        String actualMessage = successMessage.getText();
        Assert.assertTrue("Registration failed; expected a welcome message but saw: " + actualMessage,
                actualMessage.contains("Welcome"));

        waitAndClose();
    }
}
