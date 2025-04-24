# Selenium UI Test Lab

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-4.13.1-25A162?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/cihat-kose/selenium-ui-test-lab?style=for-the-badge)

## 💡 Introduction

Welcome to the **selenium-ui-test-lab** repository! This project is designed to provide hands-on training and tutorials
for UI testing with Selenium, targeting both beginners and experienced professionals. It includes a variety of test
cases and examples that demonstrate the use of Selenium for automated UI testing.

## Table of Contents

- [💡 Introduction](#💡-introduction)
- [📥 Installation](#📥-installation)
- [⚙️ Usage](#⚙️-usage)
- [✨ Features](#✨-features)
- [📦 Dependencies](#📦-dependencies)
- [🔧 Configuration](#🔧-configuration)
- [📚 Documentation](#📚-documentation)
- [💡 Examples](#💡-examples)
- [🛠️ Troubleshooting](#🛠️-troubleshooting)
- [👥 Contributors](#👥-contributors)
- [🤝 Contributing](#🤝-contributing)
- [📜 License](#📜-license)

## 📥 Installation

1. Open IntelliJ IDEA.
2. Select **File > New > Project from Version Control**.
3. Enter the repository URL: `https://github.com/cihat-kose/selenium-ui-test-lab.git` and click **Clone**.
4. Ensure you have JDK installed on your system:
    - Go to **File > Project Structure > Project** and ensure the Project SDK is set to the correct JDK version.
5. Add the required dependencies using Maven:
    - Go to **File > Project Structure > Libraries**.
    - Click the **+** icon, select **From Maven**.
    - Add the following Maven artifacts:
        - `org.seleniumhq.selenium:selenium-java:latest`
        - `commons-io:commons-io:latest`
        - `org.slf4j:slf4j-nop:latest`

## ⚙️ Usage

1. Open the project in IntelliJ IDEA.
2. Locate the test cases in the appropriate directory provided.
3. Run the test cases.
4. Customize the test cases as needed to suit your testing requirements.

## ✨ Features

- Coverage of basic to advanced Selenium techniques.
- Special modules on iframes, scrolling actions, robot classes, and alert handling.
- Examples of explicit waits and Selenium WebDriver utilities.

## 📦 Dependencies

- **Java JDK**: 11 or newer (tested on 21.0.6)
- **Selenium WebDriver**: 4.31.0
- **JUnit**: 4.13.1 (comes bundled with Java setup in most IDEs)
- **Commons IO**: 2.11.0
- **SLF4J NOP**: 1.7.30

## 🔧 Configuration

Ensure all dependencies are correctly configured in your IDE and build tools. Use Maven or Gradle to handle library
dependencies efficiently.

## 📚 Documentation

Documentation is provided within each test script and module to explain the test setup and the specific Selenium
interactions being demonstrated.

## 💡 Examples

The project includes a variety of test scenarios to demonstrate the capabilities of Selenium WebDriver. Each example is
designed to showcase different techniques and Selenium functionalities. Here are some highlighted examples:

> ℹ️ **Note on wait methods:**  
> In some examples, you might notice the use of static waits (e.g., `MyFunction.wait(5)` or `Thread.sleep()`).  
> These are used only for demonstration and visual confirmation purposes.  
> In real-world automation, always prefer **explicit waits**, such as `WebDriverWait`, for proper synchronization and reliability.

### Locators and Element Interaction

- **Basic Locators**: Learn how to use ID, class, and name locators to interact with web elements.
- **CSS Selector**: Advanced usage of CSS selectors for elements that are hard to capture.

### Advanced User Interactions

- **Action Class**: Utilize the Action class for complex gestures like drag-and-drop and mouse movements.
- **Robot Class**: Demonstrates how to use the Java Robot class for keyboard and mouse interaction beyond the
  capabilities of Selenium.

### Synchronization Techniques

- **Explicit Waits**: Implement explicit waits to handle elements that take time to load.
- **Fluent Wait**: Use fluent waits to handle AJAX components more efficiently.

### Frame Handling

- **Iframe Handling**: Navigate between iframes and interact with elements within iframes.
- **Window Handling**: Techniques to manage multiple windows and switch between them.

### Automation Tasks

- **File Upload**: Automate file upload processes using the Robot class to handle native OS dialogues.
- **Scrolling**: Execute scripts to scroll through pages and interact with off-screen elements.

### Final Assignments

- A collection of end-to-end scenario-based tests combining various Selenium concepts in one place.
- Great for reviewing topics such as locators, waits, actions, JavaScript execution, and data validation. 
- Ideal for practice and interview preparation.

These examples provide a practical approach to mastering Selenium for robust UI testing. Each module within the project
is accompanied by detailed comments and documentation to help you understand and apply the techniques effectively.

## 🛠️ Troubleshooting

If you encounter any issues:

- Ensure that Selenium WebDriver is properly installed and operational. Check that extensions and drivers (such as
  ChromeDriver or GeckoDriver) are up to date.
- Make sure your Java environment is correctly set up for Selenium and other dependencies.
- Ensure that your IntelliJ IDEA and other development tools are configured according to the project's requirements.
- If you are experiencing issues with dependencies, check your Maven configurations and ensure that the necessary
  libraries are properly included in your project.
- If problems persist, open an issue on the GitHub repository. Try to describe your problem in as much detail as
  possible so that you can receive help more quickly.

If you encounter any issues, please open an issue on the GitHub repository.

## 👥 Contributors

- [cihat-kose](https://github.com/cihat-kose)

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

For more information on how to get started, visit
the [selenium-ui-test-lab GitHub repository](https://github.com/cihat-kose/selenium-ui-test-lab).
