# Browser Windows and Tabs

Each open browser window or tab has a unique **window handle**. WebDriver commands run in the currently selected handle.

1. Save the current handle with `driver.getWindowHandle()`.
2. Wait until `driver.getWindowHandles()` contains the new window.
3. Find the handle that differs from the original and switch to it with `driver.switchTo().window(handle)`.
4. After checking the new page, close it if needed and switch back to the original handle.

[NewTabWindowTest](./_01_NewTabLocalFixture/NewTabWindowTest.java) uses local pages. It opens a new tab, switches to it, checks the heading, closes the tab, and verifies that only the original remains. The other examples practice windows on public Selenium and Herokuapp demos.
