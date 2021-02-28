package seleniumcodepractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FindBrokenLink {
	
	public static void main (String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a1005\\Desktop\\gecko\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.onlinesbi.com/");
	Thread.sleep(1000);
	
	// To perform right click
	
	WebElement linkname=driver.findElement(By.xpath(".//*[@id='osbi_logo']"));
	Actions act = new Actions(driver);
	act.contextClick(linkname).build().perform();

		
	// first get the list of all the links & images to be checked (clicked)
	List<WebElement> linklist = driver.findElements(By.tagName("a"));
	List<WebElement> imglist = driver.findElements(By.tagName("img"));
	//other way to add element with 'a' tag and 'img' tag
	linklist.addAll(imglist);
	
	//Now in this step we are adding all the objects with 'a' tags (from above step), i.e all links & images will be added since it comes with 'a' tag
	//linklist.addAll(driver.findElements(By.tagName("img")));
	System.out.println("Total number of links and images in the webpage is "+linklist.size());
	
	// we will create one more list with all active links i.e have "href" property, we will ignore the links which don't have "href" property
	List<WebElement> activelinks = new ArrayList<WebElement>();
	
	//Now we need to iterate linklist having all images (img) and links (a)
	for (int i=0;i<linklist.size();i++) {
	// exclude all all the links/img which doesn't have "href" property
	if (linklist.get(i).getAttribute("href") != null) {
		activelinks.add(linklist.get(i));
		}
	}
	
	// Now we will print the size (number) of all active links
	System.out.println("Total of active links and images in the webpage is "+activelinks.size());
	driver.close();
	
	}
}
