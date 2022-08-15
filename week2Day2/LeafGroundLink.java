package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.xpath("//a[text()='Go to Dashboard']")).click();
		System.out.println("The url is:"+driver.getCurrentUrl());
		//driver.findElement(By.xpath("//a[text()='Broken?']")).click();
		driver.findElement(By.linkText("How many links in this page?")).getAttribute("href");
		driver.findElement(By.linkText("How many links in this layout?")).getAttribute("href");
	}

}
