Introduction: 

This Mobile Automation Framework is developed using Java, Appium, and TestNG, following the Page Object Model (POM) design pattern. It is optimized for efficiently testing mobile applications by ensuring modularity, scalability, and maintainability.

The framework allows you to automate Android applications by inspecting elements using Android Inspector and executing test cases with Appium. By leveraging the POM approach, any changes to mobile element locators can be easily managed. Updates are made in the main-level Page Object Model classes, automatically reflecting in all associated test cases, which reduces maintenance efforts and ensures consistency.

Key Benefits:

TestNG Integration: Run multiple test cases simultaneously with TestNG, supporting parallel execution and advanced reporting.
Maven for Dependency Management: Easily manage and update required libraries  Appium, TestNG via the pom.xml file.
CI/CD Integration: Integrates seamlessly with Jenkins or other CI/CD tools. You can execute test suites using Maven commands for efficient continuous testing.
Reusability: Inspect mobile elements once using Android Inspector, and reuse them across test cases, reducing redundancy.

Prerequisites :

Java JDK 17 or higher
Apache Maven 3.8 or higher
Android Studio 
Appium Server 9.2.2

Dependencies:

Install required libraries  Appium-Java Client, TestNG via Maven pom.xml.
Android Studio to start Emulator
Android Inspector (to inspect and retrieve mobile app elements).
For Maven dependencies, refer to: https://mvnrepository.com/.

Execution
Clone the Repository: https://huozhi@dev.azure.com/huozhi/SECUREAID/_git/SECUREAID-Selenium
Start the Appium Server
Launch the Android Emulator:
Open Android Studio, navigate to Device Manager, and start the required Android Virtual Device (AVD).
Inspect Elements (Optional):
Use Android Inspector to inspect elements in the mobile application and retrieve element locators if needed.

Run Tests:

Open the project in Eclipse, IntelliJ IDEA, or any preferred IDE.
Configure and execute tests using the TestNG.xml file to run multiple test cases as a suite with a single click.

Reporting:

After test execution, detailed reports are generated in the test-output folder.
Open the index.html file in the test-output folder to view the TestNG reports, which include execution details such as passed, failed, and skipped test cases, along with detailed logs.
