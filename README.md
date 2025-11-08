TutorialsNinjaSeleniumProject
🚀 Project Overview

This project presents an automation test suite built using Selenium for the TutorialsNinja application (or demo site). Its purpose is to demonstrate end-to-end UI testing with a structured framework, reusable page objects, and a clean test architecture.

🧪 Key Features

Uses the Page Object Model (POM) design pattern for maintainability and readability.

Integrates Selenium WebDriver (Java) for browser automation.

Organized project structure: src/, screenshots/, test-output/, etc.

Includes sample test cases covering user flows on the TutorialsNinja site.

Capability to capture screenshots on failures (folder: screenshots/).

Built with Maven (pom.xml) to manage dependencies and builds.

📁 Project Structure
├── .mvn/                      # Maven wrapper files  
├── .settings/                 # IDE settings  
├── screenshots/               # Captured screenshots from test runs  
├── src/                       # Source code: page objects, tests, utils  
├── target/                    # Compiled output & reports (auto-generated)  
├── test-output/               # TestNG or other test report outputs  
├── .classpath                 # Eclipse classpath file  
├── .project                   # Eclipse project file  
└── pom.xml                    # Maven project configuration  

🛠 Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Build Tool: Maven

Test Framework: (e.g., TestNG/JUnit if used)

Reporting: HTML test reports, screenshot capture

🎯 Getting Started

Clone this repository:

git clone https://github.com/hariharan-16/TutorialsNinjaSeleniumProject.git


Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).

Make sure Maven dependencies are downloaded:

mvn clean install


Configure browser driver (e.g., ChromeDriver) path in your tests or utility class.

Run the test suite:

mvn test


After execution, view reports in test-output/ and screenshots in screenshots/.

✅ Sample Test Flow

Launch browser and navigate to TutorialsNinja homepage.

Perform login/register (if implemented) or browse products.

Add product(s) to cart, proceed to checkout (if implemented).

Validate UI elements, page titles, and expected behaviour.

Capture screenshot on failure and log details.

🗂 Screenshot Example

(Screenshots folder will store images captured during failures or test verification.)

📌 Customization

Update base URL, browser settings, and driver location in configuration.

Extend page objects and test cases as per new requirements.

Integrate CI/CD (Jenkins/GitHub Actions) for automated test runs.

Improve reporting with extent reports or Allure.

🧑‍💼 Author

Hariharan R – Software Tester and automation enthusiast.

📄 License

This project is open source and available under the MIT License
 (or whichever you prefer).
