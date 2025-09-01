package PAC1;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class l8_2 {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void f(Integer n, String s) {
        driver.get("https://tutorialsninja.com/demo/index.php?");
        System.out.println("Running test with: " + n + " and " + s);

        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();

        driver.findElement(By.id("input-limit")).click();
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/i")).click();

        WebElement input = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        input.sendKeys("Mobile");
        input.clear();

        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        driver.quit();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { 1, "a" },
            new Object[] { 2, "b" },
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After Suite");
    }
}
