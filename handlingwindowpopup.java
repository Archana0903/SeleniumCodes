package seleniumcodepractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handlingwindowpopup {
	
	public static void main (String[] args) throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();
		Thread.sleep(1000);
		
		//to handle mutiple windows we use "getWindowHandles", i.e parent window & child window
		Set<String> handler = driver.getWindowHandles();
		
		//to handle mutiple object i.e child & parent object we are using iterator
		Iterator<String> it = handler.iterator();
		
		// to move the control from one object to other object we use "it.next()"
		String parentwin = it.next();
		driver.switchTo().window("parentwin");
		Thread.sleep(1000);
		System.out.println("Parent window id is "+parentwin);
		driver.close();
		
		// same way we can get the id for second window i.e child window
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(1000);
		System.out.println("Child window id is "+childwindow);
		driver.close();
		driver.switchTo().window(parentwin);
		Thread.sleep(1000);
		System.out.println("Parent window title is "+ driver.getTitle());
		
	}

}
