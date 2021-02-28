package seleniumcodepractice;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class SpicejetAutomationPractice {
	
	
	public static void main (String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\geckodriver.exe");
		
		
		String ss;
		ss = "SeleniumFramework" + File.separator + "lib" + File.separator + "chromedriver.exe";
		System.out.println("SS: " + ss);
		System.setProperty("webdriver.chrome.driver", ss);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, ss);
		ChromeDriverService service = ChromeDriverService.createDefaultService();
		ChromeOptions options = new ChromeOptions();
		
		
		
		Thread.sleep(3000);

		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@title='Search' and @role='combobox' and @name='q']")).sendKeys("Spicejet");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='btnK' and @type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='vn1s0p1c0']/h3")).click();
		Thread.sleep(6000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(".//*[@id='highlight-addons']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Hot Meals')]")).click();
		Thread.sleep(5000);
		//String parent=driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='PnrExamplePopUp']")).click();
		Thread.sleep(5000);
		
		//handling window pop-up
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parent=it.next();
		String childwin=it.next();
		driver.switchTo().window(childwin);
		Thread.sleep(2000);
		System.out.println("Child window id is ::" + childwin);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("Window maximized");
		
		//driver.close();
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		Thread.sleep(3000);

		//String parentwin = it.next();
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		System.out.println("Parent window id is :: "+ parent);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='ControlGroupRetrieveBookingView_BookingRetrieveInputRetrieveBookingView_CONTACTEMAIL1']")).sendKeys("Test");
		System.out.println("Text entered");
		Thread.sleep(2000);
		driver.close();
		System.out.println("Closed Parent window");
		
		//finding broker links on the page
		/*
		List<WebElement> alinks = driver.findElements(By.tagName("a"));
		List<WebElement> imglinks = driver.findElements(By.tagName("img"));
		alinks.addAll(imglinks);
		System.out.println("Total number of links available in the page is ::" +alinks.size());
		
		List<WebElement> activelink = new ArrayList<WebElement>();
		for (int i=0; i<alinks.size();i++) {
			if (alinks.get(i).getAttribute("href") != null) {
			activelink.add(alinks.get(i));
			}
			
		}
		System.out.println("Total number of active links available in the page is ::"+ activelink.size()); */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,15000)");
		System.out.println("Page scrolled successfully");
		boolean logo = driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div[1]/a")).isDisplayed();
		System.out.println(logo);
		boolean btnenabled = driver.findElement(By.xpath(".//*[@id='ControlGroupRetrieveBookingView_BookingRetrieveInputRetrieveBookingView_ButtonRetrieve']")).isEnabled();
		System.out.println(btnenabled);
		
		// working with table in Add-ons >-- SpiceMax
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(driver.findElement(By.xpath(".//*[@id='highlight-addons']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),' SpiceMax')]")).click();
		Thread.sleep(3000);
		boolean privilegetxt = driver.findElement(By.xpath("")).isDisplayed();
		
		
	}

}
