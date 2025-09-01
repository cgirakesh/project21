package PAC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab08_3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		
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
		
		driver.quit();

	}

}