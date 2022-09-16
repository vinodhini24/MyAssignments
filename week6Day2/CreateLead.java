package week6Day2;


	import org.openqa.selenium.By;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class CreateLead extends CommonClass{

		
		@Test(dataProvider="testData")
		public void runCreate(String cname,String fname,String lname) {
			
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
			driver.findElement(By.name("submitButton")).click();
		}
			
			@DataProvider
			public String[][] testData() {
				String[][] data=new String[2][3];
				 data[0][0]="TestLeaf";
				 data[0][1]="Hari";
				 data[0][2]="R";
				 
				 data[1][0]="Wipro";
				 data[1][1]="Vino";
				 data[1][2]="K";
				 
				 return data;
			}
	}


