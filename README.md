# IPL UI Automation Framework (Hybrid)

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
---

## Project Overview

This project is a **Hybrid UI Automation Framework** built to test the IPL website using:

> ✔ Page Object Model (POM)  
> ✔ Data-Driven Testing  
> ✔ Reusable Utilities

It automates key IPL user journeys like:

- Teams
- Points Table
- News
- Stats
- Venues
- Auction
- Footer validations

---

##  Tech Stack

- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Apache Maven
- **Reporting:** Extent Reports
- **Logging:** Log4j2

---

##  Project Structure
```
Precision_UI_Hybrid_Automation_Framework_IPL20
│
├── src/main/java/com/ipl/automation
│ ├── base → Driver setup & BaseTest
│ ├── pages → Page Object classes
│ ├── utils → Waits, Config, Screenshot, Reporting
│
├── src/test/java/tests
│ ├── TeamsTest.java
│ ├── PointsTableTest.java
│ ├── SearchTest.java
│ ├── StatsTest.java
│ ├── VenuesTest.java
│ ├── AuctionTest.java
│ ├── FooterLinksTest.java
│
├── src/main/resources
│ ├── config.properties
│ ├── log4j2.xml
│
├── src/test/resources
│ ├── testdata.json
│
├── pom.xml
└── README.md
```
---

## Test Coverage

| Module         | Description                                           |
|----------------|-------------------------------------------------------|
| Teams          | Validate teams listing and data correctness           |
| Points Table   | Verify rankings and table data                        |
| News           | Search and validate articles                          |
| Stats          | Validate statistics sections                          |
| Venues         | Verify venue details                                  |
| Auction        | Validate auction-related content                      |
| Footer Links   | Validate navigation links                             |

---

## Prerequisites

Ensure the following are installed:

- Java (JDK 8 or above)
- Maven
- Chrome and Edge Browser
- ChromeDriver and EdgeDriver

---

## Configuration

### Update Test data in JSON file
- To test the details of Top team in points table, we need to update the data in json file dynamically as the points table might change frequently.
```src/test/resources/testdata.json```

---

##  How to Run Tests

### Run All Tests
```
mvn clean test
```
---

### Run Specific Test
```
mvn test -Dtest=TeamsTest
```
---

### Run via TestNG XML
> Right Click → testng/testng-chrome.xml → Run
> 
> OR
> 
> Right Click → testng/testng-edge.xml → Run

---

##  Reporting

- Extent Reports are generated after execution 

Location: `/reports`

---

##  Screenshots

- Automatically captured on test failures

Handled by: ```ScreenshotUtils.java```

---

## Framework Highlights

- Hybrid Framework (POM + Data-Driven)
- Clean Page Object Design
- Reusable Utilities
- Logging with Log4j2
- Extent Reporting with Screenshots
- Scalable & Maintainable Architecture

---

##  Important Notes

Before execution:

- Ensure Java version matches to Java 17
- Update `config.properties` if needed
- Update data in `testdata.json` if the data to be verified is dynamic
- Internet connection is required
- UI changes in IPL website may break locators

---

## Future Enhancements

- CI/CD Integration (Jenkins / GitHub Actions)
- Parallel Test Execution
- Cross-browser Testing (Other than chrome and edge like firefox, Safari, etc.)

---

## Author

- **Vamsi Krishna Varma Kothapalli**

- **Doni Naga Siva Jogi**

---