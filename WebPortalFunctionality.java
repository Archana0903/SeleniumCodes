package seleniumcodepractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPortalFunctionality {
	
public static void main (String[] args) throws InterruptedException {

	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://uhgvision-pwp-q2.spectera.com/PWP/Landing");
	Thread.sleep(3000);
	
	driver.findElement(By.id("UserName")).sendKeys("DOPT46111");
	driver.findElement(By.id("Password")).sendKeys("Temp2019!");
	driver.findElement(By.id("LoginBlockButton")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("DateOfServiceTextBox")).clear();
	Thread.sleep(2000);
	driver.findElement(By.id("DateOfServiceTextBox")).sendKeys("10102018");
	Thread.sleep(2000);
	driver.findElement(By.id("SubscriberId1TextBox")).sendKeys("882657408");
	Thread.sleep(2000);
	driver.findElement(By.id("VerifyButton")).click();
	Thread.sleep(3000);
	
	List<WebElement> selectbtn = driver.findElements(By.xpath(".//*[@id='ResultSelectButton']"));
	System.out.println("Total number of select button is "+selectbtn.size());
	
	String before_xpath = ".//*[@id='search-results']/tbody/tr[";
	String after_xpath = "]/td[1]";
	
	for (int i=1;i<=selectbtn.size();i++) {
	String mem_name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
	System.out.println(mem_name);
	
	if (mem_name.equals("SPENCER NELSON")) {
	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[3]/div/div[3]/div[1]/div/div[3]/wbx-eligibility-results/table/tbody/tr["+i+"]/td[4]/div[1]/div[1]/button[1]")).click();	
	Thread.sleep(20000);
	boolean claimentry_page = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[1]/h3/span[1]")).isDisplayed();
	System.out.println(claimentry_page);
	Thread.sleep(3000);
	driver.findElement(By.id("FramesButton")).click();
	driver.findElement(By.id("LensesButton")).click();
	Thread.sleep(2000);
	System.out.println("clicked on benefit line successfully.");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(text(),'View Benefit Summary Report')]")).click();
	Thread.sleep(4000);
	
	//handling mutiple windows
	Set<String> handler = driver.getWindowHandles();
	Iterator<String> it = handler.iterator();
	String parentwin = it.next();
	System.out.println(parentwin);
	Thread.sleep(2000);
	driver.switchTo().window(parentwin);
	Thread.sleep(6000);
	System.out.println("switched window");
	driver.close();
	System.out.println("closed window");
	Thread.sleep(2000);
	String childwin = it.next();
	driver.switchTo().window(childwin);
	Thread.sleep(5000);
	System.out.println("Switched to child window");
	Thread.sleep(12000);
	driver.findElement(By.id("ContactFitButton")).click();
	System.out.println("Switched back to main window");
	
	;
	
	
	
	
	
	
		}
	}
	
	
	
	
	
}

}
