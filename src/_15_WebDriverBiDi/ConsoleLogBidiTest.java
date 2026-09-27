package _15_WebDriverBiDi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.bidi.log.ConsoleLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/** Listens for a browser console message with Selenium's WebDriver BiDi API. */
public class ConsoleLogBidiTest {
    private ChromeDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void receivesConsoleMessageFromLocalFixture() throws Exception {
        RemoteWebDriver remoteDriver = driver;
        CompletableFuture<ConsoleLogEntry> consoleEvent = new CompletableFuture<>();
        String handlerId = remoteDriver.script().addConsoleMessageHandler(consoleEvent::complete);

        try {
            driver.get(Objects.requireNonNull(getClass().getResource("/webdriver-bidi-example.html"))
                    .toExternalForm());
            driver.findElement(By.id("write-console-message")).click();

            ConsoleLogEntry entry = consoleEvent.get(5, TimeUnit.SECONDS);
            assertEquals("Hello from WebDriver BiDi", entry.getText());
        } finally {
            remoteDriver.script().removeConsoleMessageHandler(handlerId);
        }
    }

    @Test
    public void receivesConsoleMessageFromSeleniumLiveDemo() throws Exception {
        RemoteWebDriver remoteDriver = driver;
        CompletableFuture<ConsoleLogEntry> consoleEvent = new CompletableFuture<>();
        String handlerId = remoteDriver.script().addConsoleMessageHandler(consoleEvent::complete);

        try {
            driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");
            driver.findElement(By.id("consoleLog")).click();

            ConsoleLogEntry entry = consoleEvent.get(5, TimeUnit.SECONDS);
            assertEquals("Hello, world!", entry.getText());
        } finally {
            remoteDriver.script().removeConsoleMessageHandler(handlerId);
        }
    }
}
