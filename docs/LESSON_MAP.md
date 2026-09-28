# Lesson map

Examples are grouped by their main learning goal. A locator exercise can also click an HTML dialog or scroll; that does not make it an end-to-end final assignment.

| Former final-assignment material | Current location | Why it belongs here |
| --- | --- | --- |
| CSS selector exercises | [CSS practice](../src/test/java/_03_CssSelector/_02_Practice/Task.md) | Text-box and demo-login scenarios using CSS selectors. |
| XPath exercises | [XPath practice](../src/test/java/_04_XPath/_02_Practice/Task.md) | The same two scenarios using XPath, so students can compare locator strategies. |
| YouTube search and scroll | [Scrolling](../src/test/java/_10_Scroll/_03_YouTubeSearchAndScroll/Task.md) | Loading enough results to open the 80th video. |
| Calculator operations | [Select practice](../src/test/java/_05_SelectDropdown/_02_CalculatorOperations/Summary.md) | Selects each calculator operation from a dropdown and checks its result; Actions and waits support the interaction. |
| HTML letter and reference image | [HTML basics](html-basics/README.md) | Manual page construction; contains no Selenium test. |

## Other naming and grouping decisions

- `_05_SelectDropdown` names the actual topic: native HTML `select` controls.
- The calculator is a follow-up Select exercise. A separate combined-exercises chapter is unnecessary for this one example; its summary identifies Actions and waits as additional prerequisites.
- Actions used as supporting input in the Select calculator and YouTube search/scroll lesson stay with their main learning topics. The Alerts and Actions chapters each keep a context-menu example because they teach different alert and pointer interactions.
- Shadow DOM and BiDi are chapters 13 and 14, matching the reference repository.
- `_15_FileUpload` contains the two file-selection techniques together. Robot remains a desktop-input topic in chapter 12 and links to this comparison.
- JUnit lesson classes end in `Test`. Utilities keep their existing names.
- `Tests.java` is replaced by `CssSelectorPracticeTest.java` and `XPathPracticeTest.java`. Their six method names describe the actions or checks instead of `test1` through `test6`.
- Tasks are named `Task.md`; topic explanations are named `Summary.md`.
- The delayed DemoQA alert appears in both the [Alerts](../src/test/java/_07_Alerts/_01_DemoQAAlertWait/DemoQAAlertWaitTest.java) and [Waits](../src/test/java/_08_Waits/_04_ExplicitWaitAlert/DelayedAlertWaitTest.java) chapters, where it illustrates alert handling and explicit synchronization respectively.
- The Guru99 context-click/double-click flow appears in both [Alerts](../src/test/java/_07_Alerts/_02_Guru99Alert/Guru99AlertTest.java) and [Actions](../src/test/java/_06_Actions/_01_MouseActions/_01_ContextMenuAndDoubleClick/ContextClickAndDoubleClickTest.java), with each chapter emphasizing a different part of the interaction.

## What is actually verified

The CSS/XPath practice lessons verify the submitted DemoQA text-box values and the Applitools demo dashboard message. Registration lessons verify the site's welcome message. These examples depend on public demo sites and their current markup.

Some mouse and keyboard examples demonstrate gestures without asserting a final result. The jQuery UI drag-and-drop example checks its drop message. YouTube waits for a title change and prints it; it has no result assertion and its scroll loop is currently unbounded. These are practice exercises, not evidence of a passing automated regression suite.

The combined calculator checks operation results, but it uses random inputs and live-page behavior. The file-selection fixture confirms a filename (and, in the Robot example, local form submission); it does not transfer a file to a server.

Compile validation confirms Java source compatibility. Live-site behavior and OS dialog handling require separate, targeted browser runs.
