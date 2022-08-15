package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement tool=driver.findElement(By.className("ui-selectonemenu"));
		Select opt=new Select(tool);
		opt.selectByVisibleText("Selenium");
		
		WebElement contry=driver.findElement(By.className("ui-selectonemenu-label ui-inputfield ui-corner-all"));
		Select opt1=new Select(contry);
		opt1.selectByVisibleText("Brazil");
		
		WebElement city=driver.findElement(By.id("j_idt87:city_label"));
		Select opt2=new Select(city);
		opt2.selectByVisibleText("Salvador");
		
		
		WebElement course=driver.findElement(By.id("j_idt87:auto-complete_input"));
		Select opt3=new Select(course);
		opt3.selectByVisibleText("JMeter");
		
		WebElement lang=driver.findElement(By.id("j_idt87:lang_label"));
		Select opt4=new Select(lang);
		opt4.selectByVisibleText("Tamil");
		
		
		WebElement lang1=driver.findElement(By.id("j_idt87:lang_label"));
		Select opt5=new Select(lang1);
		opt5.selectByVisibleText("Select Values");
		
		driver.close();

	}

}
