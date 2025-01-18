# FacebookAutomationTestNG
This project automates Facebook account creation and profile updates using Selenium WebDriver and TestNG. The automation interacts with Facebook's web elements such as buttons, input fields, and profile edit sections using Google Chrome.
# Requirements
Java 17 or later
Maven for dependency management
Selenium WebDriver
TestNG for testing
WebDriverManager for handling the browser drivers
JDK to compile and run the Java code
# Setup
Clone the repository: Clone this repository to your local machine.
git clone <repository-url>
Install dependencies: Run the following command to install the required dependencies via Maven:
mvn clean install
Set up environment variables: Set up the following environment variables for your Facebook credentials:
EMAIL - Your Facebook email address
PASSWORD - Your Facebook password
You can set these environment variables on your system or provide them in the terminal when running the tests.
Running the Tests
Run the tests using Maven by executing the following command:

mvn test
Tests
1. Create Facebook Account

This test automates the process of creating a new Facebook account:

Navigates to Facebook.
Clicks on the "Allow all cookies" button (if visible).
Fills in the registration form with sample data for first name, last name, email, password, birthday, and gender.
Submits the registration form and handles email verification.
Prompts the user to input the verification code sent to the email and submits it.
2. Update Facebook Account

This test automates logging into Facebook and updating the user's bio:

Logs into Facebook using provided credentials.
Scrolls the profile page down to simulate user interaction.
Clicks the "Edit bio" button and clears the existing bio.
Prompts the user to enter a new bio and saves the changes.
Known Issues
Synchronization issues: Facebook elements may change dynamically, so you may need to adjust waiting times depending on performance.
Email verification: The project requires manual input for the verification code received by email during account creation.
Troubleshooting
Element not found: Ensure that the browser driver version matches the browser version you're using.
Test failures: Facebook's UI might have changed, causing the XPath to become invalid.
