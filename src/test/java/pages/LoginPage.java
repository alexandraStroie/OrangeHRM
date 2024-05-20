package pages;

import utils.HelperClass;
import loadableComponents.CustomLoadableComponent;
import loadableComponents.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CustomLoadableComponent<LoginPage> {
    private WebDriver driver;

    @FindBy(css = "input.oxd-input[name='username']")
    private WebElement usernameInput;

    @FindBy(css = "input.oxd-input[name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage() {
        this.driver = HelperClass.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
    }


    @Override
    protected void isLoaded() throws Error {
        IsLoaded.forThis(driver)
                .whenElementIsVisible(usernameInput, "Username input should be visible")
                .whenElementIsVisible(passwordInput, "Password input should be visible")
                .whenElementIsVisible(loginButton, "Login button should be visible");
    }

    @Override
    protected boolean isAtPage() {
        return driver.getCurrentUrl().contains("login");
    }

    public LoginPage completeUsernameAndPassword(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public DashboardPage clickLoginBtn() {
        loginButton.click();
        return new DashboardPage();
    }
}
