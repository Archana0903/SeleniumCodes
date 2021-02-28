package seleniumcodepractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class handlingDynamicWebtable {
	
	public static void main (String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://uhgvision-pwp-q2.spectera.com/PWP/Landing");
		Thread.sleep(3000);
		
		driver.findElement(By.id("UserName")).sendKeys("DOPT46111");
		driver.findElement(By.id("Password")).sendKeys("Temp2019!");
		driver.findElement(By.id("LoginBlockButton")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.id("DateOfServiceTextBox")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("DateOfServiceTextBox")).sendKeys("10082018");
		Thread.sleep(5000);
		driver.findElement(By.id("SubscriberId1TextBox")).sendKeys("882657408");
		Thread.sleep(5000);
		driver.findElement(By.id("VerifyButton")).click();
		Thread.sleep(3000);
		
	// this will store all the list items	
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='ResultSelectButton']"));
		System.out.println("Total number of select button is---- >>>> " +list.size());
		
	// these are the xpath for name field in the webtable; Reason for spilting to make it generic with no tr depedency	
	String before_xpath = "html/body/div[1]/div[2]/div[1]/div/div[3]/div/div[2]/div[1]/div/div[3]/wbx-eligibility-results/table/tbody/tr[";	
	String after_xpath = "]/td[1]";
	
	// this for loop will check for all the items available and then pick the item with "equals" condition.
	for (int i=1;i<list.size();i++) {
		String member_name= driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		System.out.println("member name is --->>>> "+member_name);
		
		if (member_name.equals("SPENCER NELSON")) {	
	// here the xpath is of select button in the webtable	
driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[3]/div/div[2]/div[1]/div/div[3]/wbx-eligibility-results/table/tbody/tr["+i+"]/td[4]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("ExamButton")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on specific member successfully");
		}	
	}
	//driver.close();
	
	}
}
	
	
	
		
	

		
		
		


