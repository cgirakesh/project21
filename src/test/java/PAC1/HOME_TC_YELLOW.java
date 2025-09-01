package PAC1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class HOME_TC_YELLOW {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void verifyFeatureItemsSection() {
        WebElement featureItems = driver.findElement(By.xpath("//h2[text()='Features Items']"));
        Assert.assertTrue(featureItems.isDisplayed(), "Feature Items section is not displayed");
        System.out.println("Feature Items section is displayed");
    }

    @Test(priority = 2)
    public void verifyAddToCartIcon() {
        WebElement addToCart = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart icon is not displayed under product");
        System.out.println("Add to Cart icon is displayed");
    }

    @Test(priority = 3)
    public void verifyProductCostDisplayed() {
        WebElement productPrice = driver.findElement(By.xpath("(//h2[contains(text(),'Rs.')])[1]"));
        Assert.assertTrue(productPrice.isDisplayed(), "Product cost is not displayed");
        System.out.println("Product cost is displayed: " + productPrice.getText());
    }

    @Test(priority = 4)
    public void verifyViewProductButton() {
        WebElement viewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        Assert.assertTrue(viewProduct.isDisplayed(), "View Product button is not displayed");
        System.out.println("View Product button is displayed");
    }

    @Test(priority = 5)
    public void verifyRedirectToProductDetails() {
        WebElement viewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        viewProduct.click();

        WebElement productDetails = driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productDetails.isDisplayed(), "Redirection to product details page failed");
        System.out.println("Successfully redirected to Product Details page");
        
        driver.navigate().back(); // return to home page
        driver.quit();
    }

    
    
    }

