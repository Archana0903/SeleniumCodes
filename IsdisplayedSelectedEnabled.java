package seleniumcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IsdisplayedSelectedEnabled {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://hub.uhg.com/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		
		boolean image = driver.findElement(By.xpath(".//*[@id='DeltaSiteLogo']/a/img")).isDisplayed();
		System.out.println(image);
		Thread.sleep(1000);
		
		boolean button = driver.findElement(By.xpath(".//*[@id='btnMyTasks']")).isEnabled();
		System.out.println(button);
		Thread.sleep(1000);
		
		boolean radiobtn = driver.findElement(By.id("ctl00_ctl45_g_ccb5f524_7f7c_4e69_9539_2bed52589284_ctl00_ctl01_3")).isSelected();
		System.out.println(radiobtn);
		
		driver.close();
	}

}
