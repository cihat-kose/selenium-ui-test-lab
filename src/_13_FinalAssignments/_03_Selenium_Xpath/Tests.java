package _13_FinalAssignments._03_Selenium_Xpath;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class Tests extends BaseDriver {

    // Test 1: Demo QA Text Box Test
    @Test
    public void test1() {
        driver.get("http://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Automation");

        WebElement eMail = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        eMail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//*[@placeholder='Current Address']"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Testing Permanent Address");

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        Assert.assertTrue(fullName.getAttribute("value").contains("Automation"));
        Assert.assertTrue(eMail.getAttribute("value").contains("Testing"));

        // waitAndClose();
    }

    // Test 2: Applitools Demo Login Test
    @Test
    public void test2() {
        driver.get("https://demo.applitools.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("techno123.");

        WebElement signInButton = driver.findElement(By.xpath("//a[text()='Sign in']"));
        signInButton.click();

        WebElement verificationMessage = driver.findElement(By.xpath("//h6[text()='Your nearest branch closes in: 30m 5s']"));
        Assert.assertEquals("Your nearest branch closes in: 30m 5s", verificationMessage.getText());

        // waitAndClose();
    }

    // Test 3: Snapdeal Search Test
    @Test
    public void test3() {
        driver.get("https://www.snapdeal.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
        searchBox.sendKeys("teddy bear");

        WebElement searchButton = driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
        searchButton.click();

        WebElement confirmation = driver.findElement(By.xpath("//div[@id='searchMessageContainer']"));
        Assert.assertTrue(confirmation.getText().contains("results for teddy bear"));

        // waitAndClose();
    }

    // Test 4: TestPages Calculate Test
    @Test
    public void test4() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculatorButton = driver.findElement(By.xpath("//a[text()='Calculator']"));
        calculatorButton.click();

        WebElement input1Box = driver.findElement(By.xpath("//input[@id='number1']"));
        input1Box.sendKeys("7");

        WebElement input2Box = driver.findElement(By.xpath("//input[@id='number2']"));
        input2Box.sendKeys("6");

        WebElement calculator2Button = driver.findElement(By.xpath("//input[@id='calculate']"));
        calculator2Button.click();

        WebElement result = driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println(result.getText());

        // waitAndClose();
    }

    // Test 5: TestPages Fake Alerts Test
    @Test
    public void test5() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertButton = driver.findElement(By.xpath("//a[text()='Fake Alerts']"));
        fakeAlertButton.click();

        WebElement showAlertButton = driver.findElement(By.xpath("//input[@id='fakealert']"));
        showAlertButton.click();

        WebElement okButton = driver.findElement(By.xpath("//button[@id='dialog-ok']"));
        okButton.click();

        // waitAndClose();
    }

    // Test 6: TestPages Modal Dialog Test
    @Test
    public void test6() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertButton = driver.findElement(By.xpath("//a[text()='Fake Alerts']"));
        fakeAlertButton.click();

        WebElement showModalButton = driver.findElement(By.xpath("//input[@id='modaldialog']"));
        showModalButton.click();

        WebElement okButton = driver.findElement(By.xpath("//button[@id='dialog-ok']"));
        okButton.click();

        waitAndClose();
    }
}
