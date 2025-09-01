package PAC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
    WebDriver driver;

    // Locators
    private By uname = By.name("username");
    private By pwd = By.name("password");
    private By submit = By.xpath("//button[@type='submit']");
    private By dashboard = By.xpath("//h6[text()='Dashboard']");

    // Constructor
    public loginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Username
    public boolean usernameisdisplayed() {
        return driver.findElement(uname).isDisplayed();
    }

    public void enterusername(String username) {
        driver.findElement(uname).clear();
        driver.findElement(uname).sendKeys(username);
    }

    public String unamegetattributevalue() {
        return driver.findElement(uname).getAttribute("placeholder");
    }

    // Password
    public void enterpassword(String password) {
        driver.findElement(pwd).clear();
        driver.findElement(pwd).sendKeys(password);
    }

    // Submit Button
    public void clickonbutton() {
        driver.findElement(submit).click();
    }

    // Dashboard validation
    public boolean dashisdisplayed() {
        try {
            WebElement dash = driver.findElement(dashboard);
            return dash.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
