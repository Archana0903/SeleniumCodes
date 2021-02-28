package seleniumcodepractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class performgooglesearch {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.id("lst-ib")).sendKeys("Testing");
		Thread.sleep(900);
		
		// now since we need to collect number of elements from google suggestion we use "findElements", and then xpath need to be customized to pick the result from suggestion box.
		//revise more on creating the cutomized Xpath for for findElements
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		System.out.println("Total number of suggestion in searchbox is---- >>>> " +list.size());
		
		//for printing all the items in the searchbox
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
		
		//for selecting specific item from the list
		
		if (list.get(i).getText().equals("testing tools")) {
			list.get(i).click();
			break;
		}
		Thread.sleep(2000);	
		driver.close();
		
		
	}

	}}
