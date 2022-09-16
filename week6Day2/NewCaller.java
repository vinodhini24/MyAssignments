package week6Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewCaller {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1.Launch url
		driver.get("https://dev116151.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//2.Login with valid credentials
		WebElement user=driver.findElement(By.id("user_name"));
		user.click();
		user.sendKeys("admin");
		WebElement pass=driver.findElement(By.id("user_password"));
		pass.click();
		pass.sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3.Select Callers in filter
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//div[@id='all']").click();
		WebElement caller=shadow.findElementByXPath("//input[@id='filter']");
		caller.sendKeys("Callers",Keys.ENTER);
		shadow.findElementByXPath("//div[@id='all']").click();
		caller.sendKeys(Keys.ENTER);
		
		//4.Create New Caller and fill fields then click submit
		driver.switchTo().defaultContent();
		WebElement frame=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Vinodhini");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("K");
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("vinosudha4u@gmail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9952672377");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("9952672377");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		
		
		//5.Search and verify the newly created Caller
		driver.switchTo().defaultContent();
		WebElement frame1=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Vinodhini",Keys.ENTER);
		
		String text=driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody/tr/td[4]")).getText();
		System.out.println("The newly created caller is:"+text);
		if(text.contains("Vinodhini"))
		{
			System.out.println("New caller" +text+ "is created");
		}
		else
		{
			System.out.println("New caller" +text+ "is not created");
		}
		Thread.sleep(2000);
		driver.close();

}
}