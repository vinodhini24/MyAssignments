package week6Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewProposal {
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
		
		//3.Select Proposal
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//div[@id='all']").click();
		WebElement propo=shadow.findElementByXPath("//input[@id='filter']");
		propo.sendKeys("Proposal",Keys.ENTER);
		shadow.findElementByXPath("//div[@id='all']").click();
		propo.sendKeys(Keys.ENTER);
		
		//4.Click New and fill the mandatory fields and click submit
		driver.switchTo().defaultContent();
		WebElement frame=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Selenium");
		driver.findElement(By.className("form_action_button  action_context btn btn-default")).click();
		
		driver.switchTo().defaultContent();
		WebElement frame1=shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Selenium",Keys.ENTER);
		String text=driver.findElement(By.xpath("//table[@id='std_change_proposal_table']//tbody/tr[14]/td[4]")).getText();
		System.out.println("New Proposal:"+text);
		
		//5.Verify the Successful creation of New Proposal
		if(text.contains("Selenium")) {
			System.out.println("New Proposal"+text+ "is created");
		}
		else
		{
			System.out.println("New Proposal"+text+"is not created");
		}
		Thread.sleep(2000);
		driver.close();
		}

	}

