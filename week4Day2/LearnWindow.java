package week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		int size=windowHandles.size();
		System.out.println(size);
		driver.close();
		
		List<String> switchToWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchToWindow.get(2));
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
		driver.switchTo().window(switchToWindow.get(2));
		
		


	}

}
