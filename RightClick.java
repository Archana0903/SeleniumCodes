package FAQcodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
	
	public static void main (String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.automationtesting.in/WebTable.html"); // for double click action.
	//driver.get("https://www.onlinesbi.com/");  // for right click action
	Thread.sleep(5000);
	
	//******************************For Right Click*******************************************************
	/*
	WebElement linkname = driver.findElement(By.xpath(".//*[@id='osbi_logo']"));
	Actions ac = new Actions(driver);
	ac.contextClick(linkname).build().perform();  */
	
	//*******************************For Double Click*****************************************************
	WebElement linkname1 = driver.findElement(By.xpath(".//*[@id='1540979957091-0-uiGrid-000B-cell']/user-click-select/div[1]/button"));
	Actions ac1 = new Actions(driver);
	ac1.doubleClick(linkname1).build().perform();
	
	
	driver.close();
	
	
	
	
	
	}

}
