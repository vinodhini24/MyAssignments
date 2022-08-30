package week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		List<String> switchToWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchToWindow.get(1));
		
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title=driver.getTitle();
	    System.out.println(title);
	    
	    driver.close();
	    driver.switchTo().window(switchToWindow.get(0));
		
		
		
		
		
		

	}

}
