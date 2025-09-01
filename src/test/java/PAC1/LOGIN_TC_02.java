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

public class LOGIN_TC_02 {

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
        dest.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void verifyContactUsButton() {
        WebElement contactUsBtn = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
        Assert.assertTrue(contactUsBtn.isDisplayed(), "Contact Us button is not visible on Login page");
        takeScreenshot("ContactUsButton");
    }

    @Test(priority = 2)
    public void verifyScrollBar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        Long clientHeight = (Long) js.executeScript("return window.innerHeight;");

        boolean hasScroll = scrollHeight > clientHeight;
        Assert.assertTrue(hasScroll, "Scroll bar is not present on Login page");
        takeScreenshot("ScrollBar");
    }

    @Test(priority = 3)
    public void verifySubscriptionSection() {
        WebElement subscriptionSection = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscriptionSection.isDisplayed(), "Subscription section is not displayed on Login page");
        takeScreenshot("SubscriptionSection");
    }

    @Test(priority = 4)
    public void verifySubscriptionEmailField() {
        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(emailInput.isDisplayed(), "Subscription email input is not displayed");
        takeScreenshot("SubscriptionEmailField");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
