package orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
    WebDriver driver;

    // Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton   = By.xpath("//button[@type='submit']");
    By dashboardText = By.xpath("//h6[text()='Dashboard']");   // success locator
    By errorMessage  = By.xpath("//p[contains(@class,'oxd-alert-content-text')]"); // error locator

    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Method to verify successful login
    public boolean isLoginSuccessful() {
        try {
            return driver.findElement(dashboardText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to fetch error message (if login fails)
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return null;
        }
    }
}