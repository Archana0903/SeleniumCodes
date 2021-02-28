package seleniumcodepractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HashMapTest {
	
	public WebDriver driver;
	public String credentials;
	public String credentialinfo[];
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.crmpro.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
		
		@Test(priority = 1)
		public void loginwithAdminTest() {
			credentials = HashMapData.getUserLogInfo().get("admin");
			credentialinfo = credentials.split("_");
			driver.findElement(By.name("username")).sendKeys(credentialinfo[0]);
			driver.findElement(By.name("password")).sendKeys(credentialinfo[1]);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
		@Test(priority = 2)
		public void loginwithMyLogin() {
			credentials = HashMapData.getUserLogInfo().get("mylogin");
			credentialinfo = credentials.split("_");
			driver.findElement(By.name("username")).sendKeys(credentialinfo[0]);
			driver.findElement(By.name("password")).sendKeys(credentialinfo[1]);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
		
		@AfterMethod
		public void teardown(){
		driver.quit();	
		}
}
