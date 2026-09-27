# Selenium UI Test Lab

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.49.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-25A162?style=for-the-badge&logo=junit4&logoColor=white)
[![Build validation](https://img.shields.io/github/actions/workflow/status/cihat-kose/selenium-ui-test-lab/build.yml?branch=master&style=for-the-badge&label=Build)](https://github.com/cihat-kose/selenium-ui-test-lab/actions/workflows/build.yml)
![GitHub last commit](https://img.shields.io/github/last-commit/cihat-kose/selenium-ui-test-lab?style=for-the-badge)

## 💡 Introduction

This repository contains hands-on Selenium WebDriver lessons and exercises in Java. It is an educational project: examples focus on one browser interaction at a time and use JUnit assertions where the expected result can be checked.

**Quick links:** [Install in IntelliJ IDEA](#installation) · [Run a lesson](#run-a-lesson) · [Repository layout](#repository-layout) · [Lesson map](docs/LESSON_MAP.md)

## 📦 Technology Stack

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

<a id="repository-layout"></a>

## 🗂️ Repository Layout

The project uses the standard Maven test layout, matching `selenium-practice-lessons`.

### Project root

| Path | Purpose |
| --- | --- |
| [`src/test/java/`](src/test/java) | Numbered lesson packages, JUnit classes, tasks, and summaries |
| [`src/test/resources/`](src/test/resources) | Local HTML pages and shared upload sample |
| [`docs/`](docs) | Lesson map and the independent HTML exercise |
| [`pom.xml`](pom.xml) | Java version, dependencies, and Maven plugins |
| [`mvnw`](mvnw) / [`mvnw.cmd`](mvnw.cmd) | Maven launchers for macOS/Linux and Windows |
| [`.mvn/wrapper/`](.mvn/wrapper) | Pinned Maven Wrapper configuration |
| [`.github/workflows/`](.github/workflows) | CI compilation checks |
| [`LICENSE`](LICENSE) | MIT license |

### Lesson folders

- `src/test/java/`: lesson classes, shared utilities, and their accompanying `Task.md`/`Summary.md` notes.
- `src/test/resources/`: shared HTML fixtures and sample upload files.

Maven discovers these directories automatically; no custom test-source path is needed.

```text
src/test/java/
├── _01_SeleniumIntro/
├── _02_Locators/
├── _03_CssSelector/
├── _04_XPath/
├── _05_SelectDropdown/
├── _06_Actions/
├── _07_Alerts/
├── _08_Waits/
├── _09_IFrames/
├── _10_Scroll/
├── _11_Windows/
├── _12_RobotClass/
├── _13_ShadowDom/
├── _14_WebDriverBiDi/
├── _15_FileUpload/
├── _16_CombinedExercises/
└── utility/
```

See the [lesson map](docs/LESSON_MAP.md) for grouping decisions and example locations. The independent [HTML exercise](docs/html-basics/README.md) is kept with the documentation.

## 📚 Lessons

- WebDriver basics, registration flows, locators, CSS selectors, and XPath
- Native `select` dropdowns
- Actions for mouse and keyboard input, including drag and drop
- JavaScript alerts
- Implicit, explicit, and fluent waits
- Iframes, scrolling, browser tabs, and windows
- Java Robot and file selection
- Selenium 4 Shadow DOM access with local fixtures
- WebDriver BiDi console-event listening with a local fixture and Selenium's live demo
- A combined calculator exercise using Actions, Select, waits, and assertions

The repository already teaches the core locator, dropdown, Actions, alert, wait, iframe, scroll, and window topics. The added Shadow DOM and BiDi lessons fill topics that were missing instead of repeating an existing lesson.

<a id="installation"></a>

## 📥 Installation — IntelliJ IDEA

### Requirements

- **JDK 21** and **Google Chrome**
- **IntelliJ IDEA** with Java and Maven support
- **Git** for cloning (or download and extract the repository ZIP)
- Internet access for the first dependency download and live-site lessons

### Clone and open the project

1. In IntelliJ IDEA, choose **Clone Repository / Get from Version Control** from the welcome screen (the label varies by version).
2. Paste `https://github.com/cihat-kose/selenium-ui-test-lab.git`, choose a local folder, and click **Clone**.
3. Open the repository root containing `pom.xml`. If using a ZIP, choose **File → Open** and select its extracted root folder.
4. In **File → Project Structure → Project**, select **JDK 21** as the Project SDK. Download a JDK there if one is not installed.
5. Import the project as Maven. If IntelliJ has not detected it, right-click `pom.xml` and choose **Add as Maven Project**. Reload the project from the **Maven** tool window and let dependencies finish downloading.
6. In Maven settings, use the repository's **Maven Wrapper** and **JDK 21** for Maven execution. IntelliJ normally detects the wrapper automatically.
7. Confirm that `src/test/java` is recognized as a test-source folder and `src/test/resources` as test resources. Reload Maven if these folders are not recognized.

The dependencies, including JUnit, come from `pom.xml`. You do not need to add individual JAR files to the IDE.

### Compile once

Open IntelliJ's terminal at the repository root and use the included Maven Wrapper:

Windows PowerShell:

```powershell
.\mvnw.cmd -B -ntp test-compile
```

macOS/Linux:

```bash
./mvnw -B -ntp test-compile
```

`test-compile` compiles the lesson and test sources without starting Chrome. GitHub Actions runs this same compilation check; it does not execute live-site or desktop automation tests.

<a id="run-a-lesson"></a>

## ▶️ Run a Lesson

### With the IDE Run button

1. Open [`ShadowDomExampleTest.java`](src/test/java/_13_ShadowDom/ShadowDomExampleTest.java) under `src/test/java/_13_ShadowDom/`.
2. Click the **green Run triangle** beside `clickButtonInsideOpenShadowRoot()` to run that one test. The triangle beside the class runs all its methods.
3. Chrome opens the local practice page, clicks **Accept** inside the Shadow DOM, and checks the message **Consent accepted**.
4. Inspect the result in IntelliJ's **Run** window. A failed assertion or browser startup error appears there with its details.

These are JUnit tests; they run through the test runner and do not need a `main` method. Keep the run configuration's working directory at the repository root so the resource paths work.

### With Maven

JUnit lesson classes use descriptive `*Test.java` names and are discoverable by Maven Surefire. Run one class at a time:

```bash
./mvnw "-Dtest=InfiniteScrollTest" test
```

Run the local Shadow DOM class and only the local method of the BiDi class with:

```bash
./mvnw "-Dtest=ShadowDomExampleTest" test
./mvnw "-Dtest=ConsoleLogBidiTest#receivesConsoleMessageFromLocalFixture" test
```

Browser tests depend on Chrome, network access, and the current state of external demo sites. The BiDi tests also require a Chrome/ChromeDriver combination that supports the WebSocket BiDi connection.

## 🧪 Stable Local Examples

- The textarea iframe exercise uses `src/test/resources/iframe-textarea.html` instead of the W3Schools editor, which can be obscured by external page overlays.
- Shadow DOM exercises use local HTML fixtures so students can see the host, shadow root, click, and expected result without a third-party site.
- The file-selection examples share `src/test/resources/upload-sample.txt`. The Robot test interacts with the operating-system file picker; the WebDriver test sends the path directly to `input[type=file]`. These demonstrate different techniques. The Robot example opens the file control directly and does not guess a TAB count.
- Both search lessons use DuckDuckGo instead of Google's variable automated-traffic and consent flow.

The file-picker example requires a visible desktop session and keyboard focus. It may not run in a headless CI environment. It demonstrates selection and the page's confirmation message; it does not upload a file to a server.

## ⏱️ Waits and Browser Lifecycle

> ℹ️ **Note on wait methods:**
> Some examples include fixed pauses such as `MyFunction.wait(5)` or `Thread.sleep(...)` so you can watch the browser actions during a lesson.
>
> A fixed pause always waits for the chosen duration. It does **not** check whether an element is ready: five seconds may be too short on a slow page and unnecessary on a fast one.
>
> In real-world automation, prefer **explicit waits** such as `WebDriverWait`. They continue when a specific condition is met—for example, when a button becomes clickable—and fail if that condition is not met before the timeout.
>
> `waitAndClose()` is a three-second observation pause at the end of a lesson. It gives you time to inspect the final page before the browser closes; it is not test synchronization.

`BaseDriver` creates a browser in JUnit `@Before` and closes it in `@After`, including when a test fails. The shared driver retains a 30-second implicit wait for the existing lessons, and the implicit-wait lesson changes it to ten seconds. Combining implicit and explicit waits can make total wait times difficult to predict; use explicit waits alone in new examples.

## 🛠️ Troubleshooting and Limitations

- **No Run triangle or unresolved Selenium/JUnit imports:** reload the Maven project and wait for dependency resolution.
- **Java release 21 error:** select JDK 21 for both the project and the Maven runner.
- **Local fixture not found:** run from the repository root and compile the test resources.

- Public demo websites can change, become unavailable, or block automated traffic.
- Robot examples interact with the desktop and depend on the operating system and focused window.
- The full set of lessons is not a stable headless CI suite; run focused examples locally. Bare `mvn test` now discovers all `*Test` lessons, including desktop and live-site examples.
- Some legacy exercises only demonstrate interactions or print results; see the lesson map for their current verification limits.
- A Chrome startup failure occurs before the test reaches its page and assertions.

## 🔗 IDE Reference

- [JetBrains: Maven projects](https://www.jetbrains.com/help/idea/maven-support.html)
- [JetBrains: running tests in Maven projects](https://www.jetbrains.com/help/idea/work-with-tests-in-maven.html)

## 📜 License

MIT. See [LICENSE](LICENSE) for details.
