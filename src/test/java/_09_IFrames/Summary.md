IFrames

1. What is an IFrame?
- An iframe is an HTML element (`<iframe>`) that embeds another HTML page inside the current page.

2. How to Handle IFrames in Selenium?
- To switch to an iframe: `driver.switchTo().frame("iframeID");` or `driver.switchTo().frame(WebElement);`
- To switch back to the main page: `driver.switchTo().defaultContent();`
- To switch one level up (in nested iframes): `driver.switchTo().parentFrame();`

3. Key Notes:
- Failing to switch to the correct iframe causes `NoSuchElementException`.
- You must switch out of the iframe before accessing other page elements.
- You can switch to iframes using id, name, index, or WebElement.

4. Usage Examples:
```java
// Switch to iframe using WebElement
WebElement iframe = driver.findElement(By.id("frame1"));
driver.switchTo().frame(iframe);

// Switch back to the main document
driver.switchTo().defaultContent();
