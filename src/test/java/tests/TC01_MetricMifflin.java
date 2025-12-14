package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC01_MetricMifflin extends BaseTest {

    public static void run() {
        runTest("TC-01", () -> {
            // Click Metric units (ensure it's actually Metric)
            WebElement metricLink = driver.findElement(By.cssSelector("li#menuon > a"));
            if (!metricLink.getText().contains("Metric")) {
                metricLink.click();
            }

            // Enter Age
            WebElement ageInput = driver.findElement(By.id("cage"));
            ageInput.clear();
            ageInput.sendKeys("25");

            // Select Gender: Male
            driver.findElement(By.cssSelector("label[for='csex1']")).click();

            // Enter Height and Weight (Metric)
            WebElement heightInput = driver.findElement(By.id("cheightmeter"));
            heightInput.clear();
            heightInput.sendKeys("175");

            WebElement weightInput = driver.findElement(By.id("ckg"));
            weightInput.clear();
            weightInput.sendKeys("70");

            // Select Activity level
            Select activity = new Select(driver.findElement(By.id("cactivity")));
            activity.selectByVisibleText("Moderate: exercise 4-5 times/week");

            // Open Settings if hidden and select Mifflin formula
            WebElement settingsLink = driver.findElement(By.cssSelector("#ccsettingtitle a"));
            if (settingsLink.getText().contains("+ Settings")) {
                settingsLink.click();
            }
            driver.findElement(By.cssSelector("label[for='cformula1']")).click();

            // Click Calculate
            driver.findElement(By.cssSelector("input[name='x']")).click();

            // CLOSE Settings so next test starts clean
            driver.findElement(By.cssSelector("#ccsettingtitle a")).click();

            // Wait a moment for result to appear
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

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
