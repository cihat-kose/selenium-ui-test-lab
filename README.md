# Selenium UI Test Lab

This repository contains hands-on Selenium WebDriver lessons and exercises in Java. It is an educational project: examples focus on one browser interaction at a time and use JUnit assertions where the expected result can be checked.

## Technology stack

| Technology | Version |
| --- | --- |
| Java | 21 |
| Maven Wrapper | 3.3.4 |
| Maven distribution | 3.9.11 |
| Selenium Java | 4.49.0 |
| JUnit | 4.13.2 |
| Maven Compiler Plugin | 3.16.0 |
| Maven Surefire Plugin | 3.6.0 |

The versions are pinned in `pom.xml`; no manual JAR installation is needed. Selenium Manager attempts to resolve a compatible ChromeDriver for the locally installed Chrome browser.

## Repository layout

The lesson folders and their `Task`/`Summary` notes remain under `src/`. Maven is configured to compile the Java lesson files there as test sources. Shared local HTML and file fixtures are stored under `src/test/resources/`.

```text
src/
├── _01_SeleniumIntro/
├── _02_Locators/
├── _03_CssSelector/
├── _04_XPath/
├── _05_Select_ElementInStatus/
├── _06_Actions/
├── _07_Alerts/
├── _08_Waits/
├── _09_IFrames/
├── _10_Scroll/
├── _11_Windows/
├── _12_RobotClass/
├── _13_FinalAssignments/
├── _14_ShadowDom/
├── _15_WebDriverBiDi/
└── utility/
```

## Lessons

- WebDriver basics, registration flows, locators, CSS selectors, and XPath
- Native `select` dropdowns
- Actions for mouse and keyboard input, including drag and drop
- JavaScript alerts
- Implicit, explicit, and fluent waits
- Iframes, scrolling, browser tabs, and windows
- Java Robot and file selection
- Selenium 4 Shadow DOM access with local fixtures
- WebDriver BiDi console-event listening with a local fixture and Selenium's live demo
- Final exercises that combine several Selenium techniques

The repository already teaches the core locator, dropdown, Actions, alert, wait, iframe, scroll, and window topics. The added Shadow DOM and BiDi lessons fill topics that were missing instead of repeating an existing lesson.

## Requirements and setup

- JDK 21
- Google Chrome for browser lessons
- Internet access for lessons that use public demo sites

Clone the repository, then use the included Maven Wrapper.

Windows PowerShell:

```powershell
.\mvnw.cmd -B -ntp test-compile
```

macOS/Linux:

```bash
./mvnw -B -ntp test-compile
```

`test-compile` compiles the lesson and test sources without starting Chrome. GitHub Actions runs this same compilation check; it does not execute live-site or desktop automation tests.

## Run one lesson

Run one JUnit class at a time. For example:

```bash
./mvnw "-Dtest=InfiniteScrollTest" test
```

The local Shadow DOM and WebDriver BiDi lessons can be run with:

```bash
./mvnw "-Dtest=ShadowDomExampleTest" test
./mvnw "-Dtest=ConsoleLogBidiTest" test
```

Browser tests depend on Chrome, network access, and the current state of external demo sites. The BiDi tests also require a Chrome/ChromeDriver combination that supports the WebSocket BiDi connection.

## Stable local examples

- The textarea iframe exercise uses `src/test/resources/iframe-textarea.html` instead of the W3Schools editor, which can be obscured by external page overlays.
- Shadow DOM exercises use local HTML fixtures so students can see the host, shadow root, click, and expected result without a third-party site.
- The file-selection examples share `src/test/resources/upload-sample.txt`. The Robot test interacts with the operating-system file picker; the WebDriver test sends the path directly to `input[type=file]`. These demonstrate different techniques. The Robot example opens the file control directly and does not guess a TAB count.
- Both search lessons use DuckDuckGo instead of Google's variable automated-traffic and consent flow.

The file-picker example requires a visible desktop session and keyboard focus. It may not run in a headless CI environment. It demonstrates selection and the page's confirmation message; it does not upload a file to a server.

## Waits and browser lifecycle

`WebDriverWait` waits for a condition and should be used to synchronize test steps. `MyFunction.wait(...)` calls `Thread.sleep(...)`; it pauses for a fixed time without checking page state and remains only for visual demonstration.

`BaseDriver.waitAndClose()` leaves the final page visible for three seconds before closing Chrome. That delay is for observing the lesson result, not test synchronization. `BaseDriver` creates a browser in JUnit `@Before` and closes it in `@After`, including when a test fails. The shared driver retains a 30-second implicit wait for the existing lessons, and the implicit-wait lesson changes it to ten seconds. Combining implicit and explicit waits can make total wait times difficult to predict; use explicit waits alone in new examples.

## Known limitations

- Public demo websites can change, become unavailable, or block automated traffic.
- Robot examples interact with the desktop and depend on the operating system and focused window.
- The full set of lessons is not a stable headless CI suite; run focused examples locally.
- A Chrome startup failure occurs before the test reaches its page and assertions.

## License

MIT. See [LICENSE](LICENSE) for details.
