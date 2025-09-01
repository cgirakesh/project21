package PAC1;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

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

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC010 {
	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
	  Thread.sleep(5000);	
	  String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		//Assert.assertEquals(title, "Amazon");
		ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\Augreport.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath);
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of the page");
		if(title.equals("orangehrm"))
		{
			test.pass("title is matched");
		}
		else
		{
			test.fail("title is not mathed");
			
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest=projectpath+"\\screenshot1.png";
			File detfile=new File(dest);
			FileUtils.copyFile(scr, detfile);
			test.addScreenCaptureFromPath(dest);
		}
		
		extent.flush();
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		LOGINPAGE_OBJ obj=new LOGINPAGE_OBJ(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
	//	driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys(password);
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
  String[][] data=new String[3][2];
	  
	 
	  File file1=new File(projectpath+"\\data.xlsx");
	  System.out.println("file path is:"+file1);
	  FileInputStream fs=new FileInputStream(file1);
	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
	  XSSFSheet worksheet=workbook.getSheetAt(0);
	  int rowcount=worksheet.getPhysicalNumberOfRows();
	  System.out.println("rows:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
	 
		  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
	  }
	  
	  return data;
	  
    
    }
  
 
 

}