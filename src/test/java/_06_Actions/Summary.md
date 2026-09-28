# Selenium Actions

Selenium's `Actions` class models pointer and keyboard input that goes beyond a simple element click or `sendKeys` call. The examples are grouped by the interaction they teach.

## Common operations

- Pointer: `moveToElement`, `contextClick`, `doubleClick`, `clickAndHold`, and `dragAndDrop`.
- Keyboard: `sendKeys`, `keyDown`, and `keyUp` for individual keys and key combinations.
- Chaining: `build()` creates an `Action` from a sequence; `perform()` executes it.

## Lessons

- [Context click and double click](./_01_MouseActions/_01_ContextMenuAndDoubleClick/ContextClickAndDoubleClickTest.java) ([task](./_01_MouseActions/_01_ContextMenuAndDoubleClick/Task.md)): trigger and handle the demo page's JavaScript alerts.
- [Mouse actions](./_01_MouseActions/_02_HoverClickAndDrag/MouseActionsTest.java) ([task](./_01_MouseActions/_02_HoverClickAndDrag/Task.md)): hover, click, right-click, double-click, and drag elements.
- [jQuery UI drag and drop](./_01_MouseActions/_03_JQueryUiDragAndDrop/DragAndDropJQueryTest.java) ([task](./_01_MouseActions/_03_JQueryUiDragAndDrop/Task.md)): drag an item into a target inside an iframe.
- [Keyboard actions](./_02_KeyboardActions/KeyboardActionsTest.java) ([task](./_02_KeyboardActions/Task.md)): send individual keys and key combinations.
- [Search with Actions](./_03_SearchActions/DuckDuckGoSearchActionTest.java) ([task](./_03_SearchActions/Task.md)): enter a query and submit it with the Enter key.

Some examples retain `waitAndClose()` so learners can inspect the resulting browser state. It is an intentional observation pause, not test synchronization; the [README wait guidance](../../../../README.md#waits-and-browser-lifecycle) explains the distinction.

Public practice sites can change or become unavailable. The examples depend on each site's current markup and behavior.
