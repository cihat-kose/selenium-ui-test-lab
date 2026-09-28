# 🤖 Robot: Let Java Use Your Keyboard and Mouse

## What is it?

Java's `Robot` class presses keyboard keys and moves or clicks the mouse on your computer, much as you would do yourself. It is a Java tool, not a Selenium feature.

## What is it useful for?

Imagine clicking **Choose file** on a page. Your computer opens a file picker. That window belongs to the operating system, so Selenium cannot find its buttons with `By.id(...)`.

Robot can press keys in that window. It sends input to whichever window currently has keyboard focus.

## What do we do in our example?

Open [FileSelectionWithRobotTest](../_15_FileUpload/FileSelectionWithRobotTest.java).

1. Selenium opens our local page and clicks its file input.
2. The computer's file picker opens.
3. Robot presses **Ctrl+V** to paste the sample file's path, then **Enter** to select it.
4. Selenium waits until the page shows `upload-sample.txt`.
5. The test submits the local form and checks **File selected and form submitted.**

**In one sentence:** Robot uses the keyboard to select a file in a window outside the web page; Selenium checks the result on the page.

The example needs a visible desktop and the correct window in focus. It selects a local file; the practice page does not upload it to a server.

## What do the other examples show?

- [DuckDuckGoRobotSearchTest](_01_DuckDuckGoSearch/DuckDuckGoRobotSearchTest.java) pastes a search phrase, presses Enter, and demonstrates mouse movement and clicks.
- [CrossPlatformTextEditorTest](_02_CrossPlatformEditorAutomation/CrossPlatformTextEditorTest.java) opens a desktop text editor and types a message. Its current code handles Windows and macOS.

These two are interaction demonstrations; they do not assert the final search or editor contents.

For comparison, [FileSelectionWithWebDriverTest](../_15_FileUpload/FileSelectionWithWebDriverTest.java) sends the file path directly to the page's file input. It does not use Robot or open the computer's file picker.
