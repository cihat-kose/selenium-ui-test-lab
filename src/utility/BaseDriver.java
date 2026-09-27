package utility;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** Shared, per-test browser lifecycle and Selenium helpers. */
public class BaseDriver {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        WebDriver currentDriver = driver;
        driver = null;
        wait = null;
        javascriptExecutor = null;

        if (currentDriver != null) {
            try {
                currentDriver.quit();
            } catch (RuntimeException exception) {
                System.err.println("WebDriver cleanup failed: " + exception.getMessage());
            }
        }
    }

    /**
     * Leaves the final page visible briefly for lesson observation, then closes the browser.
     * This fixed delay is not test synchronization; use WebDriverWait for conditions.
     */
    public void waitAndClose() {
        MyFunction.wait(3);
        if (driver != null) {
            WebDriver currentDriver = driver;
            driver = null;
            wait = null;
            javascriptExecutor = null;
            currentDriver.quit();
        }
    }
}
