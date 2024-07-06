package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utils.ConfigLoader;
import utils.HelperClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardSteps {
    private DashboardPage dashboardPage;
    private WebDriver driver;

    public DashboardSteps() {
        this.driver = HelperClass.getInstance().getDriver();
        this.dashboardPage = new DashboardPage();
    }

    @And("I click the time at work clock")
    public void userClicksTheTimeAtWorkClock() {
        dashboardPage.clickTimeAtWorkClock();
    }

    @Then("I should be redirected to the attendance punch in time page")
    public void userIsRedirectedToAttendancePunchInTimeWorkPage() {
        String expectedUrl = ConfigLoader.getProperty("attendancePunchInUrl").trim();
        String actualUrl = driver.getCurrentUrl().trim();
        assertEquals(expectedUrl, actualUrl, "The user is not on the attendance page");
    }
}
