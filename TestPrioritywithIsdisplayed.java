package FAQcodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPrioritywithIsdisplayed {
	
	public static void main (String[] args) {
	
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.onlinesbi.com/");
		
		
		
		boolean yonobtn = driver.findElement(By.xpath(".//*[@id='banking']/div[1]/div/div/a[2]/img")).isEnabled();
		System.out.println(yonobtn);
		
		boolean sbilogo = driver.findElement(By.xpath(".//*[@id='osbi_logo']")).isDisplayed();
		System.out.println(sbilogo);
		
		boolean selectdd = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-default' and @type='button']")).isSelected();
		System.out.println(selectdd);
		
		
	}

}
