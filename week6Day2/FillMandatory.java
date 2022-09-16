package week6Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class FillMandatory {
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
		
		//3.Select knowledge in filter
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//div[@id='all']").click();
		WebElement knowledge=shadow.findElementByXPath("//input[@id='filter']");
		knowledge.sendKeys("Knowledge",Keys.ENTER);
		shadow.findElementByXPath("//div[@id='all']").click();
		knowledge.sendKeys(Keys.ENTER);
		
		//4.Create New Article
		driver.switchTo().defaultContent();
		WebElement frame=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		
		//5.Select knowledge base as IT and category as IT-java and click ok
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>it=new ArrayList<String>(windowHandles);
		driver.switchTo().window(it.get(1));
		driver.findElement(By.linkText("IT")).click();
		driver.switchTo().window(it.get(0));
		WebElement frame1=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='list-item arrow']/following-sibling::div)[3]")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		//6.Update the other mandatory fields
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Selenium is better than java");
		
		//7.Click Submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
}
}
