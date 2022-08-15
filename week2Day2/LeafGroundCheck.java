package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheck {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all")).click();
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		System.out.println(driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled());
		driver.findElement(By.className("ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all")).click();

}
}