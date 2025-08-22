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

            // ================== Part 1 ==================
            // Verify Page Title
            String expectedTitle = "Your Store";
            String actualTitle = driver.getTitle();
            System.out.println("Page Title: " + actualTitle);
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Title Verified");
            } else {
                System.out.println("Title Mismatch!");
            }

            // Navigate to Register Page
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.linkText("Register")).click();
            System.out.println("Register Account Page Opened");

            // Verify heading
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Register Account')]")));
            System.out.println("Heading Verified: " + heading.getText());

            // Click Continue without filling form
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

            // Verify warning for Privacy Policy
            WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'alert-danger')]")));
            System.out.println("Warning Message: " + warning.getText());

            // ================== Part 2: Personal Details ==================
            // First Name with >32 characters
            String longName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
            driver.findElement(By.id("input-firstname")).sendKeys(longName);

            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            WebElement fnameError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")));
            System.out.println("First Name Error: " + fnameError.getText());

            // Enter valid First Name
            driver.findElement(By.id("input-firstname")).clear();
            driver.findElement(By.id("input-firstname")).sendKeys("Rakesh");

            // Last Name with >32 characters
            driver.findElement(By.id("input-lastname")).sendKeys(longName);
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            WebElement lnameError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")));
            System.out.println("Last Name Error: " + lnameError.getText());

            // Enter valid Last Name
            driver.findElement(By.id("input-lastname")).clear();
            driver.findElement(By.id("input-lastname")).sendKeys("Royal");

            // Valid email
            driver.findElement(By.id("input-email")).sendKeys("rakesh" + System.currentTimeMillis() + "@gmail.com");

            // Telephone validation (<3 chars)
            driver.findElement(By.id("input-telephone")).sendKeys("12");
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            WebElement telError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")));
            System.out.println("Telephone Error: " + telError.getText());

            // Enter valid Telephone
            driver.findElement(By.id("input-telephone")).clear();
            driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

            // ================== Part 4: Password ==================
            driver.findElement(By.id("input-password")).sendKeys("Test@123");
            driver.findElement(By.id("input-confirm")).sendKeys("Test@123");

            // Newsletter Yes
            driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();

            // Privacy Policy Checkbox
            driver.findElement(By.name("agree")).click();

            // Click Continue
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

            // Verify Account Created Message
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")));
            System.out.println("Success Message: " + successMsg.getText());

            // Click Continue
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

            // Click on "View your order history"
            WebElement orderHistoryLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.linkText("View your order history")));
            orderHistoryLink.click();

            System.out.println("Navigated to Order History Page");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); 
    }
}
}