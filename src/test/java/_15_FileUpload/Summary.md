# Selecting files

Both tests open the same local page and select `src/test/resources/upload-sample.txt`.

- `FileSelectionWithWebDriverTest`: sends the file path to `input[type=file]` and checks the displayed filename.
- `FileSelectionWithRobotTest`: opens the operating-system file picker, pastes the path using Robot, and checks the filename and local submission message. It needs a visible desktop and the expected keyboard focus.

The page does not upload the file to a server. These tests teach two ways to select a file. See [Task.md](Task.md) for the exercise.
