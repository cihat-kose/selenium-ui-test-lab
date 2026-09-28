# Iframes

An `<iframe>` embeds another document inside a page. Selenium starts in the main document, so it must switch to the frame before locating or using elements inside it.

```java
driver.switchTo().frame(frameElement);
// Find and use elements inside the frame.
driver.switchTo().parentFrame();
```

Use `defaultContent()` to return to the top-level page when frames are nested or when you want to leave all frames.

## What these examples check

- `IframeCountTest` opens Selenium's public iframe demo and checks that a frame is present.
- `IframeTextCheckTest` switches into a live frame, enters an email, checks the value, returns to the main page, and checks its content.
- [IframeTextAreaEditTest](./_03_TextArea/IframeTextAreaEditTest.java) uses a local fixture. It replaces text inside a textarea, checks the new value, returns to the parent frame, and checks the page title. This is the stable example to start with.
