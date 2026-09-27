 Scroll Summary

 - Definition:
   Scrolling is the process of moving the visible portion of a web page.
   In Selenium, scrolling is often needed when elements are not visible in the current viewport.

 - Scrolling Methods in Selenium:
   a) Scroll by Pixels:
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 1000);");  // Scroll down by 1000 pixels vertically

   b) Scroll to Element:
      WebElement element = driver.findElement(By.id("elementId"));
      js.executeScript("arguments[0].scrollIntoView(true);", element);

   c) Scroll to Bottom/Top of Page:
      js.executeScript("window.scrollTo(0, document.body.scrollHeight);");  // Scroll to bottom
      js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");  // Scroll to top

 - Notes:
   - Scrolling is useful for lazy-loaded content and dynamic pages.
   - Waits might be necessary before scrolling to ensure the page has fully loaded.
   - Horizontal scrolling can be done with: js.executeScript("window.scrollBy(500, 0);")
