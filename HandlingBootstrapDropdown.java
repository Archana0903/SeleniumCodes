package seleniumcodepractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingBootstrapDropdown {
	
public static void main (String[] args) throws InterruptedException {

	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
	List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
	System.out.println(list.size());
	for (int i=0;i<=list.size();i++) {
	System.out.println(list.get(i).getText());	
	if (list.get(i).getText().equals("C#")) {
		list.get(i).click();
		break;
	}
	}
	
	
	
	
}

}
