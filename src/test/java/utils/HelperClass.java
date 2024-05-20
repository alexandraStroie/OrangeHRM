package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelperClass {
    private static HelperClass instance;
    private static WebDriver driver;

    private HelperClass() {
        System.out.println("Initializing WebDriver...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("WebDriver initialized.");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openPage(String url) {
        System.out.println("URL to load: " + url);
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("The login URL cannot be null or empty.");
        }
        driver.get(url);
    }

    public static HelperClass getInstance() {
        if (instance == null) {
            synchronized (HelperClass.class) {
                if (instance == null) {
                    instance = new HelperClass();
                }
            }
        }
        return instance;
    }

    public void tearDown() {
        System.out.println("Running tearDown...");
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                System.out.println("Error while trying to close the WebDriver: " + e.getMessage());
            }
        }
        instance = null;
    }
}
