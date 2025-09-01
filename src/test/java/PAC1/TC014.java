package PAC1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC014 {

    WebDriver driver;   // Declare globally so all methods can use

    @Parameters("browser")
    @Test
    public void test2(String browser) {
        String url = "https://www.flipkart.com/";

        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("This is Chrome Test");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("This is Firefox Test");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            System.out.println("This is Edge Test");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } 
        else {
            throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();   // Always close browser after test
        }
    }
}
