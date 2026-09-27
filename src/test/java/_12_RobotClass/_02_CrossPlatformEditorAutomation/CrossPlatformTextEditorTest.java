package _12_RobotClass._02_CrossPlatformEditorAutomation;

import org.junit.Test;
import utility.MyFunction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CrossPlatformTextEditorTest {

    /**
     * Task: Automate text entry in a system text editor using Robot Class
     */
    @Test
    public void writeInSystemEditorAndClose() throws AWTException, IOException, InterruptedException {
        // 1. Detect the operating system
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System: " + os);

        // 2. Launch the appropriate text editor
        if (os.contains("win")) {
            Runtime.getRuntime().exec("notepad");
        } else if (os.contains("mac")) {
            Runtime.getRuntime().exec("open -a TextEdit");
        } else {
            System.out.println("Unsupported OS.");
            return;
        }

        // 3. Wait for the editor to open
        MyFunction.wait(3);

        // 4. Create Robot instance
        Robot robot = new Robot();
        robot.setAutoDelay(100);

        // 5. Type the message
        String message = "Hello from Robot Class";
        for (char ch : message.toCharArray()) {
            if (Character.isUpperCase(ch)) robot.keyPress(KeyEvent.VK_SHIFT);

            int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
            if (keyCode != KeyEvent.CHAR_UNDEFINED) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }

            if (Character.isUpperCase(ch)) robot.keyRelease(KeyEvent.VK_SHIFT);

            if (ch == ' ') {
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
            }
        }

        // 6. Small pause after typing
        MyFunction.wait(1);

        // 7. Close the editor using OS-specific keyboard shortcut
        if (os.contains("win")) {
            // ALT + F4 (Windows)
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
        } else if (os.contains("mac")) {
            // CMD + Q (macOS)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_META);
        }
    }
}
