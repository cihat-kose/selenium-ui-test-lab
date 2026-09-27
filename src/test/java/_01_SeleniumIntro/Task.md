Topic: Automating User Registration with Selenium

🎯 Objective
In this task, you will learn how to automate the user registration process on a real website using Selenium WebDriver.

📝 Task Steps

1. Go to: http://tutorialsninja.com/demo/
2. Click the "My Account" menu at the top right.
3. From the dropdown, select "Register".
4. Fill out the registration form:
   - First Name: Enter your first name
   - Last Name: Enter your last name
   - Email: Enter a valid and unique email address
   - Telephone: Enter a phone number
   - Password: Enter your password
   - Password Confirm: Enter the same password again
5. Check the "Privacy Policy" checkbox
6. Click the "Continue" button to complete the registration
7. Verify that the success message appears (e.g., "Your Account Has Been Created!")
8. Close the browser

💡 Tips
- Use appropriate locator strategies such as id, name, xpath, cssSelector
- It is recommended to use assertions to verify the success message
- Use a different email address for each run to avoid "email already registered" errors

✅ Optional
- You may structure your code using the JUnit test framework
