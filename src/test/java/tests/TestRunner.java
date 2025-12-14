package tests;

public class TestRunner {

    public static void main(String[] args) {

        // Start Edge WebDriver
        BaseTest.setUp();

        // Run all 5 test cases
        TC01_MetricMifflin.run();
        TC02_MetricKatch.run();
        TC03_USMifflin.run();
        TC13_NegativeAge.run();

        // Close browser
        BaseTest.tearDown();

        System.out.println("All tests executed. Check Excel sheet for results.");
    }
}
