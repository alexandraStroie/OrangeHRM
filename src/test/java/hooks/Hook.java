package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigLoader;

public class Hook {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Before
    public void setUp() {
        driver = getDriver(); // Get the driver using the Singleton pattern
        String url = ConfigLoader.getProperty("loginUrl");  // Navigate to the login page
        System.out.println("Navigating to: " + url);
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("The login URL cannot be null or empty.");
        }
        driver.get(url);
    }

    @After
    public void tearDown() {
        // Close the browser and quit the WebDriver after each test
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure the driver is set to null after quitting
        }
    }
}
