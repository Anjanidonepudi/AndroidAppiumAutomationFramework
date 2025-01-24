Appium Automation Framework for Windows

Overview
This is a comprehensive Appium Automation Framework for automating Native, Hybrid, and Mobile Web applications. The framework supports dynamic data-driven testing, reusable mobile gestures, and seamless integration with CI/CD tools like Jenkins. It is designed to be modular, scalable, and easy to maintain.

1. Key Features
Automates Native Apps, Hybrid Apps, and Mobile Web Applications.
Includes reusable utilities for advanced mobile gestures (long press, swipe, drag, etc.).
JSON-based data-driven testing for flexible and scalable test scenarios.
Supports TestNG for parallel test execution and reporting.
Maven-managed dependencies for streamlined build and execution.
CI/CD integration with Jenkins and version control with GitHub.
Seamless context switching between NATIVE_APP and WEB_VIEW for hybrid app testing.

2. Prerequisites
Tools and Software
Step 1: Java Development Kit (JDK)
Download and install JDK 8 or above from Java SE Downloads.
Add JAVA_HOME to your system environment variables.
Step 2: Install Node.js
Download Node.js from the Node.js official website. Choose the LTS version.
Install Node.js by running the .msi installer.
Verify installation:
node -v
npm -v
Step 3: Install Appium
Install Appium globally:
npm install -g appium
Verify Appium installation:
appium -v
Step 4: Install Android SDK
Download and install Android Studio from the Android Studio website.
Install SDK Platforms and Tools:
Go to Settings > Appearance & Behavior > System Settings > Android SDK.
Set up environment variables:
Add a new system variable:
Variable name: ANDROID_HOME
Variable value: Path to the Android SDK (e.g., C:\Users\<YourUsername>\AppData\Local\Android\Sdk).
Add the following to the Path variable:
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools
Verify installation:
adb --version
Step 5: Set up Android Emulator
Use the Android Studio AVD Manager to create and start virtual devices.
Step 6: Install Maven
Download and install Maven from Maven Downloads.
Verify installation:
mvn -v
Step 7: Install ChromeDriver
Download the correct ChromeDriver version for your browser from ChromeDriver Downloads.
Place the driver in a known directory (e.g., C:\Automation\Drivers\chromedriver.exe).

3. Framework Setup
Step 1: Clone the Repository
git clone <your-repository-url>
cd AppiumAutomationFramework
Step 2: Place APK Files
Place APK files in: src/test/java/resources
APKs:
ApiDemos-debug.apk (for native app testing).
General-Store.apk (for hybrid and e-commerce scenarios).
Step 3: Configure Dependencies
Dependencies are defined in pom.xml, including:
Appium Java Client
Selenium
TestNG
Jackson Databind
Step 4: Configure TestNG XML
Define test classes in testng.xml:
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="Android.Appium.AppiumLocators"/>
      <class name="Android.Appium.MobileBrowserTest"/>
      <class name="Android.Appium.CartScenario"/>
      <class name="Android.Appium.wifiSettingMethod_dataJSON"/>
      <class name="Android.Appium.wifisettingtestmethod"/>
    </classes>
  </test>
</suite>
Step 5: Run Tests
Clean the project:
mvn clean
Run a single test:
mvn -Dtest=TestClassName test
Run tests with testng.xml:
mvn test -DsuiteXmlFile=testng.xml

4. Project Structure
AppiumAutomationFramework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Android/Appium/
│   │       │   ├── MobileGestures.java           # Utility for mobile gestures
│   │       │   └── DatafromFileToHashMap.java    # JSON to HashMap converter
│   ├── test/
│       └── java/
│           ├── Android/Appium/
│           │   ├── AppiumLocators.java           # Demonstrates Appium locators
│           │   ├── MobileBrowserTest.java        # Automates mobile browser
│           │   ├── CartScenario.java             # Handles hybrid app scenarios
│           │   ├── wifiSettingMethod_dataJSON.java  # JSON data-driven test
│           │   └── wifisettingtestmethod.java    # Tests for Wi-Fi settings
│       └── resources/
│           ├── ApiDemos-debug.apk
│           └── General-Store.apk
├── testng.xml             # TestNG suite configuration
├── pom.xml                # Maven configuration file
└── README.md              # Framework documentation

5. Jenkins Integration
Install Jenkins from the official website.
Start Jenkins:
java -jar jenkins.war
Configure Jenkins Pipeline:
Add your GitHub repository under Source Code Management.
Use the following Maven commands:
mvn clean
mvn -Dtest=TestClassName test
mvn test -DsuiteXmlFile=testng.xml

6. Highlights of the Framework
Reusable Mobile Gestures: Swipe, scroll, long press, and drag/drop.
Dynamic Data-Driven Testing: Reads test data from JSON files.
Hybrid App Testing: Handles seamless context switching between NATIVE_APP and WEB_VIEW.
Mobile Browser Testing: Automates Chrome browser on mobile devices.

7. Future Enhancements
Add detailed reporting with Extent Reports.
Implement parallel device testing.
Integrate cloud-based testing with platforms like BrowserStack or Sauce Labs.
