package hook;

import utils.HelperClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void setUp() {
        System.out.println("Hook setUp: Run Before Scenario");
        driver = HelperClass.getInstance().getDriver();
    }

    @After
    public void tearDown() {
        HelperClass.getInstance().tearDown();
    }
}
