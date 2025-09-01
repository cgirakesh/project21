package PAC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB06 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("vinodrakesh71@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
		
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		WebElement sort = driver.findElement(By.id("input-limit"));
		sort.click();
		Select sort1 = new Select(sort);
		sort1.selectByVisibleText("25");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		
		WebElement speci = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a"));
		speci.click();
		
		WebElement wish = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]"));
		wish.click();
		
		WebElement input = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		input.sendKeys("Mobile");
		WebElement enter = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		enter.click();
		

WebElement select = driver.findElement(By.xpath("//*[@id=\"description\"]"));
		select.click();

driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		
		driver.findElement(By.linkText("HTC Touch HD")).click();
		
		WebElement input2 = driver.findElement(By.xpath("//*[@id=\"input-quantity\"]"));
		input2.clear();
		input2.sendKeys("3");
		Thread.sleep(2000);
		
		WebElement enter2 = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
		enter2.click();
		Thread.sleep(3000);
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		String expectedMsg = "Success: You have added HTC Touch HD to your shopping cart!";
		if(message.getText().contains(expectedMsg)) {
			System.out.println("Message is appearing");
		}
		else {
			System.out.println("Message is not appearing");
		}
		
		driver.findElement(By.id("cart-total")).click();
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[2]/a"));
		String expectedTitle = "HTC Touch HD";
		if(title.getText().contains(expectedTitle)) {
			System.out.println("Mobile name is appearing");
		}
		else {
			System.out.println("Mobile name is not appearing");
		}
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		
		WebElement verifyHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		
		if(verifyHeading.getText().contains("Account Logout")) {
			System.out.println("Account is logged out");
		}
		else {
			System.out.println("Account is not logged out");
		}
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		driver.quit();
		
	}
}
