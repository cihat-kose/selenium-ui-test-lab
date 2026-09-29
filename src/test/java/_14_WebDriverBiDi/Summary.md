# WebDriver BiDi: Receive Events from the Browser

Traditional WebDriver tests send commands to the browser and wait for the result. **WebDriver BiDi** adds a WebSocket connection that lets a test subscribe to browser events while the session is running. In this lesson, the event is a message written to the browser console.

BiDi means *bidirectional*: the test can send browser commands and receive events from the browser. The Selenium project describes it as the W3C bidirectional protocol for streaming events such as console messages, JavaScript errors, and network activity. See the [Selenium WebDriver BiDi guide](https://www.selenium.dev/documentation/webdriver/bidi/).

## How the test works

1. Enable the BiDi WebSocket connection when creating Chrome:

   ```java
   options.setCapability("webSocketUrl", true);
   ```

2. Register a console-message handler **before** clicking the page button. The handler completes a `CompletableFuture` when the browser sends a console event.
3. Click the button. Its JavaScript calls `console.log(...)`.
4. Wait up to five seconds for the event and assert the message text.
5. Remove the handler in a `finally` block so it is cleaned up even if the wait or assertion fails.

The event is separate from page content: it is not an alert, and the message does not need to appear in the page DOM.

## Examples in this folder

| Test method | Page | Expected console message |
| --- | --- | --- |
| `receivesConsoleMessageFromLocalFixture()` | Local `webdriver-bidi-example.html` page | `Hello from WebDriver BiDi` |
| `receivesConsoleMessageFromSeleniumLiveDemo()` | Selenium's live demo page | `Hello, world!` |

Start with the local fixture to learn the flow without depending on a public website. The live demo also needs internet access. Both examples require a browser and driver with BiDi support; this test enables it through Chrome's `webSocketUrl` capability.

**In one sentence:** Subscribe to a browser console event, trigger it with a click, then verify the event's message in the test.
