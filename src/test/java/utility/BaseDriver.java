package utility;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** Shared, per-test browser lifecycle and Selenium helpers. */
public class BaseDriver {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;
    private boolean headless;

    @Before
    public void setUp() {
        headless = Boolean.getBoolean("selenium.headless");
        boolean ci = Boolean.getBoolean("selenium.ci");
        ChromeOptions options = new ChromeOptions();
        String chromeBinary = System.getProperty("selenium.chrome.binary");
        if (chromeBinary != null && !chromeBinary.isBlank()) {
            options.setBinary(chromeBinary);
        }
        if (ci) {
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1440,1000");
        }
        if (headless) {
            options.addArguments("--headless=new", "--window-size=1440,1000");
        }
        driver = new ChromeDriver(options);
        if (!headless && !ci) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    /** Opens a page stored under {@code src/test/resources}, independent of the IDE working directory. */
    protected void openFixture(String resourceName) {
        driver.get(TestResources.url(resourceName).toExternalForm());
    }

    /** Removes the shared legacy implicit timeout in tests that rely on explicit wait conditions. */
    protected void useExplicitWaitsOnly() {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
    }

    @After
    public void tearDown() {
        WebDriver currentDriver = driver;
        driver = null;
        wait = null;
        javascriptExecutor = null;
        headless = false;

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
        if (!headless) {
            MyFunction.wait(3);
        }
        if (driver != null) {
            WebDriver currentDriver = driver;
            driver = null;
            wait = null;
            javascriptExecutor = null;
            currentDriver.quit();
        }
    }
}

