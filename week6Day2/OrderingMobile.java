package week6Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile {
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
		
		
		//3.Click Service Catalog
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//4.Click On mobiles
		WebElement frame1=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		shadow.findElementByXPath("(//div[@class='homepage_category_only']//table)[8]").click();
		
		driver.switchTo().defaultContent();
		WebElement frame2=shadow.findElementByXPath("//iframe[id='gsft_main']");
		driver.switchTo().frame(frame2);
		
		//5.Click in iphone6s
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		
		driver.switchTo().defaultContent();
		WebElement frame3=driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		
		//6.Select color field to gold
		WebElement select=driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select color=new Select(select);
		color.selectByVisibleText("Gold");
		
		driver.switchTo().defaultContent();
		WebElement frame4=driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);
		
		//Select storage field to 128GB
		WebElement select1=driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select storage=new Select(select1);
		storage.selectByVisibleText("128");
		
		//7.Click Order now
		driver.switchTo().defaultContent();
		WebElement frame5=driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//table[@id='qty']/tbody/tr[8]/td/button[1]")).click();
		
		driver.switchTo().defaultContent();
		WebElement frame6=driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame6);
		String msg=driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		System.out.println("Status of the order placed is:"+msg);
		
		
		//8.Verify order is placed and get Request number
		if(msg.contains("Thank you")) {
			System.out.println("The order is placed");
		}
		else {
			System.out.println("The order is not placed");
		}
		String num=driver.findElement(By.xpath("//a[@class='linked requestItemUrl']/b")).getText();
		System.out.println("The Request number is:"+num);
		Thread.sleep(2000);
		driver.close();
		
	}
}
