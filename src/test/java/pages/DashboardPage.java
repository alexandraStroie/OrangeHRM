package pages;

import loadableComponents.CustomLoadableComponent;
import loadableComponents.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class DashboardPage extends CustomLoadableComponent<DashboardPage> {

    private final WebDriver driver;
    @FindBy(id = "uniqueDashboardElement")
    private WebElement uniqueDashboardElement;

    public DashboardPage() {
        this.driver = HelperClass.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        // Not needed if this page is navigated to by the login process, but could be used for direct navigation
    }

    @Override
    public void isLoaded() throws Error {
        IsLoaded.forThis(driver)
                .whenElementIsVisible(uniqueDashboardElement, "Unique Dashboard element should be visible");
    }

    @Override
    public boolean isAtPage() {
        return driver.getCurrentUrl().contains("dashboard");
    }
}
