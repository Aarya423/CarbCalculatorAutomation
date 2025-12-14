package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC13_NegativeAge extends BaseTest {

    public static void run() {
        runTest("TC-13", () -> {

            // Clear and enter invalid age
            WebElement ageInput = driver.findElement(By.id("cage"));
            ageInput.clear();
            ageInput.sendKeys("-5"); // below minimum (18)

            // Click Calculate
            driver.findElement(By.cssSelector("input[name='x']")).click();

            // Locate error message by text (robust approach)
            WebElement errorMessage = driver.findElement(
                    By.xpath("//font[contains(text(),'Please provide an age between')]")
            );

            if (!errorMessage.isDisplayed()) {
                throw new RuntimeException("Age validation error not displayed");
            } else {
                System.out.println("Age validation error is displayed");
            }

        }, "Validation error displayed for age outside valid range");
    }
}
