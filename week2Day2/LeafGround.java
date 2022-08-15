package week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("j_idt88:name")).sendKeys("Vinodhini");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("--INDIA");
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		driver.findElement(By.id("j_idt88:j_idt97")).click();
		driver.findElement(By.id("j_idt88:j_idt97")).sendKeys("Can you clear me, please?");
		driver.findElement(By.id("j_idt88:j_idt99")).click();
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("vinodhini@gmail.com");
		driver.findElement(By.id("j_idt88:j_idt101")).click();
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("Vino from VELLORE");
		driver.findElement(By.id("j_idt106:thisform:age")).click();
		driver.findElement(By.id("j_idt106:float-input")).click();
		driver.findElement(By.id("j_idt106:float-input")).sendKeys("Vino");
		driver.findElement(By.id("j_idt106:auto-complete_input")).click();
		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Vino");
		
		//WebElement third=driver.findElement(By.xpath("//li[@data-item-label='vino2']"));
		//Select option=new Select(third);
		//option.selectByVisibleText("vino2");
		
		driver.findElement(By.id("j_idt106:j_idt116_input")).click();
		driver.findElement(By.xpath("//a[text()='21']")).click();
		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("100");
		driver.findElement(By.id("j_idt106:slider")).click();
		driver.findElement(By.id("j_idt106:slider")).sendKeys("25");
		//driver.findElement(By.id("ui-inputfield ui-keyboard-input ui-widget ui-state-default ui-corner-all is-keypad")).click();
		//driver.findElement(By.className("keypad-special keypad-close ui-corner-all ui-state-default ui-state-highlight")).click();
		driver.findElement(By.className("ql-editor ql-blank")).click();
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Hi.....How Are You??");
	}
}
