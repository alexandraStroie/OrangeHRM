package pages;

import loadableComponents.CustomLoadableComponent;
import loadableComponents.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
//public class DashboardPage extends CustomLoadableComponent<DashboardPage> {

    private final WebDriver driver;

    // Example element that signifies the Dashboard page is loaded
    @FindBy(id = "uniqueDashboardElement")
    private WebElement uniqueDashboardElement;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @Override
//    protected void load() {
//        // Not needed if this page is navigated to by the login process, but could be used for direct navigation
//    }
//
//    @Override
//    protected void isLoaded() throws Error {
//        // Use the IsLoaded utility to wait for a unique element on the dashboard page
//        IsLoaded.forThis(driver)
//                .whenElementIsVisible(uniqueDashboardElement, "Unique Dashboard element should be visible");
//    }

    public void verifyDashboardElements() {
        // Implement assertions or checks for elements on the dashboard
    }
}
