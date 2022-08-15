package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Vinodhini");
		driver.findElement(By.name("lastname")).sendKeys("K");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9898989898");
		driver.findElement(By.id("password_step_input")).sendKeys("********");
		
		WebElement birth=driver.findElement(By.id("day"));
		Select option=new Select(birth);
		option.selectByValue("21");
		
		WebElement month=driver.findElement(By.name("birthday_month"));
		Select option1=new Select(month);
		option1.selectByIndex(3);
		
		WebElement year=driver.findElement(By.name("birthday_year"));
		Select option2=new Select(year);
		option2.selectByIndex(2);
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
	}

}
