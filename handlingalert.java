package seleniumcodepractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handlingalert {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
	
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Alert message is displayed correctly");
		}
		else {
			System.out.println("Incoreect alert message is displayed");
		} 
		
		alert.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.id("login1")).sendKeys("Archana");
		driver.findElement(By.name("proceed")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		String text2= alert2.getText();
		System.out.println(text2);
		
		if (text2.equals("Please enter your password")) {
			System.out.println("Correct alert message for password field");
		}
		else
			System.out.println("Incorrect alert message for password field");
		
		alert.accept();
		
		driver.close();
	}

}
