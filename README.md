# Carbohydrate Calculator Automation

## Project Overview
This project automates testing of the [Carbohydrate Calculator](https://www.calculator.net/carbohydrate-calculator.html) to ensure:

- Accurate carbohydrate calculations
- Proper input validation (age, gender, height, weight, activity level)
- Stable behavior for reset and page refresh

Automation uses **Selenium WebDriver** with **Edge browser** and **Java 21**, logging results to an **Excel sheet**.

## Test Strategy
- **Objective:** Verify accuracy, reliability, and stability of the calculator
- **Scope:** Input validation, calculation logic, results display, reset, refresh
- **Out of Scope:** Backend systems or unrelated calculators
- **Test Types:** Manual functional testing, automated regression testing
- **Automation Scope:** Core functionality, input validation, reset, and refresh
- **Environment:** Microsoft Edge 

## Automated Test Cases
Currently automated:
1. TC-01: Standard carbohydrate calculation  
2. TC-02: Age input validation  
3. TC-03: Activity level validation  
4. TC-13: Reset input functionality  

Test results are updated automatically in the Excel sheet on the Automation sheet.

## Setup Instructions

## Project Structure
CarbCalculatorAutomation/

├─ src/main/java/utils/ExcelUtils.java # Excel helper

├─ src/test/java/tests/BaseTest.java # Setup and reusable methods

├─ src/test/java/tests/TestRunner.java # Runs all automated tests

├─ Carb_Calculator_Test_Document_Aarya_Patel.xlsx # Test cases

├─ pom.xml # Maven dependencies

└─ README.md # This file

### Prerequisites
- Java 21 installed  
- Maven installed  
- Microsoft Edge installed  
- Edge WebDriver (`msedgedriver.exe`) downloaded  

### Steps
1. Clone the repo
2. Navigate to the project:
   cd CarbCalculatorAutomation
3. Update the Edge WebDriver path in BaseTest.java:
   System.setProperty("webdriver.edge.driver", "C:\\Users\\<username>\\Downloads\\edgedriver_win64\\msedgedriver.exe");
4. Ensure the Excel test document is at the path specified in BaseTest.java:
  public static String excelPath = System.getProperty("user.dir") + "\\Carb_Calculator_Test_Document_Aarya_Patel.xlsx";

### Running the Tests
- Run TestRunner.java to excute all 4 test cases
