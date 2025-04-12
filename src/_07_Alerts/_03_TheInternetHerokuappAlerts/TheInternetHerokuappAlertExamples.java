package _07_Alerts._03_TheInternetHerokuappAlerts;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class TheInternetHerokuappAlertExamples extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading 1: JavaScript Alert
     */
    @Test
    public void handleSimpleJSAlertTest() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("(//button)[1]")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();

//        waitAndClose();
    }

    /**
     * _05_ExplicitWaitDynamicLoading 2: JavaScript Confirm Alert
     */
    @Test
    public void handleJSConfirmAlertTest() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("(//button)[2]")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.dismiss();

//        waitAndClose();
    }

    /**
     * _05_ExplicitWaitDynamicLoading 3: JavaScript Prompt Alert
     */
    @Test
    public void handleJSPromptAlertTest() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("(//button)[3]")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt Text: " + alert.getText());
        alert.sendKeys("Hello, Selenium");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Result: " + result.getText());

//        waitAndClose();
    }

    /**
     * _05_ExplicitWaitDynamicLoading 4: Right Click and Alert
     */
    @Test
    public void handleRightClickAlertTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickArea).perform();

        Alert alert = driver.switchTo().alert();
        System.out.println("Right-click alert text: " + alert.getText());
        alert.accept();

        waitAndClose();
    }
}
