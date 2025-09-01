package PAC1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class LOGIN_TC_01 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/login");
    }

    // Utility method for screenshot
    public void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        dest.getParentFile().mkdirs(); // create folder if not exists
        try {
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void verifyCartButton() {
        WebElement cartBtn = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
        Assert.assertTrue(cartBtn.isDisplayed(), "Cart button is not visible on Login page");
        takeScreenshot("CartButton");
    }

    @Test(priority = 2)
    public void verifySignupLoginButton() {
        WebElement signupBtn = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        Assert.assertTrue(signupBtn.isDisplayed(), "Signup/Login button is not visible on Login page");
        takeScreenshot("SignupLoginButton");
    }

    @Test(priority = 3)
    public void verifyTestCasesButton() {
        WebElement testCasesBtn = driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
        Assert.assertTrue(testCasesBtn.isDisplayed(), "Test Cases button is not visible on Login page");
        takeScreenshot("TestCasesButton");
    }

    @Test(priority = 4)
    public void verifyApiTestingButton() {
        WebElement apiBtn = driver.findElement(By.xpath("//a[contains(text(),'API Testing')]"));
        Assert.assertTrue(apiBtn.isDisplayed(), "API Testing button is not visible on Login page");
        takeScreenshot("ApiTestingButton");
    }

    @Test(priority = 5)
    public void verifyVideoTutorialsButton() {
        WebElement videoBtn = driver.findElement(By.xpath("//a[contains(text(),'Video Tutorials')]"));
        Assert.assertTrue(videoBtn.isDisplayed(), "Video Tutorials button is not visible on Login page");
        takeScreenshot("VideoTutorialsButton");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
