package PAC1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");

		System.out.println("title is:"+driver.getTitle());

		System.out.println("url is:"+driver.getCurrentUrl());

		System.out.println("page source is:"+driver.getPageSource());
 
        // Setup ChromeDriver using WebDriverManager
       // WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
      /*  WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://google.com/");
        
        System.out.println("title is:"+driver.getTitle());
		driver.navigate().to("https://www.yahoo.com");
		System.out.println("title is:"+driver.getTitle());
		driver.navigate().back();
		System.out.println("After back title is:"+driver.getTitle());
		driver.navigate().forward();
		System.out.println("After forward title is:"+driver.getTitle());
        // Close browser after use (optional)
        driver.quit();*/
    }
}
