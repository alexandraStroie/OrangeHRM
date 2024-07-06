package pages;

import loadableComponents.CustomLoadableComponent;
import loadableComponents.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.HelperClass;

public class PunchInTimePage extends CustomLoadableComponent<PunchInTimePage> {
    private final WebDriver driver;

    @FindBy(css = ".oxd-icon-button.oxd-icon-button--solid-main.orangehrm-attendance-card-action")
    private WebElement punchInButton;

    @FindBy(xpath = "//h6[text()='Punch In']")
    private WebElement punchInTitle;

    public PunchInTimePage() {
        this.driver = HelperClass.getInstance().getDriver();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        IsLoaded.forThis(driver)
                .whenElementIsVisible(punchInButton, "Punch In button should be visible")
                .whenElementIsVisible(punchInTitle, "Punch In title should be visible");
    }

    @Override
    protected boolean isAtPage() {
        return driver.getCurrentUrl().contains("attendance");
    }


}
