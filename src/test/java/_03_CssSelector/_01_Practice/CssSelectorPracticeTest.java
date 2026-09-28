package _03_CssSelector._01_Practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class CssSelectorPracticeTest extends BaseDriver {

    @Before
    public void configureExplicitWaits() {
        useExplicitWaitsOnly();
    }

    // Test 1: Demo QA Text Box Test
    @Test
    public void verifyTextBoxInputValues() {
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.cssSelector("[placeholder='Full Name']"));
        fullName.sendKeys("Automation");

        WebElement eMail = driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
        eMail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.cssSelector("[id='currentAddress']"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.cssSelector("[id='permanentAddress']"));
        permanentAddress.sendKeys("Testing Permanent Address");

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit")));
        submitButton.click();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#name"))).getText().contains("Automation"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#email")).getText().contains("Testing@gmail.com"));

//        waitAndClose();
    }

    // Test 2: Applitools Demo Login Test
    @Test
    public void signInToApplitoolsDemo() {
        driver.get("https://demo.applitools.com/");

        WebElement username = driver.findElement(By.cssSelector("[id='username']"));
        username.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("[id='password']"));
        password.sendKeys("techno123.");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='log-in']")));
        signInButton.click();

        WebElement verificationMessage = driver.findElement(By.cssSelector("h6[id='time']"));
        Assert.assertEquals("Your nearest branch closes in: 30m 5s", verificationMessage.getText());

//        waitAndClose();
    }

    // Test 3: Snapdeal Search Test
    @Test
    public void searchSnapdealForTeddyBear() {
        driver.get("https://www.snapdeal.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("[id='inputValEnter']"));
        searchBox.sendKeys("teddy bear");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[class='searchTextSpan']")));
        searchButton.click();

        WebElement confirmation = driver.findElement(By.cssSelector("[id='searchMessageContainer']"));
        Assert.assertTrue(confirmation.getText().contains("results for"));

//        waitAndClose();
    }

    // Test 4: TestPages Calculate Test
    @Test
    public void calculateAndVerifySum() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculatorButton = driver.findElement(By.cssSelector("[id='calculatetest']"));
        calculatorButton.click();

        WebElement input1Box = driver.findElement(By.cssSelector("[id='number1']"));
        input1Box.sendKeys("7");

        WebElement input2Box = driver.findElement(By.cssSelector("[id='number2']"));
        input2Box.sendKeys("6");

        WebElement calculator2Button = driver.findElement(By.cssSelector("[id='calculate']"));
        calculator2Button.click();

        WebElement result = driver.findElement(By.cssSelector("[id='answer']"));
        Assert.assertEquals("7 + 6 should equal 13.", "13", result.getText().trim());

//        waitAndClose();
    }

    // Test 5: TestPages Fake Alerts Test
    @Test
    public void closeHtmlAlertDialog() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertButton = driver.findElement(By.cssSelector("[id='fakealerttest']"));
        fakeAlertButton.click();

        WebElement showAlertButton = driver.findElement(By.cssSelector("[id='fakealert']"));
        showAlertButton.click();

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='dialog-ok']")));
        okButton.click();
        Assert.assertTrue("The HTML alert should close after clicking OK.", wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id='dialog-ok']"))));

//        waitAndClose();
    }

    // Test 6: TestPages Modal Dialog Test
    @Test
    public void closeHtmlModalDialog() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertButton = driver.findElement(By.cssSelector("[id='fakealerttest']"));
        fakeAlertButton.click();

        WebElement showModalButton = driver.findElement(By.cssSelector("[id='modaldialog']"));
        showModalButton.click();

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='dialog-ok']")));
        okButton.click();
        Assert.assertTrue("The HTML modal should close after clicking OK.", wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id='dialog-ok']"))));

        waitAndClose();
    }
}
