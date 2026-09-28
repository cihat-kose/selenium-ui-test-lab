# Waiting for the Browser

Pages can update after Selenium clicks or types. A wait prevents the next command from running before its required page state is ready.

## Three Selenium waits

- **Implicit wait** gives element searches a shared timeout when an element is missing. It applies to every search, which can make timing hard to predict when mixed with explicit waits.
- **Explicit wait** checks one condition, such as a button becoming clickable or a JavaScript alert appearing. `WebDriverWait` continues as soon as that condition is met and times out if it never is.
- **Fluent wait** is an explicit wait with additional control over polling frequency and which exceptions to ignore.

In new tests, prefer explicit waits tied to the next action. The shared driver keeps an implicit wait for older lessons, and the implicit-wait lesson changes its timeout to make that behavior visible. Tests that use explicit conditions call `useExplicitWaitsOnly()` so Selenium does not combine both timeouts.

## Fixed pauses are different

`Thread.sleep()` and `MyFunction.wait()` always pause for the chosen duration. They do not check whether a page is ready. Some lessons retain short pauses so students can watch an interaction. `waitAndClose()` is a final observation pause; it is not test synchronization.

## Example in this chapter

[`DelayedAlertWaitTest`](./_04_ExplicitWaitAlert/DelayedAlertWaitTest.java) clicks a button, waits until a delayed browser alert exists, checks its message, accepts it, and checks the page response. The alert comes from a local fixture, so the lesson does not depend on a third-party site's layout or advertising.
