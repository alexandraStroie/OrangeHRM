package loadableComponents;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IsLoaded {
    private final WebDriver driver;

    private IsLoaded(WebDriver driver) {
        this.driver = driver;
    }

    public static IsLoaded forThis(WebDriver driver) {
        return new IsLoaded(driver);
    }

    public IsLoaded whenElementIsVisible(WebElement element, String description) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
            return this; // Allows for method chaining
        } catch (NoSuchElementException e) {
            throw new AssertionError(description + " is not visible. " + e.getMessage());
        }
    }

    public IsLoaded whenTitleIs(String expectedTitle, String description) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleIs(expectedTitle));
            return this;
        } catch (Exception e) {
            throw new AssertionError(description + " - Expected title: '" + expectedTitle + "'. " + e.getMessage());
        }
    }

    public IsLoaded whenElementTextIs(WebElement element, String expectedText, String description) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            return this;
        } catch (Exception e) {
            throw new AssertionError(description + " - Expected text: '" + expectedText + "'. " + e.getMessage());
        }
    }

}