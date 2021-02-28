package seleniumcodepractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class FreeCRMAutomation {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.crmpro.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		//finding total number of links+broker Links in login page
		
		List<WebElement> alink = driver.findElements(By.tagName("a"));
		List<WebElement> imglink = driver.findElements(By.tagName("img"));
		alink.addAll(imglink);
		System.out.println("Total number of links in the Login page is ::" + alink.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for (int i=0;i<alink.size();i++) {
			if (alink.get(i).getAttribute("href") != null) {
				activelinks.add(alink.get(i));
			}
		}
		System.out.println("Total number of active links in the Login page is ::" + activelinks.size());
		
		// Logging into the system
		driver.findElement(By.name("username")).sendKeys("Archana1712");
		driver.findElement(By.name("password")).sendKeys("jobseeker");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		System.out.println("Switched to frame successfully");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		Thread.sleep(3000);
		
		//adding contacts
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test121");
		driver.findElement(By.id("surname")).sendKeys("Test121");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test122");
		driver.findElement(By.id("surname")).sendKeys("Test122");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test123");
		driver.findElement(By.id("surname")).sendKeys("Test123");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test124");
		driver.findElement(By.id("surname")).sendKeys("Test124");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test125");
		driver.findElement(By.id("surname")).sendKeys("Test125");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Test126");
		driver.findElement(By.id("surname")).sendKeys("Test126");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		/*
		// working in Tasks Tab
		Actions tasktab = new Actions(driver);
		tasktab.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Tasks')]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'New Task')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Lookup'])[1]")).click();
		*/
		
		
		
		// Deleting the created contacts
		driver.findElement(By.xpath("//a[contains(text(),'Test121 Test121')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Test122 Test122')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert1.accept();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Test123 Test123')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(6000);
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert2.accept();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Test124 Test124')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(3000);
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert3.accept();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Test125 Test125')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(3000);
		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert4.accept();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Test126 Test126')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(3000);
		Alert alert5 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert5.accept();
		Thread.sleep(6000);
		
		
		/*
		// to check -- handling the webtable
		.//*[@id='vContactsForm']/table/tbody/tr[7]/td[1]/input
		.//*[@id='vContactsForm']/table/tbody/tr[8]/td[1]/input
		.//*[@id='vContactsForm']/table/tbody/tr[9]/td[1]/input */
		
		
		
		
	}
	

}
