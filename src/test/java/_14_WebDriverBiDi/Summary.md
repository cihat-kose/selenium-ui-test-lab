# 🔄 WebDriver BiDi: Let the Browser Tell the Test What Happened

## What is it?

In a familiar Selenium step, the test tells the browser to do something: **click this button**.

With **WebDriver BiDi**, the browser can also send events back to the test as they happen: **a message was just written to the console**. BiDi means *bidirectional*, or communication in both directions.

The test chooses which events to listen for. In this lesson, it listens for console messages.

## What is it useful for?

A button may run JavaScript without changing any visible text on the page. That JavaScript can still write a message to the browser's **console**, where developers inspect messages from page code.

BiDi lets our test receive that console message and check it automatically.

## What do we test here?

Open [ConsoleLogBidiTest](ConsoleLogBidiTest.java) and start with `receivesConsoleMessageFromLocalFixture()`.

1. Start Chrome with BiDi enabled.
2. Tell Selenium to listen for console messages.
3. Open our local page and click **Write console message**.
4. The button's JavaScript writes `Hello from WebDriver BiDi` to the console.
5. The test receives the message and checks that its text is exactly correct.

The message is a console entry, not an alert popup or a success label on the page. The test waits up to five seconds for it, then stops listening and closes Chrome.

**In one sentence:** We click a button and use BiDi to check the console message that the button produces.

## Is there a live-site example?

Yes. The second method, `receivesConsoleMessageFromSeleniumLiveDemo()`, opens Selenium's demo page. It clicks a button and checks the console message `Hello, world!` in the same way.

The local example needs no public website. CI runs that local method with headless Chrome. The live example needs internet access. Both require a browser and driver that support BiDi.
