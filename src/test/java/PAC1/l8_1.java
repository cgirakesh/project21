package PAC1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class l8_1 {

    WebDriver driver;

    // ========= TEST CASE ==========
    @Test(dataProvider = "products")
    public void addProductToCart(String productCategory, String productSubCategory) {
        driver.get("https://tutorialsninja.com/demo/index.php?");

        // Navigate via Menu
        driver.findElement(By.linkText(productCategory)).click();
        driver.findElement(By.partialLinkText(productSubCategory)).click();

        // Handle sorting dropdown
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByIndex(1); // Selecting "Name (A - Z)"

        // Click Add to Cart for the first product
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Cart'])[1]")).click();

        System.out.println("Product from category: " + productCategory 
                           + " → " + productSubCategory + " added to cart.");
    }

    // ========= DATA PROVIDER ==========
    @DataProvider(name = "products")
    public Object[][] dp() {
        return new Object[][] {
            { "Desktops", "Mac" },  // Will match "Mac (1)" with partialLinkText
            { "Laptops & Notebooks", "Show All Laptops & Notebooks" }
        };
    }

    // ========= HOOKS ==========
    @BeforeMethod
    public void beforeMethod() {
        System.out.println(">> Before Method: Launching Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(">> After Method: Closing Browser");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(">> Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(">> After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(">> Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(">> After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">> Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">> After Suite");
    }
}
