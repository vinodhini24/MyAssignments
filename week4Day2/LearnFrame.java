package week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@id='content-wrapper']"));
		driver.switchTo().frame("content-wrapper");
		
		WebElement drag=driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][4]"));
		org.openqa.selenium.Point location=drag.getLocation();
		int x=location.getX();
		int y=location.getY();
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(drag, x+4, y+6).perform();
		

	}

}
