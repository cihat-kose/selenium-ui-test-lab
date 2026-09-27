WebDriver BiDi: Receiving a Message from the Browser

Imagine that a page button runs JavaScript and writes a message to the browser console. A regular UI test may only check changes visible on the page. WebDriver BiDi lets a test subscribe to browser events and receive that console message directly.

What the test does:
1. Starts Chrome with the BiDi WebSocket connection enabled.
2. Subscribes to console messages before clicking the page button.
3. Clicks a button that calls console.log(...).
4. Waits up to five seconds for the browser message.
5. Checks that the received message matches the expected text.
6. Removes the listener and closes Chrome.

There are two examples:
- The local fixture logs "Hello from WebDriver BiDi". It works without a public website.
- Selenium's live demo logs "Hello, world!". It requires internet access.

In short: the test clicks; the browser emits a console event; BiDi delivers it to the test; the assertion checks its text.

The browser and driver must support WebDriver BiDi. The CI build compiles this lesson but does not start Chrome or run it.
