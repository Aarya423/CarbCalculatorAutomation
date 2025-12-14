package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC02_MetricKatch extends BaseTest {

    public static void run() {
        runTest("TC-02", () -> {
            // Enter Age
            WebElement ageInput = driver.findElement(By.id("cage"));
            ageInput.clear();
            ageInput.sendKeys("30");

            // Select Gender: Female
            driver.findElement(By.cssSelector("label[for='csex2']")).click();

            // Enter Height and Weight (Metric)
            WebElement heightInput = driver.findElement(By.id("cheightmeter"));
            heightInput.clear();
            heightInput.sendKeys("165");

            WebElement weightInput = driver.findElement(By.id("ckg"));
            weightInput.clear();
            weightInput.sendKeys("60");

            // Select Activity level
            driver.findElement(By.id("cactivity")).sendKeys("Light: exercise 1-3 times/week");

            // Open Settings and select Katch-McArdle formula
            driver.findElement(By.cssSelector("#ccsettingtitle a")).click();
            driver.findElement(By.cssSelector("label[for='cformula2']")).click();

            // Enter Body Fat %
            WebElement bodyFat = driver.findElement(By.name("cfatpct"));
            bodyFat.clear();
            bodyFat.sendKeys("20");

            // Click Calculate
            driver.findElement(By.cssSelector("input[name='x']")).click();

            // CLOSE Settings so next test starts clean
            driver.findElement(By.cssSelector("#ccsettingtitle a")).click();

            // Check Result
            WebElement result = driver.findElement(By.cssSelector("h2.h2result + p.bigtext"));
            if (result.getText().isEmpty()) {
                throw new RuntimeException("No result displayed");
            } else {
                System.out.println("Calculation displayed correctly");
            }

        }, "Calculation displayed correctly");
    }
}
