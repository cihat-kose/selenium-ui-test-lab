# 🤖 Robot: Let Java Use Your Keyboard and Mouse

## What is it?

Java's `Robot` class presses keyboard keys and moves or clicks the mouse on your computer, much as you would do yourself. It is a Java tool, not a Selenium feature.

## What is it useful for?

Imagine clicking **Choose file** on a page. Your computer opens a file picker. That window belongs to the operating system, so Selenium cannot find its buttons with `By.id(...)`.

Robot can press keys in that window. It sends input to whichever window currently has keyboard focus.

## What do we do in our example?

Open [FileUploadWithRobot](../_15_FileUpload/_01_RobotGuru99/FileUploadWithRobot.java), especially `uploadFileUsingRobotTest()`, and its [task](../_15_FileUpload/_01_RobotGuru99/Task.md).

1. Selenium opens the Guru99 file-upload demo.
2. Robot uses **Tab** and **Enter** to open the native file picker, then **Ctrl+V** to paste the sample file path.
3. Robot confirms the file selection. Selenium accepts the terms and clicks **Submit File**.
4. The test checks Guru99's upload confirmation.

**In one sentence:** Robot uses the keyboard to select a file in a window outside the web page; Selenium checks the result on the page.

The example needs a visible Windows desktop and depends on the native file picker's keyboard focus and tab order. It submits the sample file to Guru99's public demo.

## What do the other examples show?

- [DuckDuckGoRobotSearchTest](_01_DuckDuckGoSearch/DuckDuckGoRobotSearchTest.java) pastes a search phrase, presses Enter, and demonstrates mouse movement and clicks.
- [CrossPlatformTextEditorTest](_02_CrossPlatformEditorAutomation/CrossPlatformTextEditorTest.java) opens a desktop text editor, pastes a message with Robot using the operating system's shortcut, and closes the editor. Its current code handles Windows and macOS.

These two are interaction demonstrations; they do not assert the final search or editor contents.

For comparison, `uploadFileUsingWebDriver()` in [FileUploadWithWebDriverLetcode](../_15_FileUpload/_02_WebDriverLetcode/FileUploadWithWebDriverLetcode.java) sends the path directly to LetCode's file input. It does not use Robot or open the computer's file picker. See its [task](../_15_FileUpload/_02_WebDriverLetcode/Task.md).
