package PAC1;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC009_1 {
    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    // Extent Report objects - create once and reuse
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before Suite");

        // Initialize ExtentReports (only once)
        ExtentSparkReporter spark = new ExtentSparkReporter(projectpath + "\\Aug28th.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After Suite");
        // Write everything to the report file
        extent.flush();
    }

    @Test(dataProvider = "logindata")
    public void f(String username, String password) {
        System.out.println("This is the test");
        test = extent.createTest("Verify login with user: " + username);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginpage objlogin = new loginpage(driver);

        if (objlogin.usernameisdisplayed()) {
            objlogin.enterusername(username);
            System.out.println("Get placeholder: " + objlogin.unamegetattributevalue());
            test.pass("Username field is displayed");
        } else {
            System.out.println("Username is not displayed");
            test.fail("Username field is missing");
        }

        objlogin.enterpassword(password);
        objlogin.clickonbutton();

        if (objlogin.dashisdisplayed()) {
            test.pass("Login successful for user: " + username);
        } else {
            test.fail("Login failed for user: " + username);
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        driver.quit();
    }

    @DataProvider
    public String[][] logindata() throws IOException {
        File file1 = new File(projectpath + "\\data.xlsx");
        System.out.println("project path: " + projectpath);
        FileInputStream fs = new FileInputStream(file1);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        System.out.println("rows: " + rowcount);

        String[][] data = new String[rowcount][2];
        for (int i = 0; i < rowcount; i++) {
            data[i][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
            data[i][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
        }

        workbook.close();
        return data;
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }
}
