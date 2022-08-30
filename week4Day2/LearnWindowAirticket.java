package week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowAirticket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		WebElement ok=driver.findElement(By.xpath("//div[@class='text-center col-xs-12']//parent::button"));
		ok.click();
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		

		Set<String> windowHandles=driver.getWindowHandles();
		List<String> switchToWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchToWindow.get(1));
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
		driver.switchTo().window(switchToWindow.get(0));
		driver.close();
		
		
		

	}

}
