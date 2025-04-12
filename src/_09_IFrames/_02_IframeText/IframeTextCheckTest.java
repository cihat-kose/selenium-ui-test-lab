package _09_IFrames._02_IframeText;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class IframeTextCheckTest extends BaseDriver {

    @Test
    public void printIframeContent() {
        driver.get("https://demoqa.com/frames");

        WebElement iframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);

        WebElement text = driver.findElement(By.id("sampleHeading"));
        System.out.println("Iframe text: " + text.getText());

        waitAndClose();
    }
}
