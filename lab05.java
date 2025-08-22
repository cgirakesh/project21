package PAC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class lab05 {
    public static void main(String[] args) {
        // Path to geckodriver
    	System.setProperty("webdriver.gecko.driver", "C:\\ec\\geckodriver.exe");
   
        WebDriver driver = new FirefoxDriver();


        try {
            driver.manage().window().maximize();
            driver.get("https://tutorialsninja.com/demo/index.php?");

            // Verify Page Title
            String expectedTitle = "Your Store";
            String actualTitle = driver.getTitle();
            System.out.println("Page Title: " + actualTitle);
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("✅ Title Verified");
            } else {
                System.out.println("❌ Title Mismatch!");
            }

            // Navigate to Register Page
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.linkText("Register")).click();
            System.out.println("✅ Register Account Page Opened");

            // Submit empty form
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Privacy Policy Warning
            WebElement policyWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'alert-danger')]")));
            System.out.println("Warning Message: " + policyWarning.getText());

            // First Name Error
            WebElement fnameError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")));
            System.out.println("First Name Error: " + fnameError.getText());

            // Last Name Error
            WebElement lnameError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")));
            System.out.println("Last Name Error: " + lnameError.getText());

            // Email Error
            WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")));
            System.out.println("Email Error: " + emailError.getText());

            // Telephone Error
            WebElement phoneError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")));
            System.out.println("Telephone Error: " + phoneError.getText());

            // Password Error
            WebElement passError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")));
            System.out.println("Password Error: " + passError.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // ✅ always closes the browser
        }
    }
}
