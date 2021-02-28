package seleniumcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class framehandling {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.crmpro.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("archana1712");
		driver.findElement(By.name("password")).sendKeys("jobseeker");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(), 'Combined Form')]")).click();
		Thread.sleep(6000);
		driver.close();
		
		
	}

}
