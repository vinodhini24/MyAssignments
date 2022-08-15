package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		//String title=driver.getTitle();
		System.out.println("The title is:"+driver.getTitle());
		driver.findElement(By.cssSelector("color")).getAttribute("color");
		
		//driver.findElement(By.xpath("//div[@class='card']")).click();
		//driver.findElement(By.xpath("//span[text()='Submit']")).click();
		driver.close();
	}
}
