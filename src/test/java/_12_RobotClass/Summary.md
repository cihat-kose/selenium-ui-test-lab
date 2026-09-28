# Robot: Let Java Use Your Keyboard and Mouse

## What is Robot?

Java's `Robot` class sends keyboard and mouse input to the computer. It is a Java desktop tool, not a Selenium feature. It can help when the control belongs to another window, such as an operating-system file picker.

## What does the file-selection example do?

Open [FileSelectionWithRobotTest](../_15_FileUpload/FileSelectionWithRobotTest.java).

1. Selenium opens a local page and clicks its file input.
2. The operating system opens its file picker.
3. Robot pastes the shared sample-file path and presses Enter.
4. Selenium checks the selected filename and the page's submission message.

The test clicks the file control directly, so it does not guess a number of Tab presses. It needs a visible desktop and a file dialog that has keyboard focus. The page shows a local confirmation; it does not upload the file to a server.

## What do the other examples do?

- [DuckDuckGoRobotSearchTest](_01_DuckDuckGoSearch/DuckDuckGoRobotSearchTest.java) pastes a search phrase and presses Enter with Robot. Selenium checks that a result appeared; Robot then moves the pointer without clicking browser controls.
- [CrossPlatformTextEditorTest](_02_CrossPlatformEditorAutomation/CrossPlatformTextEditorTest.java) opens Notepad or TextEdit, types a short message, and closes the editor. It is skipped on unsupported systems and headless sessions; it cannot verify text inside the other application.

## How is this different from WebDriver file selection?

[FileSelectionWithWebDriverTest](../_15_FileUpload/FileSelectionWithWebDriverTest.java) sends the file path directly to `input[type=file]`. It does not use Robot and does not open the operating-system picker. The two examples demonstrate different methods.
