package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC03_USMifflin extends BaseTest {

    public static void run() {
        runTest("TC-03", () -> {

            // Switch to US Units
            driver.findElement(By.linkText("US Units")).click();

            // Age
            WebElement age = driver.findElement(By.id("cage"));
            age.clear();
            age.sendKeys("40");

            // Gender (click LABEL, not radio input)
            WebElement maleLabel = driver.findElement(By.cssSelector("label[for='csex1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleLabel);

            // Height
            driver.findElement(By.id("cheightfeet")).clear();
            driver.findElement(By.id("cheightfeet")).sendKeys("5");

            driver.findElement(By.id("cheightinch")).clear();
            driver.findElement(By.id("cheightinch")).sendKeys("10");

            // Weight
            driver.findElement(By.id("cpound")).clear();
            driver.findElement(By.id("cpound")).sendKeys("180");

            // Activity level
            Select activity = new Select(driver.findElement(By.id("cactivity")));
            activity.selectByValue("1.9");


            // Open settings (click the <a>, not the div)
            driver.findElement(By.cssSelector("#ccsettingtitle a")).click();

            // Select Mifflin
            WebElement mifflinLabel = driver.findElement(By.cssSelector("label[for='cformula1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mifflinLabel);

            // Calculate
            driver.findElement(By.cssSelector("input[name='x']")).click();

            WebElement result = driver.findElement(By.cssSelector("h2.h2result + p.bigtext"));
            if (result.getText().isEmpty()) {
                throw new RuntimeException("No result displayed");
            } else {
                System.out.println("Calculation displayed correctly");
            }

            // Close settings so next test does not break
            driver.findElement(By.cssSelector("#ccsettingtitle a")).click();

        }, "US unit calculation displayed correctly");
    }
}
