package seleniumcodepractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecuter {
	
	public static void main (String[] args) {
	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.spicejet.com/");
	
	// to highlight the object in webpage
	
	
	
	}

}
