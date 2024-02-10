package pages;

import loadableComponents.CustomLoadableComponent;
import loadableComponents.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigLoader;

public class LoginPage {
//public class LoginPage extends CustomLoadableComponent<LoginPage> {
    private WebDriver driver;

    @FindBy(css = "input.oxd-input[name='username']")
    private WebElement usernameInput;

    @FindBy(css = "input.oxd-input[name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    // Constructor of the LoginPage class
    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @Override
//    protected void load() {
//        // Logic to navigate to the login page
//        String loginUrl = ConfigLoader.getProperty("loginUrl");
//        System.out.println("Navigating to: " + loginUrl);
//        if (loginUrl == null || loginUrl.trim().isEmpty()) {
//            throw new IllegalStateException("The login URL cannot be null or empty.");
//        }
//        driver.get(loginUrl);
//    }

//    @Override
//    protected void isLoaded() throws Error {
//        // Use the IsLoaded utility to wait for the username and password inputs and the login button
//        IsLoaded.forThis(driver)
//                .whenElementIsVisible(usernameInput, "Username input should be visible")
//                .whenElementIsVisible(passwordInput, "Password input should be visible")
//                .whenElementIsVisible(loginButton, "Login button should be visible");
//    }

    public LoginPage completeUsernameAndPassword(String username, String password) {
        usernameInput.clear(); // Clearing the field before sending keys
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this; // Return the current LoginPage object for method chaining
    }

    public DashboardPage clickLoginBtn() {
        loginButton.click();
//        return new DashboardPage(driver).get(); // Ensures the Dashboard page is loaded
        return new DashboardPage(driver); // Ensures the Dashboard page is loaded
    }
}
