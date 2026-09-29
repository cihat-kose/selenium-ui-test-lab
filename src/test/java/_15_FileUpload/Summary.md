# File Upload: Two Ways to Choose a File

Choose the task that matches the file-selection behavior you want to practice. Both tasks use the same sample file but have their own package and instructions.

| Test method | Site | What it demonstrates |
| --- | --- | --- |
| [Robot task](./_01_RobotGuru99/Task.md) · [FileUploadWithRobot](./_01_RobotGuru99/FileUploadWithRobot.java) · `uploadFileUsingRobotTest()` | [Guru99 File Upload Demo](http://demo.guru99.com/test/upload/) | Uses Robot to navigate the native file picker, paste the path, and submit the upload form. It requires a visible desktop and the expected keyboard focus. |
| [WebDriver task](./_02_WebDriverLetcode/Task.md) · [FileUploadWithWebDriverLetcode](./_02_WebDriverLetcode/FileUploadWithWebDriverLetcode.java) · `uploadFileUsingWebDriver()` | [LetCode file page](https://letcode.in/file) | Sends the absolute path directly to `input[type=file]` with Selenium, then checks the selected filename. No native picker is opened. |

The examples cover different scenarios: choose Robot when a test must interact with an operating-system dialog; use WebDriver `sendKeys` for the usual browser file-input workflow. Each task page describes its own steps and limitations.
