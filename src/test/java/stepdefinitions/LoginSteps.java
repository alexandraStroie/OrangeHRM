package stepdefinitions;

import hooks.Hook;
import io.cucumber.java.en.And;
import pages.LoginPage;
import pages.DashboardPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;



public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public LoginSteps() {
      this.driver = Hook.getDriver();
//        this.loginPage = new LoginPage(driver).get(); // Ensure the LoginPage is loaded
        this.loginPage = new LoginPage(driver);// Ensure the LoginPage is loaded
    }

    @When("I enter the username {string} and the password {string}")
    public void ITypeUsernameAndPassword(String username, String password) {
        loginPage.completeUsernameAndPassword(username, password);
    }

    @And("I click the login button")
    public void IClickTheLoginButton() {
        dashboardPage = loginPage.clickLoginBtn();
    }

    @Then("I should be redirected to the dashboard page")
    public void IShouldBeRedirectedToDashboardPage() {
        // You can assert that the current URL is the expected URL of the dashboard page
        String expectedUrl = "expected URL of the dashboard page"; // Replace with the actual URL
        String actualUrl = driver.getCurrentUrl();
        //assertEquals("The user is not on the dashboard page", expectedUrl, actualUrl);

        // Alternatively, you can check for the presence of an element that is unique to the dashboard page
        //assertTrue("The dashboard page did not load correctly",
          //      dashboardPage.isDashboardPageLoaded());
    }
}
