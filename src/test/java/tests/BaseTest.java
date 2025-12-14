package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ExcelUtils;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    public static WebDriver driver;
    public static String excelPath = System.getProperty("user.dir") + "\\Carb_Calculator_Test_Document_Aarya_Patel.xlsx";
    public static String sheetName = "Automation";

    public static void setUp() {
        // Suppress Selenium/Netty logs
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Logger.getLogger("io.netty").setLevel(Level.OFF);
        System.setProperty("webdriver.edge.silentOutput", "true");

        // Use your locally downloaded EdgeDriver
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\aarya\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/carbohydrate-calculator.html"); // Replace with your calculator URL
    }

    public static void tearDown() {
        if (driver != null) driver.quit();
    }

    public static void runTest(String testCaseID, Runnable testSteps, String expectedResult) {
        try {
            testSteps.run();
            ExcelUtils.updateTestResult(excelPath, sheetName, testCaseID, "Pass", expectedResult);
            System.out.println(testCaseID + " Passed");
        } catch (Exception e) {
            ExcelUtils.updateTestResult(excelPath, sheetName, testCaseID, "Fail", e.getMessage());
            System.out.println(testCaseID + " Failed: " + e.getMessage());
        }
    }
}
