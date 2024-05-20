package stepdefinitions;

import io.cucumber.datatable.DataTable;
import utils.ConfigLoader;
import utils.HelperClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.DashboardPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = HelperClass.getDriver();
        this.dashboardPage = new DashboardPage();
        this.loginPage = new LoginPage();
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        String loginUrl = ConfigLoader.getProperty("loginUrl");
        HelperClass.openPage(loginUrl);
        loginPage.get();
    }

    @When("I enter the username {string} and the password {string}")
    public void ITypeUsernameAndPassword(String username, String password) {
        loginPage.completeUsernameAndPassword(username, password);
    }

    @When("I enter the following credentials")
    public void iEnterTheFollowingCredentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            String username = credential.get("username");
            String password = credential.get("password");
            loginPage.completeUsernameAndPassword(username, password);
        }
    }

    @And("I click the login button")
    public void IClickTheLoginButton() {
        dashboardPage = loginPage.clickLoginBtn();
    }

    @Then("I should be redirected to the dashboard url")
    public void IShouldBeRedirectedToDashboardUrl() {
        String expectedUrl = ConfigLoader.getProperty("dashboardUrl").trim();
        String actualUrl = driver.getCurrentUrl().trim();
        assertEquals(expectedUrl, actualUrl, "The user is not on the dashboard page");
    }
}
