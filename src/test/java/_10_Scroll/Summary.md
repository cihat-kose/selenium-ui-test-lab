# Scrolling Pages

Selenium can scroll to an element directly with `scrollIntoView()` or run page-level scrolling with `JavascriptExecutor`:

```java
javascriptExecutor.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
```

Scrolling matters when a page is taller than the browser window or loads more content near the bottom. Use a wait or assertion to check the result instead of assuming the scroll worked.

## What these examples check

- `ScrollPageAfterLoginTest` signs in to the OrangeHRM demo, checks the dashboard URL, scrolls to the bottom, then returns to and checks the top.
- `InfiniteScrollTest` loads ten paragraphs and checks that they are non-empty.
- `YouTubeSearchAndScrollTest` searches a live site, tries up to twelve scrolls, checks that at least 80 video cards loaded, opens the 80th, and checks for a video URL.

The OrangeHRM and YouTube lessons depend on public websites. Their content can change; the infinite-scroll page is also external, though its expected paragraph count is asserted.
