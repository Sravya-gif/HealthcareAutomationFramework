# Test Framework Design

## Framework Type

Page Object Model (POM)


## Features

* Config-driven execution using `config.properties`
* Data-driven testing using Excel (DataProvider)
* Reusable Page methods (POM design)
* WebDriverWait for dynamic elements 
* Screenshot capture on failure 
* ExtentReports for HTML reporting

## Project Structure
```
HealthcareAutomationFramework
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.driver
│   │   └── DriverFactory.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── LoginPage.java
│   │   ├── AppointmentPage.java
│   │   ├── ConfirmationPage.java
│   │   └── HistoryPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExcelUtils.java
│   │   ├── ScreenshotUtil.java
│   │   └── ExtentManager.java
│
├── src/main/resources
│   ├── config.properties
│   └── testdata3.xlsx
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── LogoutTest.java
│       ├── AppointmentTest.java
│       ├── MultipleAppointmentTest.java
│       ├── HistoryTest.java
│       ├── ValidationTest.java
│       └── CommentValidationTest.java
│
├── testng.xml
├── pom.xml
```

## Test Coverage

* Login (valid & invalid)
* Logout
* Appointment Booking
* Multiple Appointments
* Appointment History Verification
* Form Validations (empty fields, long input)
  

##  Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports
