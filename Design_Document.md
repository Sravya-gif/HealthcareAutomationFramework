# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Architecture / Structure

The framework is designed using layered architecture:

1. **Base Layer**

  * Contains BaseTest and BasePage classes
  * Handles WebDriver initialization and common methods

2. **Page Layer**

  * Contains Page classes (LoginPage, AppointmentPage, HistoryPage, ConfirmationPage)
  * Includes locators and reusable actions

3. **Test Layer**

  * Contains all TestNG test classes
  * Executes test scenarios using Page methods

4. **Utility Layer**

  * Contains reusable utilities like:

    * ConfigReader
    * ExcelUtils (Data-driven testing)
    * ScreenshotUtil
    * ExtentReports Manager

---

## Features

* Config-driven execution using `config.properties`
* Data-driven testing using Excel (DataProvider)
* Reusable Page methods (POM design)
* WebDriverWait for dynamic elements 
* Screenshot capture on failure 
* ExtentReports for HTML reporting

---

## Test Flow

1. Launch Browser
2. Login to Application
3. Perform Appointment Booking
4. Verify Appointment History
5. Execute Validation Scenarios
6. Logout and Close Browser

---

## Test Coverage

* Login (valid & invalid)
* Logout
* Appointment Booking
* Multiple Appointments
* Appointment History Verification
* Form Validations (empty fields, long input)

---

##  Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports
