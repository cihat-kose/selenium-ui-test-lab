# Lesson map

Examples are grouped by their main learning goal. A locator exercise can also click an HTML dialog or scroll; that does not make it an end-to-end final assignment.

| Former final-assignment material | Current location | Why it belongs here |
| --- | --- | --- |
| CSS selector exercises | [CSS practice](../src/test/java/_03_CssSelector/_01_Practice/Task.md) | Six scenarios using CSS selectors throughout. |
| XPath exercises | [XPath practice](../src/test/java/_04_XPath/_01_Practice/Task.md) | The same scenarios using XPath, so students can compare locator strategies. |
| Three drag-and-drop exercises | [Actions](../src/test/java/_06_Actions/_06_DragAndDropPractice) | Matching and distributing elements using click, hold, move, and release. |
| YouTube search and scroll | [Scrolling](../src/test/java/_10_Scroll/_03_YouTubeSearchAndScroll/Task.md) | Loading enough results to open the 80th video. |
| Calculator operations | [Select practice](../src/test/java/_05_SelectDropdown/_01_CalculatorOperations/Summary.md) | Selects each calculator operation from a dropdown and checks its result; Actions and waits support the interaction. |
| HTML letter and reference image | [HTML basics](html-basics/README.md) | Manual page construction; contains no Selenium test. |

## Other naming and grouping decisions

- `_05_SelectDropdown` names the actual topic: native HTML `select` controls.
- The calculator is a follow-up Select exercise. A separate combined-exercises chapter is unnecessary for this one example; its summary identifies Actions and waits as additional prerequisites.
- Shadow DOM and BiDi are chapters 13 and 14, matching the reference repository.
- `_15_FileUpload` contains the two file-selection techniques together. Robot remains a desktop-input topic in chapter 12 and links to this comparison.
- JUnit lesson classes end in `Test`. Utilities keep their existing names.
- `Tests.java` is replaced by `CssSelectorPracticeTest.java` and `XPathPracticeTest.java`. Their six method names describe the actions or checks instead of `test1` through `test6`.
- Tasks are named `Task.md`; topic explanations are named `Summary.md`.
- The delayed DemoQA alert has one implementation in [Waits](../src/test/java/_08_Waits/_04_ExplicitWaitAlert/DelayedAlertWaitTest.java). The Alerts task links to it.
- The Guru99 context-click/double-click flow has one implementation in [Actions](../src/test/java/_06_Actions/_01_ContextClickAndDoubleClick/ContextClickAndDoubleClickTest.java). The Alerts task links to it.

## What is actually verified

The organization change does not add runtime assertions. CSS/XPath practice currently checks typed input values, a login message, and search text; its calculator prints a result, and its HTML dialog methods only perform clicks. The fake alerts are ordinary DOM elements, not native JavaScript alerts.

The three drag-and-drop exercises perform gestures but have no final placement assertions. YouTube waits for a title change and prints it; it has no result assertion and its scroll loop is currently unbounded. These are legacy practice exercises, not evidence of a passing automated regression suite.

The combined calculator checks operation results, but it uses random inputs and live-page behavior. The file-selection fixture confirms a filename (and, in the Robot example, local form submission); it does not transfer a file to a server.

Compile validation confirms Java source compatibility. Live-site behavior and OS dialog handling require separate, targeted browser runs.
